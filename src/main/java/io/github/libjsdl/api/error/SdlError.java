package io.github.libjsdl.api.error;

import com.sun.jna.Library;

import io.github.libjsdl.loader.NativeLoader;

public final class SdlError {

    private static final SdlErrorMappings INSTANCE;

    static {
        INSTANCE = NativeLoader.loadLibrary(
                SdlError.class,
                NativeLoader.NativeLibrary.SDL2,
                SdlErrorMappings.class);
    }

    private SdlError() {
    }

    public static int SDL_SetError(
            final String fmt,
            final Object... args) {
        return INSTANCE.SDL_SetError(fmt, args);
    }

    public static native String SDL_GetError();

    public static native void SDL_ClearError();

    public interface SdlErrorMappings extends Library {

        int SDL_SetError(
                String fmt,
                Object... args);
    }
}
