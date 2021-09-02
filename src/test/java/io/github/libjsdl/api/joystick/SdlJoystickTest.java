package io.github.libjsdl.api.joystick;

import org.junit.jupiter.api.Test;

import io.github.libjsdl.api.Sdl;

public final class SdlJoystickTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlJoystick.SDL_NumJoysticks();
        Sdl.SDL_Quit();
    }
}
