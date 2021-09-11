package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_DisplayOrientation implements JnaEnum {

    public static final int SDL_ORIENTATION_UNKNOWN = 0;
    public static final int SDL_ORIENTATION_LANDSCAPE = 1;
    public static final int SDL_ORIENTATION_LANDSCAPE_FLIPPED = 2;
    public static final int SDL_ORIENTATION_PORTRAIT = 3;
    public static final int SDL_ORIENTATION_PORTRAIT_FLIPPE = 4;

    private SDL_DisplayOrientation() {
    }
}
