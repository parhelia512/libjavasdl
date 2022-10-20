package io.github.libsdl4j.api.haptic;

import io.github.libsdl4j.api.Sdl;
import org.junit.jupiter.api.Test;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
