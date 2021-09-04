package org.libsdl.api.joystick;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;

public final class SdlJoystickTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlJoystick.SDL_NumJoysticks();
        Sdl.SDL_Quit();
    }
}
