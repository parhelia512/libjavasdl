package io.github.libsdl4j.api.haptic;

import org.junit.jupiter.api.Test;
import io.github.libsdl4j.api.Sdl;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
