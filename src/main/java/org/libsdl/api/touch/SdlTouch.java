package org.libsdl.api.touch;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlTouch {

    static {
        NativeLoader.registerNativeMethods(SdlTouch.class);
    }

    private SdlTouch() {
    }

    public static native int SDL_GetNumTouchDevices();

    public static native SDL_TouchID SDL_GetTouchDevice(
            int index);

    @MagicConstant(valuesFromClass = SDL_TouchDeviceType.class)
    public static native int SDL_GetTouchDeviceType(
            SDL_TouchID touchID);

    public static native int SDL_GetNumTouchFingers(
            SDL_TouchID touchID);

    public static native SDL_Finger SDL_GetTouchFinger(
            SDL_TouchID touchID,
            int index);
}
