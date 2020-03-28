package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductSeedRootDto;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidatorUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hiberspring.common.GlobalConstants.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final BranchService branchService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, XmlParser xmlParser, BranchService branchService) {
        this.productRepository = productRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCTS_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        ProductSeedRootDto productSeedRootDto = this.xmlParser.unmarshalFromFile( PRODUCTS_FILE_PATH, ProductSeedRootDto.class);
        productSeedRootDto.getProducts()
                .forEach(p -> {
                    if(this.validatorUtil.isValid(p)){
                        if(this.productRepository.findByName(p.getName()) == null) {
                            Product product = this.modelMapper.map(p, Product.class);
                            Branch branch = this.branchService.getBranchByName(p.getBranch());
                            product.setBranch(branch);
                            this.productRepository.saveAndFlush(product);
                            sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Product", p.getName()));
                        }else {
                            sb.append(EXIST_DATA_MESSAGE);
                        }
                    }else {
                        sb.append(INCORRECT_DATA_MESSAGE);
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }
}
