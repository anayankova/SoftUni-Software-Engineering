package example.cardealer.services;

import example.cardealer.domains.entities.Customer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CustomerService {
    void seedCustomers() throws FileNotFoundException, JAXBException;
    Customer getRandomCustomer();
    void getCustomerOrderedByDate() throws JAXBException;
    void getCustomerWithCar() throws JAXBException;


}
