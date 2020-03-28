package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.TownSeedDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.*;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.townRepository = townRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns(String townsFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        TownSeedDto[] dtos = this.gson.fromJson(new FileReader(TOWNS_FILE_PATH), TownSeedDto[].class);
        Arrays.stream(dtos)
                .forEach(t -> {
                    if(this.validatorUtil.isValid(t)) {
                        if(this.townRepository.findByName(t.getName()) == null) {
                            Town town = this.modelMapper.map(t, Town.class);
                            this.townRepository.saveAndFlush(town);
                            sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Town", t.getName()));
                        }else {
                            sb.append(EXIST_DATA_MESSAGE);
                        }
                    }else {
                        sb.append(INCORRECT_DATA_MESSAGE);
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }

    @Override
    public Town getTownByName(String name) {
        return this.townRepository.findByName(name);
    }
}
