package com.cards.game.services;

import com.cards.game.helpers.CardsOrder;
import com.cards.game.helpers.GameConstants;
import com.cards.game.models.Card;
import com.cards.game.models.CardValue;
import com.cards.game.models.Color;
import com.cards.game.models.DTO.GameDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GameServiceTest {
    @Autowired
    GameService gameService;


    /**
     * verify that a generated deck has the good deck size
     */
    @Test
    void test_generate_deck() {
        List<Card> deck = this.gameService.generateDeck();
        assertEquals(deck.size(), GameConstants.DECK_SIZE);
    }

    /**
     * verify that the sorted deck has the same card as the initial deck
     */
    @Test
    void test_generate_new_game() {
        GameDTO game = gameService.generateNewGame();
        assertEquals(new HashSet<Card>(game.getDeck()), new HashSet<Card>(game.getSortedDeck()));
    }

    /**
     * verify that sortdeck(...) sorts the deck with defined color order and card order
     */
    @Test
    void test_sort_deck() {
        List<Card> deck = Arrays.asList(
                new Card(Color.COEUR, CardValue.DIX),
                new Card(Color.PIQUE, CardValue.SEPT),
                new Card(Color.TREFLE, CardValue.CINQ),
                new Card(Color.PIQUE, CardValue.DAME),
                new Card(Color.CARREAUX, CardValue.QUATRE),
                new Card(Color.CARREAUX, CardValue.NEUF),
                new Card(Color.CARREAUX, CardValue.HUIT),
                new Card(Color.TREFLE, CardValue.AS),
                new Card(Color.CARREAUX, CardValue.QUATRE),
                new Card(Color.PIQUE, CardValue.ROI)


        );
        List<Color> colorOrder = Arrays.asList(
                Color.TREFLE, Color.COEUR, Color.PIQUE, Color.CARREAUX
        );
        List<CardValue> cardValuesOrder = Arrays.asList(
                CardValue.DEUX,
                CardValue.QUATRE,
                CardValue.SIX,
                CardValue.DAME,
                CardValue.ROI,
                CardValue.AS,
                CardValue.CINQ,
                CardValue.TROIS,
                CardValue.SEPT,
                CardValue.HUIT,
                CardValue.VALET,
                CardValue.DIX,
                CardValue.NEUF
        );
        CardsOrder cardsOrder = new CardsOrder(colorOrder, cardValuesOrder);
        List<Card> expectedSortedDeck = Arrays.asList(
                new Card(Color.TREFLE, CardValue.AS),
                new Card(Color.TREFLE, CardValue.CINQ),
                new Card(Color.COEUR, CardValue.DIX),
                new Card(Color.PIQUE, CardValue.DAME),
                new Card(Color.PIQUE, CardValue.ROI),
                new Card(Color.PIQUE, CardValue.SEPT),
                new Card(Color.CARREAUX, CardValue.QUATRE),
                new Card(Color.CARREAUX, CardValue.QUATRE),
                new Card(Color.CARREAUX, CardValue.HUIT),
                new Card(Color.CARREAUX, CardValue.NEUF)


        );
        assertEquals(expectedSortedDeck, gameService.sortDeck(deck, cardsOrder));
    }
}