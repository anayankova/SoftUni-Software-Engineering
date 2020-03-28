package com.example.productsshop.services.impl;

import com.example.productsshop.models.dtos.CategorySeedDto;
import com.example.productsshop.models.entities.Category;
import com.example.productsshop.repositories.CategoryRepository;
import com.example.productsshop.services.CategoryService;
import com.example.productsshop.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        if(this.categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(categorySeedDtos)
                .forEach(categorySeedDto -> {
                    if (this.validatorUtil.isValid(categorySeedDto)) {
                        Category category = this.modelMapper
                                .map(categorySeedDto, Category.class);
                        this.categoryRepository.saveAndFlush(category);
                    }else {
                        this.validatorUtil.getViolations(categorySeedDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public List<Category> getRandomCategories() {
        Random random = new Random();
        List<Category> resultList = new ArrayList<>();
        int randomCounter = random.nextInt(3) + 1;
        for (int i = 0; i < randomCounter; i++) {
            long randomId = random.nextInt((int) this.categoryRepository.count()) + 1;
            resultList.add(this.categoryRepository.getOne(randomId));
        }
        return resultList;
    }
}
