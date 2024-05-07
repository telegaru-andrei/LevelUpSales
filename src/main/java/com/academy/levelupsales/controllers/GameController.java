package com.academy.levelupsales.controllers;

import com.academy.levelupsales.entities.Game;
import com.academy.levelupsales.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "https//localhost:4200/")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game){
        return new ResponseEntity<>(gameService.save(game), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id){
        Game foundGame = gameService.getGame(id);
        if (foundGame == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundGame, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@RequestBody Game game,@PathVariable Long id){
        Game updateGame = gameService.updateGame(game, id);
        return updateGame == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(updateGame, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable Long id){
        Game deleteGame = gameService.deleteGameById(id);
        return deleteGame == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(deleteGame, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<>(gameService.getAllGame(), HttpStatus.OK);
    }
}
