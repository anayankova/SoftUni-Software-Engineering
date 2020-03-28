package com.example.gamestore.services;

import com.example.gamestore.dtos.*;

import java.util.List;

public interface GameService {

    void addGame(GameAddDto gameAddDto);
    void editGame(GameEditDto gameEditDto);
    void deleteGame(GameDeleteDto gameDeleteDto);
    List<GameViewDto> allGames();
    GameViewDto detailsGameByTitle(String title);
    UserPurchaseDto purchaseGamesForUser(UserLoginDto userLoginDto);
}
