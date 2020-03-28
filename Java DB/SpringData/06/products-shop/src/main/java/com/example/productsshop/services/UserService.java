package com.example.productsshop.services;

import com.example.productsshop.models.dtos.UserSeedDto;
import com.example.productsshop.models.dtos.UserSoldProductsDto;
import com.example.productsshop.models.entities.User;

import java.util.List;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);
    User getRandomUser();
    List<UserSoldProductsDto> getAllUsersBySoldProducts();
}
