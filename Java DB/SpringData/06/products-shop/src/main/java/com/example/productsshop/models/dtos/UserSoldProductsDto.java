package com.example.productsshop.models.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserSoldProductsDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductsSoldDto> soldProducts;

    public UserSoldProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductsSoldDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductsSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
