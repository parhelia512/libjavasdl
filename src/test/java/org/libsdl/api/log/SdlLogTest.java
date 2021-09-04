package org.libsdl.api.log;

import org.junit.jupiter.api.Test;
import org.libsdl.api.Sdl;

public final class SdlLogTest {

    @Test
    public void control() {
        Sdl.SDL_Init(0);

        SdlLog.SDL_LogResetPriorities();

        Sdl.SDL_Quit();
    }
}
