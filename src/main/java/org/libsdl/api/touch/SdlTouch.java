package org.libsdl.api.touch;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlTouch {

    public static final int SDL_TOUCH_MOUSEID = -1;
    public static final long SDL_MOUSE_TOUCHID = -1;

    public static int SDL_GetNumTouchDevices() {
        return NativeFunctions.SDL_GetNumTouchDevices();
    }

    public static SDL_TouchID SDL_GetTouchDevice(int index) {
        return NativeFunctions.SDL_GetTouchDevice(index);
    }

    @MagicConstant(valuesFromClass = SDL_TouchDeviceType.class)
    public static int SDL_GetTouchDeviceType(SDL_TouchID touchID) {
        return NativeFunctions.SDL_GetTouchDeviceType(touchID);
    }

    public static int SDL_GetNumTouchFingers(SDL_TouchID touchID) {
        return NativeFunctions.SDL_GetNumTouchFingers(touchID);
    }

    public static SDL_Finger SDL_GetTouchFinger(SDL_TouchID touchID, int index) {
        return NativeFunctions.SDL_GetTouchFinger(touchID, index);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
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

}
