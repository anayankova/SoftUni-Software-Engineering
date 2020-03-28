package example.cardealer.services;

import example.cardealer.domains.entities.Supplier;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SupplierService {

    void seedSuppliers() throws FileNotFoundException, JAXBException;
    Supplier getRandomSupplier();
    Supplier getSupplierById(Long id);
    void getLocalSuppliers() throws JAXBException;
}
