package io.github.libjsdl.api;

import io.github.libjsdl.loader.NativeLoader;

final class SdlInternalInit {

    static {
        NativeLoader.registerNativeMethods(SdlInternalInit.class);
    }

    private SdlInternalInit() {
    }

    static native int SDL_Init(
            int flags);

    static native int SDL_InitSubSystem(
            int flags);

    static native int SDL_WasInit(
            int flags);

    static native void SDL_Quit();

    static native void SDL_QuitSubSystem(
            int flags);
}
