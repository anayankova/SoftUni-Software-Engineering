package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dtos.EmployeeCardSeedDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
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
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final EmployeeCardRepository employeeCardRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.employeeCardRepository = employeeCardRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean employeeCardsAreImported() {
        return this.employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        EmployeeCardSeedDto[] dtos = this.gson.fromJson(new FileReader(EMPLOYEE_CARDS_FILE_PATH), EmployeeCardSeedDto[].class);
        Arrays.stream(dtos)
                .forEach(e -> {
                    if(this.validatorUtil.isValid(e)) {
                        if(this.employeeCardRepository.findByNumber(e.getNumber()) == null) {
                            EmployeeCard employeeCard = this.modelMapper.map(e, EmployeeCard.class);
                            this.employeeCardRepository.saveAndFlush(employeeCard);
                            sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Employee Card", e.getNumber()));
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
    public EmployeeCard getCardByNumber(String number) {
        return this.employeeCardRepository.findByNumber(number);
    }
}
