package com.cards.game.services;


import com.cards.game.helpers.CardsOrder;
import com.cards.game.helpers.GameConstants;
import com.cards.game.models.Card;
import com.cards.game.models.CardValue;
import com.cards.game.models.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class OrderGenerator {
    private static Logger logger = LoggerFactory.getLogger(OrderGenerator.class);

    /**
     * generate a random order of colors
     *
     * @return List of colors in the resulting order
     */
    public List<Color> generateRandomColorsOrder() {
        List<Color> colorOrder = Arrays.asList(GameConstants.DEFAULT_COLOR_ORDER);
        Collections.shuffle(colorOrder);
        logger.debug("Generated new color order : {}", colorOrder);
        return colorOrder;
    }

    /**
     * generate a random order of card values
     *
     * @return List of card values in the resulting order
     */
    public List<CardValue> generateRandomCardValuesOrder() {
        List<CardValue> cardValuesOrder = Arrays.asList(GameConstants.DEFAULT_CARD_ORDER);
        Collections.shuffle(cardValuesOrder);
        logger.debug("Generated new card values order", cardValuesOrder);
        return cardValuesOrder;
    }

    /**
     * generate random order of colors and card values
     *
     * @return CardOrders
     */
    public CardsOrder generateCardsOrder() {
        return new CardsOrder(generateRandomColorsOrder(), generateRandomCardValuesOrder());
    }

    /**
     * generate the comparator of cards based on given Cards Order
     * @param cardsOrder the given cards order
     * @return
     */
    Comparator<Card> getCardsComparator(CardsOrder cardsOrder) {
        return Comparator.comparingInt((Card card) ->
                        cardsOrder.getColorOrder().indexOf(card.getColor()))
                .thenComparingInt((Card card) ->
                        cardsOrder.getCardValuesOrder().indexOf(card.getCardValue()));

    }


}
