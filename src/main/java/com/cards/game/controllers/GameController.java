package com.cards.game.controllers;


import com.cards.game.models.DTO.GameDTO;
import com.cards.game.services.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GameController {
    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    GameService gameService;

    /**
     *  Generate a new game and render it to the client
     * @return GameDTO the generated game
     */
    @GetMapping("/new-game")
    public GameDTO newGame(){
        return gameService.generateNewGame();
    }




}
