package com.cards.game.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *  Model representing a card
 */
public class Card implements Serializable {

    private Color color;
    private CardValue cardValue;

    public Card(Color color, CardValue cardValue){
        this.color = color;
        this.cardValue = cardValue;
    }

    /**
     *
     * @return card color
     */
    public Color getColor() {
        return color;
    }

    /**
     *  Sets the card color
     * @param color color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return card value
     */
    public CardValue getCardValue() {
        return cardValue;
    }

    /**
     *  Sets the card value
     * @param cardValue card value to set
     */
    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color && cardValue == card.cardValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, cardValue);
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", cardValue=" + cardValue +
                '}';
    }
}
