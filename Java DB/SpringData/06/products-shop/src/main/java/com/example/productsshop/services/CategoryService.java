package com.example.productsshop.services;

import com.example.productsshop.models.dtos.CategorySeedDto;
import com.example.productsshop.models.entities.Category;

import java.util.List;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);
    List<Category> getRandomCategories();
}
