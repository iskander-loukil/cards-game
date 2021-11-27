package com.cards.game.services;

import com.cards.game.helpers.CardsOrder;
import com.cards.game.helpers.GameConstants;
import com.cards.game.models.CardValue;
import com.cards.game.models.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderGeneratorTest {

    @Autowired
    OrderGenerator orderGenerator;


    @Test
    void test_valid_color_generation() {
        List<Color>  randomColorOrder = this.orderGenerator.generateRandomColorsOrder();
        assertEquals(randomColorOrder.size(), GameConstants.NUMBER_OF_COLORS);
        assertEquals(new HashSet<Color>(randomColorOrder).size(), GameConstants.NUMBER_OF_COLORS);
    }

    @Test
    void test_valid_card_value_generation() {
        List<CardValue>  randomCardValuesOrder = this.orderGenerator.generateRandomCardValuesOrder();
        assertEquals(randomCardValuesOrder.size(), GameConstants.NUMBER_OF_CARD_VALUES);
        assertEquals(new HashSet<CardValue>(randomCardValuesOrder).size(), GameConstants.NUMBER_OF_CARD_VALUES);
    }

    @Test
    void test_valid_card_order_generation() {
        CardsOrder cardsOrder = this.orderGenerator.generateCardsOrder();
        assertEquals(cardsOrder.getCardValuesOrder().size(), GameConstants.NUMBER_OF_CARD_VALUES);
        assertEquals(cardsOrder.getColorOrder().size(), GameConstants.NUMBER_OF_COLORS);
        assertEquals(new HashSet<CardValue>(cardsOrder.getCardValuesOrder()).size(), GameConstants.NUMBER_OF_CARD_VALUES);
        assertEquals(new HashSet<Color>(cardsOrder.getColorOrder()).size(), GameConstants.NUMBER_OF_COLORS);

    }
}