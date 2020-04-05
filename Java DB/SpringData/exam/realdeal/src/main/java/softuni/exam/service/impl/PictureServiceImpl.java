package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.PictureSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final CarService carService;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson, CarService carService) {
        this.pictureRepository = pictureRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PictureSeedDto[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.PICTURES_FILE_PATH),
                PictureSeedDto[].class);
        Arrays.stream(dtos)
                .forEach(p -> {
                    if(this.validatorUtil.isValid(p)) {
                        if(this.pictureRepository.findByName(p.getName()) == null) {
                            LocalDateTime localDateTime = LocalDateTime.parse(p.getDateAndTime(),
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            Picture picture = this.modelMapper.map(p, Picture.class);
                            picture.setDateAndTime(localDateTime);
                            Optional<Car> car = this.carService.getCarbyId(p.getCar());
                            picture.setCar(car.orElse(null));
                            this.pictureRepository.saveAndFlush(picture);
                            sb.append(String.format("Successfully import picture - %s", p.getName()));
                        }else {
                            sb.append("Already in DB");
                        }
                    }else {
                        sb.append("Invalid picture");
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }
}
