package io.github.libjsdl.api.mouse;

import org.junit.jupiter.api.Test;

import io.github.libjsdl.api.Sdl;

public final class SdlMouseTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlMouse.SDL_GetCursor();
        Sdl.SDL_Quit();
    }
}
