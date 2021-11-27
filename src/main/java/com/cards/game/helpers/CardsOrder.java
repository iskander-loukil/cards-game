package com.cards.game.helpers;

import com.cards.game.models.CardValue;
import com.cards.game.models.Color;

import java.util.Arrays;
import java.util.List;

public class CardsOrder {
        private List<Color> colorOrder;
        private List<CardValue> cardValuesOrder;


        public CardsOrder(){
            this.colorOrder = Arrays.asList(GameConstants.DEFAULT_COLOR_ORDER);
            this.cardValuesOrder = Arrays.asList(GameConstants.DEFAULT_CARD_ORDER);
        }

        public CardsOrder(List<Color> colorOrder, List<CardValue> cardValuesOrder) {
            this.colorOrder = colorOrder;
            this.cardValuesOrder = cardValuesOrder;
        }

    /**
     *
     * @return currentColorOrder
     */
    public List<Color> getColorOrder() {
            return colorOrder;
        }

    /**
     *  sets the color order
     * @param colorOrder color order to set
     */
        public void setColorOrder(List<Color> colorOrder) {
            this.colorOrder = colorOrder;
        }

    /**
     *
     * @return currentCardValuesOrder
     */
        public List<CardValue> getCardValuesOrder() {
            return cardValuesOrder;
        }

    /**
     * sets the card values order
     * @param cardValuesOrder the card values order to set
     */
        public void setCardValuesOrder(List<CardValue> cardValuesOrder) {
            this.cardValuesOrder = cardValuesOrder;
        }
}
