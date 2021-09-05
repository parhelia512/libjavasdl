package org.libsdl.api.render;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;
import org.libsdl.api.SDL_SubSystem;

public final class SdlRenderTest {

    @Test
    public void control() {
        Sdl.SDL_Init(SDL_SubSystem.SDL_INIT_VIDEO);
        SdlRender.SDL_GetNumRenderDrivers();
        Sdl.SDL_Quit();
    }
}
