package io.github.libjsdl.api.keyboard;

import org.junit.jupiter.api.Test;

import io.github.libjsdl.api.Sdl;

public final class SdlKeyboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlKeyboard.SDL_GetModState();
        Sdl.SDL_Quit();
    }
}
