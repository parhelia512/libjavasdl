package net.mcclendo.libjavasdl.api.event;

import org.junit.jupiter.api.Test;

public final class SdlEventsTest {

    @Test
    public void control() {
        SdlEvents.SDL_PumpEvents();
    }
}
