package io.github.libsdl4j.api.mouse;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.Sdl.SDL_Quit;
import static io.github.libsdl4j.api.mouse.SdlMouse.SDL_GetCursor;

public final class SdlMouseTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_GetCursor();
        SDL_Quit();
    }
}
