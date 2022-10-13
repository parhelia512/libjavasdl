package io.github.libsdl4j.api.event;

import org.intellij.lang.annotations.MagicConstant;

public final class SdlEventsConst {

    public static final byte SDL_RELEASED = 0;
    public static final byte SDL_PRESSED = 1;

    public static final int SDL_QUERY = -1;
    public static final int SDL_IGNORE = 0;
    public static final int SDL_DISABLE = 0;
    public static final int SDL_ENABLE = 1;

    public static String toString(
            @MagicConstant(intValues = {SDL_RELEASED, SDL_PRESSED}) byte value) {
        switch (value) {
            case SDL_RELEASED:
                return "SDL_RELEASED";
            case SDL_PRESSED:
                return "SDL_PRESSED";
            default:
                return "UNKNOWN";
        }
    }

    public static String toString(
            @MagicConstant(intValues = {SDL_QUERY, SDL_IGNORE, SDL_DISABLE, SDL_ENABLE}) int value) {
        switch (value) {
            case SDL_QUERY:
                return "SDL_QUERY";
            case SDL_DISABLE:
                return "SDL_DISABLE";
            case SDL_ENABLE:
                return "SDL_ENABLE";
            default:
                return "UNKNOWN";
        }
    }

    private SdlEventsConst() {
    }
}
