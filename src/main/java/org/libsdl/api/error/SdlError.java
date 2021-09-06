package org.libsdl.api.error;

import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

public final class SdlError {

    static {
        NativeLoader.registerNativeMethods(SdlError.class);
    }

    private SdlError() {
    }

    // TODO: Replace Object[] by Object... in SDL_SetError(..)
    //       Note: Varargs are not supported in direct mapping
    //       Test if it works in Java
//    public static native int SDL_SetError(
//            String fmt,
//            Object[] args);

    // TODO: Test if Java threads work
    public static native String SDL_GetError();

    public static native Pointer SDL_GetErrorMsg(Pointer errstr, int maxlen);

    public static native void SDL_ClearError();
}
