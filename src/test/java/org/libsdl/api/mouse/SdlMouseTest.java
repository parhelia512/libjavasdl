package org.libsdl.api.mouse;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;

public final class SdlMouseTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlMouse.SDL_GetCursor();
        Sdl.SDL_Quit();
    }
}
