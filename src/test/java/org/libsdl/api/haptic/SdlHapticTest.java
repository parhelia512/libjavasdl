package org.libsdl.api.haptic;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
