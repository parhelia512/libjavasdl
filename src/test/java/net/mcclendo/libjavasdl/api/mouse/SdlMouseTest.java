package net.mcclendo.libjavasdl.api.mouse;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlMouseTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlMouse.SDL_GetCursor();
        Sdl.SDL_Quit();
    }
}
