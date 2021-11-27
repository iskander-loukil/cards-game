package com.cards.game.services;


import com.cards.game.helpers.CardsOrder;
import com.cards.game.helpers.GameConstants;
import com.cards.game.models.Card;
import com.cards.game.models.CardValue;
import com.cards.game.models.Color;
import com.cards.game.models.DTO.GameDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameService {
    private static Logger logger = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private OrderGenerator orderGenerator;

    public List<Card> generateDeck(){
        List<Card> deck = new ArrayList<>(10);
        for (int i = 0; i < 10; i++){
            deck.add(generateRandomCard());
        }
        logger.debug("generated a new deck of cards! {}", deck);
        return deck;
    }

    private Card generateRandomCard() {
      Color randomColor =  Color.values()[new Random().nextInt(GameConstants.NUMBER_OF_COLORS)];
      CardValue randomCardValue = CardValue.values()[new Random().nextInt(GameConstants.NUMBER_OF_CARD_VALUES)];
      return new Card(randomColor,randomCardValue);
    }

    public GameDTO generateNewGame(){
        logger.debug("Starting a new game!");
        GameDTO game = new GameDTO();
        List<Card> deck = this.generateDeck();
        CardsOrder cardsOrder = this.orderGenerator.generateCardsOrder();
       return   game.setDeck(deck)
                .setCardsOrder(cardsOrder)
               .setSortedDeck(sortDeck(deck,cardsOrder));

    }

    public List<Card> sortDeck(List<Card> deck, CardsOrder cardsOrder) {
        return deck.stream()
                .sorted(orderGenerator.getCardsComparator(cardsOrder))
                .collect(Collectors.toList());
    }

}
