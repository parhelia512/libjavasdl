package org.libsdl.api.gamecontroller;

import org.junit.jupiter.api.Test;

import org.libsdl.api.Sdl;

public final class SdlGamecontrollerTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlGamecontroller.SDL_GameControllerUpdate();
        Sdl.SDL_Quit();
    }
}
