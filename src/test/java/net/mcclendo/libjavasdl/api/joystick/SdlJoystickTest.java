package net.mcclendo.libjavasdl.api.joystick;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlJoystickTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlJoystick.SDL_NumJoysticks();
        Sdl.SDL_Quit();
    }
}
