package io.github.libsdl4j.api.shape;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * An enum denoting the specific type of contents present in an SDL_WindowShapeParams union.
 */
public final class WindowShapeMode implements JnaEnum {

    /** The default mode, a binarized alpha cutoff of 1. */
    public static final int ShapeModeDefault = 0;

    /** A binarized alpha cutoff with a given integer value. */
    public static final int ShapeModeBinarizeAlpha = 1;

    /** A binarized alpha cutoff with a given integer value, but with the opposite comparison. */
    public static final int ShapeModeReverseBinarizeAlpha = 2;

    /** A color key is applied. */
    public static final int ShapeModeColorKey = 4;

    // TODO: Generate public static String toString(int value)

    private WindowShapeMode() {
    }
}
