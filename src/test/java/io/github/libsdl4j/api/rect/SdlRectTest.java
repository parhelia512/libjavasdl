package io.github.libsdl4j.api.rect;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.Sdl.SDL_Quit;
import static io.github.libsdl4j.api.rect.SdlRect.SDL_RectEmpty;

public final class SdlRectTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_RectEmpty(new SDL_Rect());
        SDL_Quit();
    }
}
