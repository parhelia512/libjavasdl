package org.libsdl.api.mouse;

import org.junit.jupiter.api.Test;

import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.mouse.SdlMouse.SDL_GetCursor;

public final class SdlMouseTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_GetCursor();
        SDL_Quit();
    }
}
