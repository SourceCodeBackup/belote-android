/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.play.strategy.automat.methods;

import belote.bean.Game;
import belote.bean.Player;
import belote.bean.pack.card.Card;
import belote.bean.pack.card.suit.Suit;
import belote.logic.play.strategy.automat.methods.base.BaseTrumpMethod;

/**
 * ColorNoTrumpAttackEnemyTrumpCard class. PlayCardMethod which implements the logic of playing a hook card (3th defefence position) in defence of color game.
 * @author Dimitar Karamanov
 */
public final class ColorNoTrumpAttackEnemyTrumpCard extends BaseTrumpMethod {

    /**
     * Constructor.
     * @param game BelotGame instance class.
     */
    public ColorNoTrumpAttackEnemyTrumpCard(final Game game) {
        super(game);
    }

    /**
     * Returns player's card.
     * @param player who is on turn.
     * @param trump suit.
     * @return Card object instance or null.
     */
    public Card getPlayMethodCard(final Player player, final Suit trump) {
        final Card attackCard = game.getTrickCards().getAttackCard();

        if (attackCard != null && !attackCard.getSuit().equals(trump)) {
            final Card maxTrumpCard = game.getTrickCards().findMaxSuitCard(trump);
            if (maxTrumpCard != null) {
                final Player trumpPlayer = game.getPlayerByCard(maxTrumpCard);
                if (trumpPlayer != null && !player.isSameTeam(trumpPlayer)) {
                    return player.getCards().findMinSuitCard(attackCard.getSuit());
                }
            }
        }
        return null;
    }
}