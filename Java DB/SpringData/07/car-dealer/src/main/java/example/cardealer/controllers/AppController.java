package example.cardealer.controllers;

import com.google.gson.Gson;
import example.cardealer.services.*;
import example.cardealer.utils.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;


@Component
public class AppController implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final SupplierService supplierService;
    private final CarService carService;
    private final PartsService partsService;
    private final CustomerService customerService;
    private final SalesService salesService;
    private final Gson gson;
    private final XMLParser xmlParser;

    @Autowired
    public AppController(BufferedReader bufferedReader, SupplierService supplierService, CarService carService, PartsService partsService, CustomerService customerService, SalesService salesService, Gson gson, XMLParser xmlParser) {
        this.bufferedReader = bufferedReader;
        this.supplierService = supplierService;
        this.carService = carService;
        this.partsService = partsService;
        this.customerService = customerService;
        this.salesService = salesService;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {


//                        XML PART



        customerService.seedCustomers();
        supplierService.seedSuppliers();
        partsService.seedParts();
        carService.seedCars();
        salesService.seedSales();

//      6.Q1  ORDERED CUSTOMERS  -  RESULT IS STORED IN  RESOURCES\\FILES\\RESULTS\\sortedCustomer.json
//          customerService.getCustomerOrderedByDate();

//      6.Q2 CARS FROM MAKE TOYOTA - RESULT IS STORED IN  RESOURCES\\FILES\\RESULTS\\orderedCarsByMake.json
//          carService.getOrderedCarsByMake("Toyota");

//      6.Q3 LOCAL SUPPLIERS - RESULT IS STORED IN  RESOURCES\\FILES\\RESULTS\\localSuppliers.json
//          supplierService.getLocalSuppliers();

//       6.Q4  CARS WITH THEIR LIST OF PARTS - RESULT IS STORED IN RESOURCES\\FILES\\RESULTS\\carsWithParts.json
//            carService.getCarsWithParts();

//       6.Q6  SALES WITH APPLIED DISCOUNT - RESULT IS STORED IN  RESOURCES\\FILES\\RESULTS\\soldCars.json
//            customerService.getCustomerWithCar();

//        List<CustomerWithCarDto> customers = customerService.getCustomerWithCar();
            salesService.getSalesCarInfo();



        System.out.println("It seems to work properly ;)");
    }
}
