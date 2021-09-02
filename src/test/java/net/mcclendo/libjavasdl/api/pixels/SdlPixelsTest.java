package net.mcclendo.libjavasdl.api.pixels;

import org.junit.jupiter.api.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlPixelsTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlPixels.SDL_FreePalette(
                SdlPixels.SDL_AllocPalette(1));
        Sdl.SDL_Quit();
    }
}
