package io.github.libsdl4j.api.rect;

import org.junit.jupiter.api.Test;
import io.github.libsdl4j.api.Sdl;

public final class SdlRectTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlRect.SDL_RectEmpty(new SDL_Rect());
        Sdl.SDL_Quit();
    }
}
