package com.example.gamestore.dtos;

import com.example.gamestore.entities.Game;

import java.util.Set;

public class UserPurchaseDto {

    private Set<Game> games;

    public UserPurchaseDto() {
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
