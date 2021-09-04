package org.libsdl.api.rwops;

import org.libsdl.jna.NativeLoader;

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
