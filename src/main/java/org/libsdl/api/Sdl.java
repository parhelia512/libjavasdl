package org.libsdl.api;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class Sdl {

    public static int SDL_Init(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_InitSubSystem(flags);
    }

    @MagicConstant(flagsFromClass = SDL_SubSystem.class)
    public static int SDL_WasInit(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeLoader.loadSdl2Library();
        return NativeFunctions.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        NativeFunctions.SDL_Quit();
    }

    public static void SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SDL_SubSystem.class) int flags) {
        NativeFunctions.SDL_QuitSubSystem(flags);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
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
}
