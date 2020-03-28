package com.example.productsshop.controllers;

import com.example.productsshop.constants.GlobalConstants;
import com.example.productsshop.models.dtos.*;
import com.example.productsshop.services.CategoryService;
import com.example.productsshop.services.ProductService;
import com.example.productsshop.services.UserService;
import com.example.productsshop.utils.FileUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class AppController implements CommandLineRunner {

    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final FileUtil fileUtil;

    @Autowired
    public AppController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService, FileUtil fileUtil) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
        this.writeProductsInRange();
        this.writeUsersSoldProducts();
    }

    private void writeUsersSoldProducts() throws IOException {
        List<UserSoldProductsDto> dtos = this.userService.getAllUsersBySoldProducts();
        String json = this.gson.toJson(dtos);
        this.fileUtil.write(json, GlobalConstants.USERS_SOLD_PRODUCTS);
    }

    private void writeProductsInRange() throws IOException {
        List<ProductInRangeDto> dtos = this.productService.getAllProductsInRange();
        String json = this.gson.toJson(dtos);
        this.fileUtil.write(json, GlobalConstants.PRODUCTS_IN_RANGE);
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] dtos = this.gson.fromJson(new FileReader
                (GlobalConstants.PRODUCTS_FILE_PATH), ProductSeedDto[].class);
        this.productService.seedProducts(dtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] dtos = this.gson.fromJson(new FileReader
                (GlobalConstants.USERS_FILE_PATH), UserSeedDto[].class);
        this.userService.seedUsers(dtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDto[] dtos = this.gson.fromJson(new FileReader
                        (GlobalConstants.CATEGORIES_FILE_PATH), CategorySeedDto[].class);
        this.categoryService.seedCategories(dtos);
    }
}
