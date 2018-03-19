package net.mcclendo.libjavasdl.api.event;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;
import net.mcclendo.libjavasdl.api.event.events.SDL_Event;
import net.mcclendo.libjavasdl.api.event.events.SDL_QuitEvent;

public final class SdlEventsTest {

    @Test
    public void filterEvents() {
        Sdl.SDL_Init(Sdl.SDL_INIT_EVERYTHING);

        final SDL_Event event = new SDL_Event();
        while (true) {
            if (SdlEvents.SDL_PollEvent(event) == 0) {
                break;
            }
        }

        final SDL_Event e = new SDL_Event();
        final SDL_QuitEvent quitEvent = new SDL_QuitEvent();
        quitEvent.type = SDL_EventType.SDL_QUIT;
        quitEvent.timestamp = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        e.writeField("quit", new SDL_QuitEvent());

        SdlEvents.SDL_PushEvent(e);

        SdlEvents.SDL_FilterEvents(
                (userdata, event1) -> 0,
                event.getPointer());

        SdlEvents.SDL_PumpEvents();

        Assert.assertEquals(0, SdlEvents.SDL_PollEvent(event));

        Sdl.SDL_Quit();
    }
}
