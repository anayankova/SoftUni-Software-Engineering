package example.cardealer.services;

import com.google.gson.Gson;
import example.cardealer.domains.dtos.*;
import example.cardealer.domains.entities.Car;
import example.cardealer.domains.entities.Part;
import example.cardealer.repositories.CarRepository;
import example.cardealer.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private final static String FILE_ADDRESS = "src\\main\\resources\\files\\cars.xml";
    private final static String FILE_ADDRESS_OUT = "src\\main\\resources\\files\\results\\carsOut.xml";
    private final static String FILE_ADDRESS_OUT2 = "src\\main\\resources\\files\\results\\carsPartsOut.xml";
    private final CarRepository carRepository;
    private final PartsService partsService;
    private final XMLParser xmlParser;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartsService partsService, XMLParser xmlParser, ModelMapper mapper, Gson gson) {
        this.carRepository = carRepository;
        this.partsService = partsService;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    @Transactional
    public void seedCars() throws FileNotFoundException, JAXBException {
        CarSeedRootDto carsDtos = xmlParser.importFromXml(CarSeedRootDto.class,FILE_ADDRESS);
            for (CarSeedDto s: carsDtos.getCarsDtos()){
                Car car = mapper.map(s,Car.class);
                Set<Part> parts = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                    parts.add(partsService.getRandomPart());
                }
                car.setPartsSet(parts);
                carRepository.saveAndFlush(car);
            }
    }

    @Override
    public Car getRandomCar() {
        Long id =  (long) (Math.random() * (carRepository.count()))+1L;
        return carRepository.getById(id);
    }

    @Override
    @Transactional
    public Car getCarById(Long id) {
        Car car = carRepository.getById(id);
        return car;
    }

    @Override
    public Long getCarsCount() {
        return carRepository.count();
    }

    @Override
    public void getOrderedCarsByMake(String make) throws JAXBException {
        List<Car> cars = carRepository.getCarsByMake(make);
        List<CarOutDto> carOutDtos = cars.stream().map(c->mapper.map(c,CarOutDto.class)).collect(Collectors.toList());
        CarOutRootDto carOutRootDto = new CarOutRootDto();
        carOutRootDto.setCarsDto(carOutDtos);
        xmlParser.exportToXml(carOutRootDto,FILE_ADDRESS_OUT);
    }

    @Override
    @Transactional
    public void getCarsWithParts() throws JAXBException {
        List<Car> cars = carRepository.getAllCars();
        List<CarPartsOutDto> carPartsOutDtos = new ArrayList<>();
        for (Car c: cars){
            List<PartOutDto> partsOutDtos = c.getPartsSet().stream().map(p->mapper.map(p,PartOutDto.class)).collect(Collectors.toList());
            PartOutRootDto partOutRootDto = new PartOutRootDto();
            partOutRootDto.setPartOutDtos(partsOutDtos);
            CarPartsOutDto carPartsOutDto = new CarPartsOutDto(c.getMake(),c.getModel(),c.getTravelledDistance(),partOutRootDto);
            carPartsOutDtos.add(carPartsOutDto);
        }
        CarPartsOutRootDto carPartsOutRootDto = new CarPartsOutRootDto();
        carPartsOutRootDto.setCarsOut(carPartsOutDtos);
        xmlParser.exportToXml(carPartsOutRootDto,FILE_ADDRESS_OUT2);
    }

}
