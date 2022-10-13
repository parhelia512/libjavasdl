package io.github.libsdl4j.api.joystick;

import org.intellij.lang.annotations.MagicConstant;

public final class SdlJoystickConst {

    /**
     * Set max recognized G-force from accelerometer.
     *
     * <p>See src/joystick/uikit/SDL_sysjoystick.m for notes on why this is needed</p>
     */
    public static final double SDL_IPHONE_MAX_GFORCE = 5.0;

    /**
     * The current version of the SDL_VirtualJoystickDesc structure
     */
    public static final int SDL_VIRTUAL_JOYSTICK_DESC_VERSION = 1;

    public static final int SDL_JOYSTICK_AXIS_MAX = 32767;
    public static final int SDL_JOYSTICK_AXIS_MIN = -32768;

    public static final int SDL_HAT_CENTERED = 0x00;
    public static final int SDL_HAT_UP = 0x01;
    public static final int SDL_HAT_RIGHT = 0x02;
    public static final int SDL_HAT_RIGHTUP = SDL_HAT_RIGHT | SDL_HAT_UP;
    public static final int SDL_HAT_DOWN = 0x04;
    public static final int SDL_HAT_RIGHTDOWN = SDL_HAT_RIGHT | SDL_HAT_DOWN;
    public static final int SDL_HAT_LEFT = 0x08;
    public static final int SDL_HAT_LEFTDOWN = SDL_HAT_LEFT | SDL_HAT_DOWN;
    public static final int SDL_HAT_LEFTUP = SDL_HAT_LEFT | SDL_HAT_UP;

    public static String toString(
            @MagicConstant(intValues = {
                    SDL_HAT_CENTERED,
                    SDL_HAT_UP,
                    SDL_HAT_RIGHT,
                    SDL_HAT_RIGHTUP,
                    SDL_HAT_DOWN,
                    SDL_HAT_RIGHTDOWN,
                    SDL_HAT_LEFT,
                    SDL_HAT_LEFTDOWN,
                    SDL_HAT_LEFTUP}) int value) {
        switch (value) {
            case SDL_HAT_CENTERED:
                return "SDL_HAT_CENTERED";
            case SDL_HAT_UP:
                return "SDL_HAT_UP";
            case SDL_HAT_RIGHT:
                return "SDL_HAT_RIGHT";
            case SDL_HAT_RIGHTUP:
                return "SDL_HAT_RIGHTUP";
            case SDL_HAT_DOWN:
                return "SDL_HAT_DOWN";
            case SDL_HAT_RIGHTDOWN:
                return "SDL_HAT_RIGHTDOWN";
            case SDL_HAT_LEFT:
                return "SDL_HAT_LEFT";
            case SDL_HAT_LEFTDOWN:
                return "SDL_HAT_LEFTDOWN";
            case SDL_HAT_LEFTUP:
                return "SDL_HAT_LEFTUP";
            default:
                throw new IllegalArgumentException("Unknown constant " + value);
        }
    }

    private SdlJoystickConst() {
    }
}
