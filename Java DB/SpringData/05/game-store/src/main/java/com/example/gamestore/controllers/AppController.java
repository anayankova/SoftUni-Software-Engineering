package com.example.gamestore.controllers;

import com.example.gamestore.dtos.*;
import com.example.gamestore.services.GameService;
import com.example.gamestore.services.UserService;
import com.example.gamestore.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.validation.ConstraintViolation;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AppController  implements CommandLineRunner {

    private final BufferedReader bufferedReader;
    private final ValidatorUtil validatorUtil;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public AppController(BufferedReader bufferedReader, ValidatorUtil validatorUtil, UserService userService, GameService gameService) {
        this.bufferedReader = bufferedReader;
        this.validatorUtil = validatorUtil;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        UserLoginDto userLoginDto = new UserLoginDto();

        while (true) {
            System.out.println("Enter input:");
            String[] input = this.bufferedReader.readLine().split("\\|");

            switch (input[0]) {
                case "RegisterUser":
                    if(!input[2].equals(input[3])) {
                        System.out.println("Password don't match");
                        break;
                    }
                    UserRegisterDto userRegisterDto = new UserRegisterDto(input[1], input[2], input[4]);
                    if(this.validatorUtil.isValid(userRegisterDto)) {
                        this.userService.registerUser(userRegisterDto);
                        System.out.printf("%s was registered%n", input[4]);
                    }else {
                        this.validatorUtil.getViolations(userRegisterDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "LoginUser":
                    userLoginDto = new UserLoginDto(input[1], input[2]);
                    this.userService.loginUser(userLoginDto);
                    break;
                case "Logout":
                    this.userService.logout();
                    break;
                case "AddGame":
                    GameAddDto gameAddDto = new GameAddDto(input[1], new BigDecimal(input[2]),
                            Double.parseDouble(input[3]), input[4], input[5], input[6],
                            LocalDate.parse(input[7], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    if(this.validatorUtil.isValid(gameAddDto)) {
                            this.gameService.addGame(gameAddDto);
                    }else {
                        this.validatorUtil.getViolations(gameAddDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "EditGame":
                    String title = null;
                    BigDecimal price = null;
                    double size = 0;
                    String trailer = null;
                    String image = null;
                    String description = null;
                    LocalDate releaseDate = null;
                    for (int i = 2; i < input.length; i++) {
                        String property = input[i].substring(0, input[i].indexOf("="));
                        switch (property) {
                            case "title":
                                title = input[i].substring(input[i].indexOf("=") + 1);
                                break;
                            case "price":
                                price = new BigDecimal(input[i].substring(input[i].indexOf("=") + 1));
                                break;
                            case "size":
                                size = Double.parseDouble(input[i].substring(input[i].indexOf("=") + 1));
                                break;
                            case "trailer":
                                trailer = input[i].substring(input[i].indexOf("=") + 1);
                                break;
                            case "image":
                                image = input[i].substring(input[i].indexOf("=") + 1);
                                break;
                            case "description":
                                description = input[i].substring(input[i].indexOf("=") + 1);
                                break;
                            case "releaseDate":
                                releaseDate = LocalDate.parse(input[i].substring(input[i].indexOf("=") + 1),
                                        DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                break;
                        }
                    }
                    GameEditDto gameEditDto = new GameEditDto(Long.parseLong(input[1]), title, price,
                            size, trailer, image, description, releaseDate);
                    if(this.validatorUtil.isValid(gameEditDto)) {
                        this.gameService.editGame(gameEditDto);
                    }else {
                        this.validatorUtil.getViolations(gameEditDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "DeleteGame":
                    GameDeleteDto gameDeleteDto = new GameDeleteDto(Long.parseLong(input[1]));
                    if(this.validatorUtil.isValid(gameDeleteDto)) {
                        this.gameService.deleteGame(gameDeleteDto);
                    }else {
                        this.validatorUtil.getViolations(gameDeleteDto)
                                .stream().map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                    break;
                case "AllGames":
                    List<GameViewDto> allGames = this.gameService.allGames();
                    allGames.forEach(g -> System.out.printf("%s %.2f%n", g.getTitle(), g.getPrice()));
                    break;
                case "DetailsGame":
                    try {
                        GameViewDto gameViewDto = this.gameService.detailsGameByTitle(input[1]);
                        System.out.printf("Title: %s%n", gameViewDto.getTitle());
                        System.out.printf("Price: %.2f%n", gameViewDto.getPrice());
                        System.out.printf("Size: %.2f%n", gameViewDto.getSize());
                        System.out.printf("Trailer: %s%n", gameViewDto.getTrailer());
                        System.out.printf("Image: %s%n", gameViewDto.getImage());
                        System.out.printf("Description: %s%n", gameViewDto.getDescription());
                        System.out.println("Release date: " + gameViewDto.getReleaseDate());
                    }catch (IllegalArgumentException e) {
                        System.out.println("Not found game with such title");
                    }
                    break;
                case "OwnedGames":
                    try {
                        UserPurchaseDto userPurchaseDto = this.gameService.purchaseGamesForUser(userLoginDto);
                        userPurchaseDto.getGames().forEach(g -> System.out.printf("%s%n", g.getTitle()));
                    }catch (NullPointerException e) {
                        System.out.println("No logged in user");
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
