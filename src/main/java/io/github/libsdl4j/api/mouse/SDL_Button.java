package io.github.libsdl4j.api.mouse;

import io.github.libsdl4j.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

public final class SDL_Button implements JnaEnum {

    public static final int SDL_BUTTON_LEFT = 1;
    public static final int SDL_BUTTON_MIDDLE = 2;
    public static final int SDL_BUTTON_RIGHT = 3;
    public static final int SDL_BUTTON_X1 = 4;
    public static final int SDL_BUTTON_X2 = 5;

    public static String toString(
            @MagicConstant(valuesFromClass = SDL_Button.class) int value) {
        switch (value) {
            case SDL_BUTTON_LEFT:
                return "SDL_BUTTON_LEFT";
            case SDL_BUTTON_MIDDLE:
                return "SDL_BUTTON_MIDDLE";
            case SDL_BUTTON_RIGHT:
                return "SDL_BUTTON_RIGHT";
            case SDL_BUTTON_X1:
                return "SDL_BUTTON_X1";
            case SDL_BUTTON_X2:
                return "SDL_BUTTON_X2";
            default:
                return "UNKNOWN";
        }
    }

    private SDL_Button() {
    }
}
