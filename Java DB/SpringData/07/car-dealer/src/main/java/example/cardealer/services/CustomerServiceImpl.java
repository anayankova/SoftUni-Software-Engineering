package example.cardealer.services;

import com.google.gson.Gson;
import example.cardealer.domains.dtos.*;
import example.cardealer.domains.entities.Customer;
import example.cardealer.repositories.CustomerRepository;
import example.cardealer.utils.ValidationUtil;
import example.cardealer.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final static String FILE_ADDRESS = "src\\main\\resources\\files\\customers.xml";
    private final static String FILE_ADDRESS_OUT = "src\\main\\resources\\files\\results\\customersOut.xml";
    private final static String FILE_ADDRESS_OUT1 = "src\\main\\resources\\files\\results\\customersWithCarOut.xml";
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final XMLParser xmlParser;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, XMLParser xmlParser, ModelMapper mapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public void seedCustomers() throws FileNotFoundException, JAXBException {
        CustomerSeedRootDto rootCustomer = xmlParser.importFromXml(CustomerSeedRootDto.class,FILE_ADDRESS);
        for (CustomerSeedDto c: rootCustomer.getCustomers()){
            if(validationUtil.isValid(c)) {
                Customer customer = new Customer(c.getName(),c.getBirthDate(),c.getYoungDriver());
                customerRepository.saveAndFlush(customer);
            }else{
                validationUtil.getViolation(c).forEach(System.out::println);
            }
        }
    }

    @Override
    public Customer getRandomCustomer() {
        Long id =  (long) (Math.random() * (customerRepository.count()))+1L;
        return customerRepository.getById(id);
    }

    @Override
    @Transactional
    public void getCustomerOrderedByDate() throws JAXBException {
        List<Customer> customers = customerRepository.getCustomerOrderedByDate();
        List<CustomersOutDto> customersOutDtos = customers.stream().map(c->mapper.map(c,CustomersOutDto.class)).collect(Collectors.toList());
        CustomersOutRootDto customersOutRootDto = new CustomersOutRootDto();
        customersOutRootDto.setCustomersOutDtos(customersOutDtos);
        xmlParser.exportToXml(customersOutRootDto,FILE_ADDRESS_OUT);
    }

    @Override
    @Transactional
    public void getCustomerWithCar() throws JAXBException {
        List<Object[]> objects = customerRepository.getCustomerWithCar();
        List<CustomerWithCarOutDto> customerWithCarDtos = new ArrayList<>();
        for (Object[] o: objects){
            Customer customer = (Customer)o[0];
            String name = customer.getName();
            int boughtCars = customer.getSalesSet().size();
            BigDecimal sum = new BigDecimal(o[1].toString());
            sum = sum.setScale(2, RoundingMode.HALF_UP);
            CustomerWithCarOutDto customerWithCarDto = new CustomerWithCarOutDto(name,boughtCars,sum);
            customerWithCarDtos.add(customerWithCarDto);
        }
         CustomerWithCarRootDto customerWithCarRootDto =  new CustomerWithCarRootDto(customerWithCarDtos);
        xmlParser.exportToXml(customerWithCarRootDto,FILE_ADDRESS_OUT1);

    }


}
