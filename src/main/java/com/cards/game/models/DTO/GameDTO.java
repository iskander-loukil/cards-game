package com.cards.game.models.DTO;

import com.cards.game.helpers.CardsOrder;
import com.cards.game.helpers.GameConstants;
import com.cards.game.models.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameDTO implements Serializable {
    private List<Card> deck = new ArrayList<Card>(GameConstants.DECK_SIZE);
    private CardsOrder cardsOrder = new CardsOrder();
    private List<Card> sortedDeck = new ArrayList<Card>(GameConstants.DECK_SIZE);

    public GameDTO() {
    }

    /**
     *
     * @return initial deck of 10 cards
     */
    public List<Card> getDeck() {
        return deck;
    }

    /**
     *  sets initial deck
     * @param deck deck to set
     * @return the current game object
     */
    public GameDTO setDeck(List<Card> deck) {
        this.deck = deck;
        return this;
    }

    /**
     *
     * @return defined cards order (color order and card values order)
     */
    public CardsOrder getCardsOrder() {
        return cardsOrder;
    }

    /**
     * set cards order
     * @param cardsOrder cards order to set
     * @return the current game object
     */
    public GameDTO setCardsOrder(CardsOrder cardsOrder) {
        this.cardsOrder = cardsOrder;
        return this;
    }

    /**
     *
     * @return sorted deck
     */
    public List<Card> getSortedDeck() {
        return sortedDeck;
    }

    /**
     * sets sorted deck
     * @param sortedDeck sorted deck to set
     * @return current game object
     */
    public GameDTO setSortedDeck(List<Card> sortedDeck) {
        this.sortedDeck = sortedDeck;
        return this;
    }
}
