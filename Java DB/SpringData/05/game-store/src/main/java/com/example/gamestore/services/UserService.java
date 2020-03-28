package com.example.gamestore.services;

import com.example.gamestore.dtos.UserLoginDto;
import com.example.gamestore.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);
    void loginUser(UserLoginDto userLoginDto);
    void logout();
    boolean isLoggedUserIsAdmin();
}
