package com.example.cardealerxml.controllers;

import com.example.cardealerxml.constants.GlobalConstants;
import com.example.cardealerxml.models.dtos.*;
import com.example.cardealerxml.services.*;
import com.example.cardealerxml.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static com.example.cardealerxml.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {

    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public AppController(XmlParser xmlParser, SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {

        //this.seedSuppliers();
        //this.seedParts();
        //this.seedCars();
        //this.seedCustomers();
        //this.seedSales();

        //this.writeOrderedCustomers();
        //this.writeCarsByMakeToyota();
        //this.writeLocalSuppliers();
        this.writeCarsWithParts();

    }

    private void writeCarsWithParts() throws JAXBException {
        CarWithPartsViewRootDto carWithPartsViewRootDto =
                this.carService.getAllCarsWithParts();

        this.xmlParser
                .marshalToFile(CARS_AND_PARTS_FILE_PATH, carWithPartsViewRootDto);
    }

    private void writeLocalSuppliers() throws JAXBException {
        SupplierViewRootDto supplierViewRootDto =
                this.supplierService.getAllLocalSuppliers();

        this.xmlParser
                .marshalToFile(LOCAL_SUPPLIERS_FILE_PATH, supplierViewRootDto);
    }

    private void writeCarsByMakeToyota() throws JAXBException {
        CarViewRootDto carViewRootDto =
                this.carService.getAllCarsByMake();

        this.xmlParser
                .marshalToFile(TOYOTA_CARS_FILE_PATH, carViewRootDto);
    }

    private void writeOrderedCustomers() throws JAXBException {
        CustomerViewRootDto customerViewRootDto =
                this.customerService.getAllOrderedCustomers();

        this.xmlParser
                .marshalToFile(ORDERED_CUSTOMERS_FILE_PATH, customerViewRootDto);
    }

    private void seedSales() {
        this.saleService.seedSales();
    }

    private void seedCustomers() throws JAXBException, FileNotFoundException {
        CustomerSeedRootDto customerSeedRootDto = this.xmlParser
                .unmarshalFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class);

        this.customerService.seedCustomers(customerSeedRootDto.getCustomers());
    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        CarSeedRootDto carSeedRootDto = this.xmlParser
                .unmarshalFromFile(CARS_FILE_PATH, CarSeedRootDto.class);


        this.carService.seedCars(carSeedRootDto.getCars());
    }

    private void seedParts() throws JAXBException, FileNotFoundException {
        PartSeedRootDto partSeedRootDto = this.xmlParser
                .unmarshalFromFile(PARTS_FILE_PATH, PartSeedRootDto.class);


        this.partService.seedParts(partSeedRootDto.getParts());
    }

    private void seedSuppliers() throws JAXBException, FileNotFoundException {
       SupplierSeedRootDto supplierSeedRootDto = this.xmlParser
               .unmarshalFromFile(SUPPLIERS_FILE_PATH,SupplierSeedRootDto.class );

       this.supplierService.seedSuppliers(supplierSeedRootDto.getSuppliers());
    }
}
