package io.github.libsdl4j.api.event;

import org.junit.jupiter.api.Test;

public final class SdlEventsTest {

    @Test
    public void control() {
        SdlEvents.SDL_PumpEvents();
    }
}
