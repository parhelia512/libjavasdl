package org.libsdl.api.platform;

import org.libsdl.jna.NativeLoader;

public final class SdlPlatform {

    static {
        NativeLoader.registerNativeMethods(SdlPlatform.class);
    }

    private SdlPlatform() {
    }

    public static native String SDL_GetPlatform();
}
