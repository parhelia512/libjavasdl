package io.github.libsdl4j.api.clipboard;

import org.junit.jupiter.api.Test;
import io.github.libsdl4j.api.Sdl;

public final class SdlClipboardTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        SdlClipboard.SDL_HasClipboardText();
        Sdl.SDL_Quit();
    }
}
