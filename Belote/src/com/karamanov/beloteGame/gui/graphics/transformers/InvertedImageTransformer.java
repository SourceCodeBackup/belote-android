/*
 * Copyright (c) Dimitar Karamanov 2008-2010. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the source code must retain
 * the above copyright notice and the following disclaimer.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 */
package com.karamanov.beloteGame.gui.graphics.transformers;

/**
 * InvertedImageTransformer class.
 * @author Dimitar Karamanov
 */
public final class InvertedImageTransformer extends BasicImageTransformer {

    /**
     * Transform method.
     * @param pixel which be transformed.
     * @return int transformed pixel value.
     */
    protected int transformPixel(final int pixel) {
        return pixel ^ 0x00FFFFFF;
    }
}
