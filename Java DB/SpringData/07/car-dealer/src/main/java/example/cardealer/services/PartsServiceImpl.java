package example.cardealer.services;

import com.google.gson.Gson;
import example.cardealer.domains.dtos.PartsSeedDto;
import example.cardealer.domains.dtos.PartsSeedRootDto;
import example.cardealer.domains.entities.Part;
import example.cardealer.repositories.PartRepository;
import example.cardealer.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Service
public class PartsServiceImpl implements PartsService{
    private final static String FILE_ADDRESS = "src\\main\\resources\\files\\parts.xml";
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final XMLParser xmlParser;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public PartsServiceImpl(PartRepository partRepository, SupplierService supplierService, XMLParser xmlParser, ModelMapper mapper, Gson gson) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.gson = gson;
    }




//    @Override
//    @Transactional
//    public void seedParts() throws FileNotFoundException {
//        SeedPartsDto[] partsDtos = gson.fromJson(new FileReader(FILE_ADDRESS),SeedPartsDto[].class);
//        for (SeedPartsDto s: partsDtos){
//            Part part = mapper.map(s,Part.class);
//            part.setSupplier(supplierService.getRandomSupplier());
////            part.getCars().add(carService.getRandomCar());
//            partsRepository.saveAndFlush(part);
//        }
//
//    }

    @Override
    @Transactional
    public void seedParts() throws FileNotFoundException, JAXBException {
        PartsSeedRootDto partsDtos = xmlParser.importFromXml(PartsSeedRootDto.class,FILE_ADDRESS);


        for (PartsSeedDto s: partsDtos.getParts()){
            Part part = mapper.map(s, Part.class);
            part.setSupplier(supplierService.getRandomSupplier());
//            part.getCars().add(carService.getRandomCar());
            partRepository.saveAndFlush(part);
        }
    }

    @Override
    public Part getRandomPart() {
        Long id =  (long) (Math.random() * (partRepository.count()))+1L;
        return partRepository.getById(id);
    }
}
