package net.mcclendo.libjavasdl.api;

import org.junit.Test;

public final class SdlTest {

    @Test
    public void control() {
                Sdl.SDL_Init(0);
        Sdl.SDL_Quit();
    }
}
