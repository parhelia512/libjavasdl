package io.github.libjsdl.api;

import io.github.libjsdl.jna.NativeLoader;

public final class Sdl {

    public static final int SDL_INIT_TIMER = 0x00000001;
    public static final int SDL_INIT_AUDIO = 0x00000010;
    public static final int SDL_INIT_VIDEO = 0x00000020;
    public static final int SDL_INIT_JOYSTICK = 0x00000200;
    public static final int SDL_INIT_HAPTIC = 0x00001000;
    public static final int SDL_INIT_GAMECONTROLLER = 0x00002000;
    public static final int SDL_INIT_EVENTS = 0x00004000;
    public static final int SDL_INIT_NOPARACHUTE = 0x00100000;
    public static final int SDL_INIT_EVERYTHING = SDL_INIT_TIMER
                    + SDL_INIT_AUDIO
                    + SDL_INIT_VIDEO
                    + SDL_INIT_EVENTS
                    + SDL_INIT_JOYSTICK
                    + SDL_INIT_HAPTIC
                    + SDL_INIT_GAMECONTROLLER;

    private Sdl() {
    }

    public static int SDL_Init(int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_InitSubSystem(flags);
    }

    public static int SDL_WasInit(int flags) {
        NativeLoader.loadSdl2Library();
        return SdlInternalInit.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        SdlInternalInit.SDL_Quit();
    }

    public static void SDL_QuitSubSystem(int flags) {
        SdlInternalInit.SDL_QuitSubSystem(flags);
    }
}
