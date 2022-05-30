package org.libsdl.api.mouse;

import org.libsdl.jna.JnaEnum;

public final class SDL_MouseWheelDirection implements JnaEnum {

    public static final int SDL_MOUSEWHEEL_NORMAL = 0;
    public static final int SDL_MOUSEWHEEL_FLIPPED = 1;

    // TODO: Generate public static String toString(int value)

    private SDL_MouseWheelDirection() {
    }
}
