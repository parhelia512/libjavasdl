package org.libsdl.api.haptic;

import org.libsdl.jna.JnaEnum;

public final class SDL_HapticDirectionEncoding implements JnaEnum {

    public static final byte SDL_HAPTIC_POLAR = 0;
    public static final byte SDL_HAPTIC_CARTESIAN = 1;
    public static final byte SDL_HAPTIC_SPHERICAL = 2;
    public static final byte SDL_HAPTIC_STEERING_AXIS = 3;

    // TODO: Generate public static String toString(int value)

    private SDL_HapticDirectionEncoding() {
    }
}
