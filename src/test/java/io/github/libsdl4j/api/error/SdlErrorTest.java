package io.github.libsdl4j.api.error;

import org.junit.jupiter.api.Test;

public final class SdlErrorTest {

    @Test
    public void control() {
        SdlError.SDL_ClearError();
    }
}
