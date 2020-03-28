package com.example.gamestore.services.impl;

import com.example.gamestore.dtos.*;
import com.example.gamestore.entities.Game;
import com.example.gamestore.entities.User;
import com.example.gamestore.repositories.GameRepository;
import com.example.gamestore.repositories.UserRepository;
import com.example.gamestore.services.GameService;
import com.example.gamestore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (checkForAdmin()) {
            Game game = this.modelMapper.map(gameAddDto, Game.class);
            this.gameRepository.saveAndFlush(game);
            System.out.printf("Added %s%n", game.getTitle());
        }
    }

    @Override
    public void editGame(GameEditDto gameEditDto) {
        if (checkForAdmin()) {
            if (this.gameRepository.existsById(gameEditDto.getId())) {
                Game game = this.gameRepository.findById(gameEditDto.getId()).orElseThrow();
                if (gameEditDto.getTitle() != null) {
                    game.setTitle(gameEditDto.getTitle());
                }
                if (gameEditDto.getPrice() != null) {
                    game.setPrice(gameEditDto.getPrice());
                }
                if (gameEditDto.getSize() != 0) {
                    game.setSize(gameEditDto.getSize());
                }
                if (gameEditDto.getTrailer() != null) {
                    game.setTrailer(gameEditDto.getTrailer());
                }
                if (gameEditDto.getImage() != null) {
                    game.setImage(gameEditDto.getImage());
                }
                if (gameEditDto.getDescription() != null) {
                    game.setDescription(gameEditDto.getDescription());
                }
                if (gameEditDto.getReleaseDate() != null) {
                    game.setReleaseDate(gameEditDto.getReleaseDate());
                }
                this.gameRepository.save(game);
                System.out.printf("Edited %s%n", game.getTitle());
            } else {
                System.out.println("Not found game with such id");
            }
        }
    }

    @Override
    public void deleteGame(GameDeleteDto gameDeleteDto) {
        if (checkForAdmin()) {
            if (this.gameRepository.existsById(gameDeleteDto.getId())) {
                Game game = this.gameRepository.findById(gameDeleteDto.getId()).orElseThrow();
                this.gameRepository.delete(game);
                System.out.printf("Deleted %s%n", game.getTitle());
            } else {
                System.out.println("Not found game with such id");
            }
        }
    }

    @Override
    public List<GameViewDto> allGames() {
        return this.gameRepository.findAll().stream()
                .map(g -> this.modelMapper.map(g, GameViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GameViewDto detailsGameByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title);
        return this.modelMapper.map(game, GameViewDto.class);
    }

    @Override
    public UserPurchaseDto purchaseGamesForUser(UserLoginDto userLoginDto) {
            User user = this.userRepository.findByEmail(userLoginDto.getEmail());
            Set<Game> purchaseGames = new HashSet<>(this.gameRepository.findAll());
            user.setGames(purchaseGames);
            return this.modelMapper.map(user, UserPurchaseDto.class);
    }

    private boolean checkForAdmin() {
        try {
            if (!this.userService.isLoggedUserIsAdmin()) {
                System.out.println("Logged user is not admin");
                return false;
            }
        } catch (NullPointerException e) {
            System.out.println("No logged in user");
            return false;
        }
        return true;
    }
}
