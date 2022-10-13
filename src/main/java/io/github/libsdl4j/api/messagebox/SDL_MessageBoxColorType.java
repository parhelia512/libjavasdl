package io.github.libsdl4j.api.messagebox;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_MessageBoxColorType implements JnaEnum {

    public static final int SDL_MESSAGEBOX_COLOR_BACKGROUND = 0;
    public static final int SDL_MESSAGEBOX_COLOR_TEXT = 1;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_BORDER = 2;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_BACKGROUND = 3;
    public static final int SDL_MESSAGEBOX_COLOR_BUTTON_SELECTED = 4;

    // TODO: Generate public static String toString(int value)

    private SDL_MessageBoxColorType() {
    }
}
