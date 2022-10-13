package io.github.libsdl4j.api.touch;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_TouchDeviceType implements JnaEnum {

    public static final int SDL_TOUCH_DEVICE_INVALID = -1;
    public static final int SDL_TOUCH_DEVICE_DIRECT = 0;
    public static final int SDL_TOUCH_DEVICE_INDIRECT_ABSOLUTE = 1;
    public static final int SDL_TOUCH_DEVICE_INDIRECT_RELATIVE = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_TouchDeviceType() {
    }
}
