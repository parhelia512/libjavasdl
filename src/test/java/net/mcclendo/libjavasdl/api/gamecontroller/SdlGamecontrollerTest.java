package net.mcclendo.libjavasdl.api.gamecontroller;

import org.junit.jupiter.api.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlGamecontrollerTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlGamecontroller.SDL_GameControllerUpdate();
        Sdl.SDL_Quit();
    }
}
