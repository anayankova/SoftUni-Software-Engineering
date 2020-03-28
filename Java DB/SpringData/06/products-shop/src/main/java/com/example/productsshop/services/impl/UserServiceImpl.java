package com.example.productsshop.services.impl;

import com.example.productsshop.models.dtos.ProductsSoldDto;
import com.example.productsshop.models.dtos.UserSeedDto;
import com.example.productsshop.models.dtos.UserSoldProductsDto;
import com.example.productsshop.models.entities.Product;
import com.example.productsshop.models.entities.User;
import com.example.productsshop.repositories.UserRepository;
import com.example.productsshop.services.UserService;
import com.example.productsshop.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        if (this.userRepository.count() != 0) {
            return;
        }
        Arrays.stream(userSeedDtos)
                .forEach(userSeedDto -> {
                    if(this.validatorUtil.isValid(userSeedDto)) {
                        User user = this.modelMapper.map(userSeedDto, User.class);
                        this.userRepository.saveAndFlush(user);
                    }else {
                        this.validatorUtil.getViolations(userSeedDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        long randomId = random.nextInt((int) this.userRepository.count()) + 1;
        return this.userRepository.getOne(randomId);
    }

    @Override
    public List<UserSoldProductsDto> getAllUsersBySoldProducts() {
        return this.userRepository.findAllBySoldIsNotNull()
                .stream()
                .map(u -> {
                    UserSoldProductsDto userSoldProducts = this.modelMapper.map(u, UserSoldProductsDto.class);
                    List<Product> soldProducts = new ArrayList<>();
                    for (Product product : u.getSold()) {
                        if (product.getBuyer() != null) {
                            soldProducts.add(product);
                        }
                    }
                    List<ProductsSoldDto> productsSoldDtos = new ArrayList<>();
                    soldProducts.forEach(p -> {
                        ProductsSoldDto productsSoldDto = this.modelMapper.map(p, ProductsSoldDto.class);
                        productsSoldDto.setBuyerFirstName(p.getBuyer().getFirstName());
                        productsSoldDto.setBuyerLastName(p.getBuyer().getLastName());
                        productsSoldDtos.add(productsSoldDto);
                    });
                    userSoldProducts.setSoldProducts(productsSoldDtos);
                    return userSoldProducts;
                })
//                .sorted(Comparator.comparing(UserSoldProductsDto::getFirstName))
//                .sorted(Comparator.comparing(UserSoldProductsDto::getLastName))
                .collect(Collectors.toList());
    }
}
