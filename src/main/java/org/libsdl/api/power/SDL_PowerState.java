package org.libsdl.api.power;

import org.libsdl.jna.JnaEnum;

public final class SDL_PowerState implements JnaEnum {

    public static final int SDL_POWERSTATE_UNKNOWN = 0;
    public static final int SDL_POWERSTATE_ON_BATTERY = 1;
    public static final int SDL_POWERSTATE_NO_BATTERY = 2;
    public static final int SDL_POWERSTATE_CHARGING = 3;
    public static final int SDL_POWERSTATE_CHARGE = 4;

    // TODO: Generate public static String toString(int value)

    private SDL_PowerState() {
    }
}
