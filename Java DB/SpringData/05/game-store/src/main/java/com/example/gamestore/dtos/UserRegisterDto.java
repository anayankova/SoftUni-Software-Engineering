package com.example.gamestore.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterDto {

    private String email;
    private String password;
    private String fullName;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    @Pattern(regexp = ".+@.+\\..+", message = "Email is not valid")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "[A-Z]+[a-z]+[0-9]+", message = "Password not valid")
    @Size(min = 6, message = "Password length not valid")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Full name must not be null")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
