package io.github.libjsdl.api.rwops;

import io.github.libjsdl.loader.NativeLoader;

public final class SdlRWops {

    static {
        NativeLoader.loadLibrary(
                SdlRWops.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlRWops() {
    }

    public static native SDL_RWops SDL_RWFromFile(
            String file,
            String mode);
}
