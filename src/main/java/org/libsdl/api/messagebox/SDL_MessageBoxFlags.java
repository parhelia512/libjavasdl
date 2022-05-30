package org.libsdl.api.messagebox;

import org.libsdl.jna.JnaEnum;

public final class SDL_MessageBoxFlags implements JnaEnum {

    public static final int SDL_MESSAGEBOX_ERROR = 0x00000010;
    public static final int SDL_MESSAGEBOX_WARNING = 0x00000020;
    public static final int SDL_MESSAGEBOX_INFORMATION = 0x00000040;
    public static final int SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT = 0x00000080;
    public static final int SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT = 0x00000100;

    // TODO: Generate public static String toString(int value)

    private SDL_MessageBoxFlags() {
    }
}
