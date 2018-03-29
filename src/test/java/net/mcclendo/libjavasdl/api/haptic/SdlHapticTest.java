package net.mcclendo.libjavasdl.api.haptic;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public class SdlHapticTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlHaptic.SDL_MouseIsHaptic();
        Sdl.SDL_Quit();
    }
}
