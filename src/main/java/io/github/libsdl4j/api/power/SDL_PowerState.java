package io.github.libsdl4j.api.power;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The basic state for the system's power supply.
 */
public final class SDL_PowerState implements JnaEnum {

    /** cannot determine power status */
    public static final int SDL_POWERSTATE_UNKNOWN = 0;

    /** Not plugged in, running on the battery */
    public static final int SDL_POWERSTATE_ON_BATTERY = 1;

    /** Plugged in, no battery available */
    public static final int SDL_POWERSTATE_NO_BATTERY = 2;

    /** Plugged in, charging battery */
    public static final int SDL_POWERSTATE_CHARGING = 3;

    /** Plugged in, battery charged */
    public static final int SDL_POWERSTATE_CHARGE = 4;

    // TODO: Generate public static String toString(int value)

    private SDL_PowerState() {
    }
}
