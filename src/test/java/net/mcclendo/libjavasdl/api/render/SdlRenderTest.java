package net.mcclendo.libjavasdl.api.render;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlRenderTest {

    @Test
    public void control() {
        Sdl.SDL_Init(Sdl.SDL_INIT_VIDEO);
        SdlRender.SDL_GetNumRenderDrivers();
        Sdl.SDL_Quit();
    }
}
