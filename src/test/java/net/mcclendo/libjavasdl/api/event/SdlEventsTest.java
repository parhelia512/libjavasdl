package net.mcclendo.libjavasdl.api.event;

import org.junit.Test;

public final class SdlEventsTest {

    @Test
    public void control() {
        SdlEvents.SDL_PumpEvents();
    }
}
