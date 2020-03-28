package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeSeedRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidatorUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static hiberspring.common.GlobalConstants.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser, BranchService branchService, EmployeeCardService employeeCardService) {
        this.employeeRepository = employeeRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
    }

    @Override
    public Boolean employeesAreImported() {
        return this.employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        EmployeeSeedRootDto employeeSeedRootDto = this.xmlParser
                .unmarshalFromFile(EMPLOYEES_FILE_PATH, EmployeeSeedRootDto.class);
        employeeSeedRootDto.getEmployees()
                .forEach(e -> {
                    if(this.validatorUtil.isValid(e)) {
                        if(this.employeeRepository.findByFirstNameAndLastNameAndPosition(
                                e.getFirstName(), e.getLastName(), e.getPosition()) == null) {
                            Employee employee = this.modelMapper.map(e, Employee.class);
                            Branch branch = this.branchService.getBranchByName(e.getBranch());
                            EmployeeCard employeeCard = this.employeeCardService.getCardByNumber(e.getCard());
                            employee.setBranch(branch);
                            employee.setCard(employeeCard);
                            this.employeeRepository.saveAndFlush(employee);
                            sb.append(String.format("Successfully imported Employee %s %s.",
                                    e.getFirstName(), e.getLastName()));
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
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

        return this.employeeRepository.findAllByBranchWithMoreThanOneProduct()
                .stream()
                .map(e -> {
                    return String.format("\nName: %s %s\n" +
                            "Position: %s\n" +
                            "Card Number: %s\n", e.getFirstName(),
                    e.getLastName(), e.getPosition(), e.getCard().getNumber());
                }).collect(Collectors.joining("-------------------"));
    }
}
