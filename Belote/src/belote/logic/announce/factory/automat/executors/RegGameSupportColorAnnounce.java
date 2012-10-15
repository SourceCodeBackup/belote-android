/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package belote.logic.announce.factory.automat.executors;

import belote.bean.Game;
import belote.bean.Player;
import belote.bean.announce.Announce;
import belote.logic.announce.factory.automat.executors.base.AnnounceExecutor;
import belote.logic.announce.factory.automat.methods.RegGameSupportFiftyOrHundredAnnounce;
import belote.logic.announce.factory.automat.methods.RegGameSupportTerzaAnnounce;
import belote.logic.announce.factory.transformers.AnnounceTransformer;
import belote.logic.announce.factory.transformers.SuitToAllTrumpAnnounce;

/**
 * RegGameSupportColorAnnounce class.
 * @author Dimitar Karamanov
 */
public final class RegGameSupportColorAnnounce extends AnnounceExecutor {

    private final AnnounceTransformer suitToAllTrumpAnnounce;

    /**
     * Constructor.
     * @param game BelotGame instance class.
     */
    public RegGameSupportColorAnnounce(final Game game) {
        super(game);

        suitToAllTrumpAnnounce = new SuitToAllTrumpAnnounce(game);

        register(new RegGameSupportFiftyOrHundredAnnounce(game));
        register(new RegGameSupportTerzaAnnounce(game));
        register(new RegGameSupportSimpleAnnounce(game));
    }

    /**
     * Handler method providing the user to write additional code which is executed after the getPlayerCard(Player).
     * @param player for which is called the executor
     * @param announce the result of the method getAnnounce(Player)
     * @return Announce - the same or transformed one.
     */
    protected Announce afterExecution(final Player player, final Announce announce) {
        return suitToAllTrumpAnnounce.transform(player, announce);
    }
}
