package org.libsdl.api.render;

import org.junit.jupiter.api.Test;

import org.libsdl.api.Sdl;

public final class SdlRenderTest {

    @Test
    public void control() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);
        SdlRender.SDL_GetNumRenderDrivers();
        Sdl.SDL_Quit();
    }
}
