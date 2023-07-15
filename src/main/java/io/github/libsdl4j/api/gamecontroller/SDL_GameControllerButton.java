package io.github.libsdl4j.api.gamecontroller;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The list of buttons available from a controller
 */
public final class SDL_GameControllerButton implements JnaEnum {

    public static final int SDL_CONTROLLER_BUTTON_INVALID = -1;
    public static final int SDL_CONTROLLER_BUTTON_A = 0;
    public static final int SDL_CONTROLLER_BUTTON_B = 1;
    public static final int SDL_CONTROLLER_BUTTON_X = 2;
    public static final int SDL_CONTROLLER_BUTTON_Y = 3;
    public static final int SDL_CONTROLLER_BUTTON_BACK = 4;
    public static final int SDL_CONTROLLER_BUTTON_GUIDE = 5;
    public static final int SDL_CONTROLLER_BUTTON_START = 6;
    public static final int SDL_CONTROLLER_BUTTON_LEFTSTICK = 7;
    public static final int SDL_CONTROLLER_BUTTON_RIGHTSTICK = 8;
    public static final int SDL_CONTROLLER_BUTTON_LEFTSHOULDER = 9;
    public static final int SDL_CONTROLLER_BUTTON_RIGHTSHOULDER = 10;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_UP = 11;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_DOWN = 12;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_LEFT = 13;
    public static final int SDL_CONTROLLER_BUTTON_DPAD_RIGHT = 14;

    /**
     * Xbox Series X share button, PS5 microphone button, Nintendo Switch Pro capture button, Amazon Luna microphone button
     */
    public static final int SDL_CONTROLLER_BUTTON_MISC1 = 15;

    /**
     * Xbox Elite paddle P1 (upper left, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE1 = 16;

    /**
     * Xbox Elite paddle P3 (upper right, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE2 = 17;

    /**
     * Xbox Elite paddle P2 (lower left, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE3 = 18;

    /**
     * Xbox Elite paddle P4 (lower right, facing the back)
     */
    public static final int SDL_CONTROLLER_BUTTON_PADDLE4 = 19;

    /**
     * PS4/PS5 touchpad button
     */
    public static final int SDL_CONTROLLER_BUTTON_TOUCHPAD = 20;
    public static final int SDL_CONTROLLER_BUTTON_MAX = 21;

    // TODO: Generate public static String toString(int value)

    private SDL_GameControllerButton() {
    }
}
