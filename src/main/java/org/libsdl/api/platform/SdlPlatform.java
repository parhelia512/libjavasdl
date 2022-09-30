package org.libsdl.api.platform;

import org.libsdl.jna.SdlNativeLibraryLoader;

public final class SdlPlatform {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlPlatform.class);
    }

    private SdlPlatform() {
    }

    public static native String SDL_GetPlatform();
}
