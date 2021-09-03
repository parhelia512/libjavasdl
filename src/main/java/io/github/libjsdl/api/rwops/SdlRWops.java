package io.github.libjsdl.api.rwops;

import io.github.libjsdl.jna.NativeLoader;

public final class SdlRWops {

    static {
        NativeLoader.registerNativeMethods(SdlRWops.class);
    }

    private SdlRWops() {
    }

    public static native SDL_RWops SDL_RWFromFile(
            String file,
            String mode);
}
