package example.cardealer.services;

import com.google.gson.Gson;
import example.cardealer.domains.dtos.*;
import example.cardealer.domains.entities.Supplier;
import example.cardealer.repositories.SupplierRepository;
import example.cardealer.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    private final static String FILE_ADDRESS = "src\\main\\resources\\files\\suppliers.xml";
    private final static String FILE_ADDRESS_out = "src\\main\\resources\\files\\results\\suppliersOut.xml";
    private final SupplierRepository supplierRepository;
    private final XMLParser xmlParser;
    private final ModelMapper mapper;
    private final Gson gson;

    public SupplierServiceImpl(SupplierRepository supplierRepository, XMLParser xmlParser, ModelMapper mapper, Gson gson) {
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public void seedSuppliers() throws FileNotFoundException, JAXBException {
        SupplierSeedRootDto supplierSeedRootDto = xmlParser.importFromXml(SupplierSeedRootDto.class,FILE_ADDRESS);
        supplierSeedRootDto.getSuppliers().stream().map(c->mapper.map(c, Supplier.class)).forEach(supplierRepository::saveAndFlush);
}

    @Override
    public Supplier getRandomSupplier() {
        Long id =  (long) (Math.random() * (supplierRepository.count()))+1L;
        return supplierRepository.getById(id);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        Supplier supplier = supplierRepository.getById(id);
        return supplier;
    }

    @Override
    @Transactional
    public void getLocalSuppliers() throws JAXBException {
        List<Supplier> suppliers = supplierRepository.getLocalSuppliers();
        List<SupplierOutDto> supplierOutDtos = new ArrayList<>();
        for (Supplier s: suppliers){
            SupplierOutDto supplierOutDto = new SupplierOutDto(s.getId(),s.getName(),s.getPartsSupply().size());
            supplierOutDtos.add(supplierOutDto);
        }

        SupplierOutRootDto supplierOutRootDto = new SupplierOutRootDto();
        supplierOutRootDto.setSupplierOutDtos(supplierOutDtos);
        xmlParser.exportToXml(supplierOutRootDto,FILE_ADDRESS_out);

    }


}
