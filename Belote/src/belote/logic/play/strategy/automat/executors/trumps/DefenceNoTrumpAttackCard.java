/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.play.strategy.automat.executors.trumps;

import belote.bean.Game;
import belote.logic.play.strategy.automat.base.executor.PlayCardExecutor;
import belote.logic.play.strategy.automat.methods.MinSuitCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorNoTrumpAttackEnemyTrumpCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorNoTrumpAttackMaxSuitLeftCard;
import belote.logic.play.strategy.automat.methods.trumps.ColorNoTrumpAttackSuitHookCard;

/**
 * ColorDefenceSuitCard executor. Implements the obligatory rules for defence player when the attack card is not from trump suit. Used in ColorDefenceCard
 * executor.
 * @author Dimitar Karamanov
 */
public final class DefenceNoTrumpAttackCard extends PlayCardExecutor {

    /**
     * Constructor.
     * @param game a BelotGame instance.
     */
    public DefenceNoTrumpAttackCard(final Game game) {
        super(game);
        // Register play card methods.
        register(new ColorNoTrumpAttackEnemyTrumpCard(game));
        register(new ColorNoTrumpAttackSuitHookCard(game));
        register(new ColorNoTrumpAttackMaxSuitLeftCard(game));
        register(new MinSuitCard(game));
        register(new NoTrumpAttackTrumpCardExecutor(game));
    }
}