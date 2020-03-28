package example.cardealer.services;

import example.cardealer.domains.entities.Car;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface CarService {
    void seedCars() throws FileNotFoundException, JAXBException;
    Car getRandomCar();
    Car getCarById(Long id);
    void getOrderedCarsByMake(String make) throws JAXBException;
    void getCarsWithParts() throws JAXBException;
    Long getCarsCount();
}
