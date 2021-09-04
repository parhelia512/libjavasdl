package org.libsdl.api;

import org.junit.jupiter.api.Test;

public final class SdlTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        Sdl.SDL_Quit();
    }
}
