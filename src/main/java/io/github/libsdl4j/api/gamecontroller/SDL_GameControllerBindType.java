package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_GameControllerBindType implements JnaEnum {

    public static final int SDL_CONTROLLER_BINDTYPE_NONE = 0;
    public static final int SDL_CONTROLLER_BINDTYPE_BUTTON = 1;
    public static final int SDL_CONTROLLER_BINDTYPE_AXIS = 2;
    public static final int SDL_CONTROLLER_BINDTYPE_HAT = 3;

    // TODO: Generate public static String toString(int value)

    private SDL_GameControllerBindType() {
    }
}
