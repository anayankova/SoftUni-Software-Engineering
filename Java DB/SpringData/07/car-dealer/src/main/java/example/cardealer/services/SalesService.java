package example.cardealer.services;


import javax.xml.bind.JAXBException;

public interface SalesService {
    void seedSales();

    void getSalesCarInfo() throws JAXBException;

}
