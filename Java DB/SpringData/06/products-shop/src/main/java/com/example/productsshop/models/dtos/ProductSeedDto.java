package com.example.productsshop.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ProductSeedDto {

    @Expose
    @Length(min = 3, message = "Product name is not valid")
    private String name;
    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
