package net.mcclendo.libjavasdl.api.keyboard;

import org.junit.jupiter.api.Test;

import net.mcclendo.libjavasdl.api.Sdl;
import net.mcclendo.libjavasdl.api.keybaord.SdlKeyboard;

public final class SdlKeyboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlKeyboard.SDL_GetModState();
        Sdl.SDL_Quit();
    }
}
