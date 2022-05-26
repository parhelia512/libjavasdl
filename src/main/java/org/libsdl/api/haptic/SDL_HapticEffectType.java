package org.libsdl.api.haptic;

import org.libsdl.jna.JnaEnum;

public final class SDL_HapticEffectType implements JnaEnum {

    @SuppressWarnings("PointlessBitwiseExpression")
    public static final int SDL_HAPTIC_CONSTANT = 1 << 0;
    public static final int SDL_HAPTIC_SINE = 1 << 1;
    public static final int SDL_HAPTIC_LEFTRIGHT = 1 << 2;
    public static final int SDL_HAPTIC_TRIANGLE = 1 << 3;
    public static final int SDL_HAPTIC_SAWTOOTHUP = 1 << 4;
    public static final int SDL_HAPTIC_SAWTOOTHDOWN = 1 << 5;
    public static final int SDL_HAPTIC_RAMP = 1 << 6;
    public static final int SDL_HAPTIC_SPRING = 1 << 7;
    public static final int SDL_HAPTIC_DAMPER = 1 << 8;
    public static final int SDL_HAPTIC_INERTIA = 1 << 9;
    public static final int SDL_HAPTIC_FRICTION = 1 << 10;
    public static final int SDL_HAPTIC_CUSTOM = 1 << 11;
    public static final int SDL_HAPTIC_GAIN = 1 << 12;
    public static final int SDL_HAPTIC_AUTOCENTER = 1 << 13;
    public static final int SDL_HAPTIC_STATUS = 1 << 14;
    public static final int SDL_HAPTIC_PAUSE = 1 << 15;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(23);
        if ((type & SDL_HAPTIC_CONSTANT) > 0) {
            append(result, "SDL_HAPTIC_CONSTANT");
        }
        if ((type & SDL_HAPTIC_SINE) > 0) {
            append(result, "SDL_HAPTIC_SINE");
        }
        if ((type & SDL_HAPTIC_LEFTRIGHT) > 0) {
            append(result, "SDL_HAPTIC_LEFTRIGHT");
        }
        if ((type & SDL_HAPTIC_TRIANGLE) > 0) {
            append(result, "SDL_HAPTIC_TRIANGLE");
        }
        if ((type & SDL_HAPTIC_SAWTOOTHUP) > 0) {
            append(result, "SDL_HAPTIC_SAWTOOTHUP");
        }
        if ((type & SDL_HAPTIC_SAWTOOTHDOWN) > 0) {
            append(result, "SDL_HAPTIC_SAWTOOTHDOWN");
        }
        if ((type & SDL_HAPTIC_RAMP) > 0) {
            append(result, "SDL_HAPTIC_RAMP");
        }
        if ((type & SDL_HAPTIC_SPRING) > 0) {
            append(result, "SDL_HAPTIC_SPRING");
        }
        if ((type & SDL_HAPTIC_DAMPER) > 0) {
            append(result, "SDL_HAPTIC_DAMPER");
        }
        if ((type & SDL_HAPTIC_INERTIA) > 0) {
            append(result, "SDL_HAPTIC_INERTIA");
        }
        if ((type & SDL_HAPTIC_FRICTION) > 0) {
            append(result, "SDL_HAPTIC_FRICTION");
        }
        if ((type & SDL_HAPTIC_CUSTOM) > 0) {
            append(result, "SDL_HAPTIC_CUSTOM");
        }
        if ((type & SDL_HAPTIC_GAIN) > 0) {
            append(result, "SDL_HAPTIC_GAIN");
        }
        if ((type & SDL_HAPTIC_AUTOCENTER) > 0) {
            append(result, "SDL_HAPTIC_AUTOCENTER");
        }
        if ((type & SDL_HAPTIC_STATUS) > 0) {
            append(result, "SDL_HAPTIC_STATUS");
        }
        if ((type & SDL_HAPTIC_PAUSE) > 0) {
            append(result, "SDL_HAPTIC_PAUSE");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private static void append(StringBuilder result, String name) {
        if (result.length() > 0) {
            result.append(" | ");
        }
        result.append(name);
    }

    private SDL_HapticEffectType() {
    }
}
