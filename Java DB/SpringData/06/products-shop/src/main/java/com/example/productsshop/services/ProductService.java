package com.example.productsshop.services;

import com.example.productsshop.models.dtos.ProductInRangeDto;
import com.example.productsshop.models.dtos.ProductSeedDto;

import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);
    List<ProductInRangeDto> getAllProductsInRange();
}
