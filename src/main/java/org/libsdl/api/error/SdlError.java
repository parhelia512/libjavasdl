package org.libsdl.api.error;

import org.libsdl.jna.NativeLoader;

public final class SdlError {

    // TODO: Replace Object[] by Object... in SDL_SetError(..)
    //       Note: Varargs are not supported in direct mapping

    static {
        NativeLoader.registerNativeMethods(SdlError.class);
    }

    private SdlError() {
    }

    public static native int SDL_SetError(
            String fmt,
            Object[] args);

    public static native String SDL_GetError();

    public static native void SDL_ClearError();
}
