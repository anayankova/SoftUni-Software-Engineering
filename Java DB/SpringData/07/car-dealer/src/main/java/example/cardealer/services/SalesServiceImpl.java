package example.cardealer.services;

import com.google.gson.Gson;
import example.cardealer.domains.dtos.CarSoldOutDto;
import example.cardealer.domains.dtos.SalesOutDto;
import example.cardealer.domains.dtos.SalesOutRootDto;
import example.cardealer.domains.entities.Car;
import example.cardealer.domains.entities.Part;
import example.cardealer.domains.entities.Sale;
import example.cardealer.repositories.SaleRepository;
import example.cardealer.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class SalesServiceImpl implements SalesService{
    private final static String FILE_ADDRESS_OUT = "src\\main\\resources\\files\\results\\salesInfo.xml";
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final XMLParser xmlParser;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public SalesServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, XMLParser xmlParser, ModelMapper mapper, Gson gson) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.gson = gson;
    }


    @Override
    @Transactional
    public void getSalesCarInfo() throws JAXBException {

        List<Sale> sales = saleRepository.findAll();
        List<SalesOutDto> saleCarDtos = new ArrayList<>();
        for(Sale s: sales){
            Car car = s.getCar();
            CarSoldOutDto carExportDto = mapper.map(car,CarSoldOutDto.class);
            String name = s.getCustomer().getName();
            double discount = s.getDiscount();
            BigDecimal price = new BigDecimal(0);
            Set<Part> parts = s.getCar().getPartsSet();
            for (Part p: parts){
                price = price.add(p.getPrice());
            }
            BigDecimal priceWithDiscount = price.multiply(new BigDecimal(1-discount));
            priceWithDiscount = priceWithDiscount.setScale(2, RoundingMode.HALF_UP);

            SalesOutDto saleCarDto = new SalesOutDto(carExportDto,name,discount,price,priceWithDiscount);
            saleCarDtos.add(saleCarDto);
        }
        SalesOutRootDto salesOutRootDto = new SalesOutRootDto(saleCarDtos);
        xmlParser.exportToXml(salesOutRootDto,FILE_ADDRESS_OUT);
    }



    @Override
    @Transactional
    public void seedSales() {
        Long count = carService.getCarsCount();
        List<Long> ids = new ArrayList<>();
        Car car = new Car();
        for (int i = 0; i < 40; i++) {
            Sale sales = new Sale();
            while (true){
                Long id =  (long) (Math.random() * (count))+1L;
                if(!ids.contains(id)){
                    ids.add(id);
                    car = carService.getCarById(id);
                    break;
                }
            }
                sales.setCar(car);
                Random generator = new Random();
                double disc = 0.01*generator.nextInt(50);
            BigDecimal bd = new BigDecimal(Double.toString(disc));
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            disc =  bd.doubleValue();
                sales.setDiscount(disc);
                sales.setCustomer(customerService.getRandomCustomer());
                saleRepository.saveAndFlush(sales);
        }
        System.out.println();
    }


}
