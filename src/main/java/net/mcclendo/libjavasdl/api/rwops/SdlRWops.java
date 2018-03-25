package net.mcclendo.libjavasdl.api.rwops;

import net.mcclendo.libjavasdl.loader.NativeLoader;

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
