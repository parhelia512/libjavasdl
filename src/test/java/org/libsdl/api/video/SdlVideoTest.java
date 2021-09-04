package org.libsdl.api.video;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;

public final class SdlVideoTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);

        SdlVideo.SDL_GetNumVideoDrivers();

        Sdl.SDL_Quit();
    }
}
