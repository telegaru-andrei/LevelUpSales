package com.academy.levelupsales.services;

import com.academy.levelupsales.entities.Game;
import com.academy.levelupsales.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public Game getGame(Long id){
        Optional<Game> foundGame = gameRepository.findById(id);
        return foundGame.orElse(null);
    }

    public Game updateGame(Game game, Long id){
        Optional<Game> foundGame = gameRepository.findById(id);
        if (foundGame.isEmpty()){
            return null;
        }
        Game validObject = foundGame.get();
        validObject.setName(game.getName());
        validObject.setPrice(game.getPrice());
        validObject.setQuantity(game.getQuantity());
        validObject.setDescription(game.getDescription());

        gameRepository.save(validObject);
        return validObject;
    }

    public Game deleteGameById(Long id){
        Optional<Game> foundGame = gameRepository.findById(id);
        if (foundGame.isEmpty()){
            return foundGame.get();
        }
        gameRepository.deleteById(id);
        return foundGame.get();
    }

    public List<Game> getAllGame(){
        return gameRepository.findAll();
    }
}
