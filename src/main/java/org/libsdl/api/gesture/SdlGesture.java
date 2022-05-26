package org.libsdl.api.gesture;

import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.api.touch.SDL_TouchID;
import org.libsdl.jna.NativeLoader;

public final class SdlGesture {

    static {
        NativeLoader.registerNativeMethods(SdlGesture.class);
    }

    private SdlGesture() {
    }

    public static native int SDL_RecordGesture(
            SDL_TouchID touchId);

    public static native int SDL_SaveAllDollarTemplates(
            SDL_RWops dst);

    public static native int SDL_SaveDollarTemplate(
            SDL_GestureID gestureId,
            SDL_RWops dst);

    public static native int SDL_LoadDollarTemplates(
            SDL_TouchID touchId,
            SDL_RWops src);
}
