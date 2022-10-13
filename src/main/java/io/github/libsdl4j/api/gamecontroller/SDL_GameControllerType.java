package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_GameControllerType implements JnaEnum {

    public static final int SDL_CONTROLLER_TYPE_UNKNOWN = 0;
    public static final int SDL_CONTROLLER_TYPE_XBOX360 = 1;
    public static final int SDL_CONTROLLER_TYPE_XBOXONE = 2;
    public static final int SDL_CONTROLLER_TYPE_PS3 = 3;
    public static final int SDL_CONTROLLER_TYPE_PS4 = 4;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_PRO = 5;
    public static final int SDL_CONTROLLER_TYPE_VIRTUAL = 6;
    public static final int SDL_CONTROLLER_TYPE_PS5 = 7;
    public static final int SDL_CONTROLLER_TYPE_AMAZON_LUNA = 8;
    public static final int SDL_CONTROLLER_TYPE_GOOGLE_STADIA = 9;
    public static final int SDL_CONTROLLER_TYPE_NVIDIA_SHIELD = 10;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_LEFT = 11;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT = 12;
    public static final int SDL_CONTROLLER_TYPE_NINTENDO_SWITCH_JOYCON_PAIR = 13;

    // TODO: Generate public static String toString(int value)

    private SDL_GameControllerType() {
    }
}
