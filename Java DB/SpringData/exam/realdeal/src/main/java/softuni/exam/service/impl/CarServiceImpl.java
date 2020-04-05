package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.carRepository = carRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstants.CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        CarSeedDto[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.CARS_FILE_PATH), CarSeedDto[].class);
        Arrays.stream(dtos)
                .forEach(c -> {
                    if(this.validatorUtil.isValid(c)) {
                        if (this.carRepository.findByMakeAndModelAndKilometers(
                                c.getMake(), c.getModel(), c.getKilometers()) == null) {
                            LocalDate localDate = LocalDate.parse(c.getRegisteredOn(),
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            Car car = this.modelMapper.map(c, Car.class);
                            car.setRegisteredOn(localDate);
                            this.carRepository.saveAndFlush(car);
                            sb.append(String.format("Successfully imported car - %s - %s", c.getMake(), c.getModel()));
                        }else {
                            sb.append("Already in DB");
                        }
                    }else {
                        sb.append("Invalid car");
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }

    @Override
    public Optional<Car> getCarbyId(Long id) {
        return this.carRepository.findById(id);
    }
}
