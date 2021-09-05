package org.libsdl.api;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

final class SdlInternalInit {

    static {
        NativeLoader.registerNativeMethods(SdlInternalInit.class);
    }

    private SdlInternalInit() {
    }

    static native int SDL_Init(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

    static native int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

    @MagicConstant(flagsFromClass = SDL_SubSystem.class)
    static native int SDL_WasInit(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);

    static native void SDL_Quit();

    static native void SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags);
}
