package org.libsdl.api;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class Sdl {

    private Sdl() {
    }

    public static int SDL_Init(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_InitSubSystem(flags);
    }

    @MagicConstant(flagsFromClass = SDL_SubSystem.class)
    public static int SDL_WasInit(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        SdlInternalInit.SDL_Quit();
    }

    public static void SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        SdlInternalInit.SDL_QuitSubSystem(flags);
    }
}
