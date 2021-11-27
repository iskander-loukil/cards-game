package com.cards.game.helpers;

import com.cards.game.models.CardValue;
import com.cards.game.models.Color;

public class GameConstants {
    public static final int DECK_SIZE = 10;
    public static final int NUMBER_OF_COLORS = 4;
    public static final int NUMBER_OF_CARD_VALUES = 13;
    public static final Color[] DEFAULT_COLOR_ORDER = {
            Color.COEUR,
            Color.CARREAUX,
            Color.PIQUE,
            Color.TREFLE
    };

    public static final CardValue[] DEFAULT_CARD_ORDER = {
            CardValue.AS,
            CardValue.DEUX,
            CardValue.TROIS,
            CardValue.QUATRE,
            CardValue.CINQ,
            CardValue.SIX,
            CardValue.SEPT,
            CardValue.HUIT,
            CardValue.NEUF,
            CardValue.DIX,
            CardValue.VALET,
            CardValue.DAME,
            CardValue.ROI
    };
}
