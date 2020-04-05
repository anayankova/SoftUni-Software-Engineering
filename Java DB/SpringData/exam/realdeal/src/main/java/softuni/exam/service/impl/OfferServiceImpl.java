package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.constants.GlobalConstants;
import softuni.exam.models.dtos.OfferSeedRootDto;
import softuni.exam.models.dtos.SellerSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstants.OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        OfferSeedRootDto offerSeedRootDto = this.xmlParser.unmarshalFromFile(GlobalConstants.OFFERS_FILE_PATH,
                OfferSeedRootDto.class);
        offerSeedRootDto.getOffers()
                .forEach(o -> {
                    if(this.validatorUtil.isValid(o)){
                        if(this.offerRepository.findByDescriptionAndAddedOn(o.getDescription(), o.getAddedOn()) == null){

                        }
                    }
                });

        return sb.toString();
    }
}
