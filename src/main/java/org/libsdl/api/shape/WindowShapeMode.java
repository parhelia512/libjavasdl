package org.libsdl.api.shape;

import org.libsdl.jna.JnaEnum;

public final class WindowShapeMode implements JnaEnum {

    public static final int ShapeModeDefault = 0;
    public static final int ShapeModeBinarizeAlpha = 1;
    public static final int ShapeModeReverseBinarizeAlpha = 2;
    public static final int ShapeModeColorKey = 4;

    private WindowShapeMode() {
    }
}
