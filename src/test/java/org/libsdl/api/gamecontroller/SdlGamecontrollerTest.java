package org.libsdl.api.gamecontroller;

import org.junit.jupiter.api.Test;

import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.gamecontroller.SdlGamecontroller.SDL_GameControllerUpdate;
import static org.libsdl.api.gamecontroller.SdlGamecontroller.SDL_IsGameController;

public final class SdlGamecontrollerTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_GameControllerUpdate();
        boolean isJoystick = SDL_IsGameController(0);
        System.out.println(isJoystick);
        SDL_Quit();
    }
}
