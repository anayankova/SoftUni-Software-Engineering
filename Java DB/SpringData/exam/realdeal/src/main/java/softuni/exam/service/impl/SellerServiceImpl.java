package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstants.SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        SellerSeedRootDto sellerSeedRootDto = this.xmlParser.unmarshalFromFile(GlobalConstants.SELLERS_FILE_PATH,
                SellerSeedRootDto.class);
        sellerSeedRootDto.getSellers()
                .forEach(s -> {
                    if(this.validatorUtil.isValid(s)) {
                        if(this.sellerRepository.findByEmail(s.getEmail()) == null){
                            Seller seller = this.modelMapper.map(s, Seller.class);
                            this.sellerRepository.saveAndFlush(seller);
                            sb.append(String.format("Successfully import %s - %s", s.getLastName(), s.getEmail()));
                        }else {
                            sb.append("Already in DB");
                        }
                    }else {
                        sb.append("Invalid seller");
                    }
                    sb.append(System.lineSeparator());
                });

        return sb.toString();
    }
}
