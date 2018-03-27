package net.mcclendo.libjavasdl.api.clipboard;

import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

public final class SdlClipboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlClipboard.SDL_HasClipboardText();
        Sdl.SDL_Quit();
    }
}
