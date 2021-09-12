package org.libsdl.api.touch;

import org.libsdl.jna.JnaEnum;

public final class SDL_TouchDeviceType implements JnaEnum {

    public static final int SDL_TOUCH_DEVICE_INVALID = -1;
    public static final int SDL_TOUCH_DEVICE_DIRECT = 0;
    public static final int SDL_TOUCH_DEVICE_INDIRECT_ABSOLUTE = 1;
    public static final int SDL_TOUCH_DEVICE_INDIRECT_RELATIVE = 2;

    private SDL_TouchDeviceType() {
    }
}
