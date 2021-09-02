package io.github.libjsdl.api.pixels;

import org.junit.jupiter.api.Test;

import io.github.libjsdl.api.Sdl;

public final class SdlPixelsTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlPixels.SDL_FreePalette(
                SdlPixels.SDL_AllocPalette(1));
        Sdl.SDL_Quit();
    }
}
