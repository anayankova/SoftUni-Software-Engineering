package com.example.springdatabooks.services.impl;

import com.example.springdatabooks.constants.GlobalConstants;
import com.example.springdatabooks.entities.Category;
import com.example.springdatabooks.repositories.CategoryRepository;
import com.example.springdatabooks.services.CategoryService;
import com.example.springdatabooks.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if(this.categoryRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(GlobalConstants.CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent).forEach(r -> {
            Category category = new Category(r);
            this.categoryRepository.saveAndFlush(category);
        });
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> result = new HashSet<>();
        Random random = new Random();
        int bound = random.nextInt(3) + 1;
        for (int i = 0; i <= bound; i++) {
            int categoryId = random.nextInt(8) + 1;
            result.add(this.getCategoryById((long) categoryId));
        }
        return result;
    }
}
