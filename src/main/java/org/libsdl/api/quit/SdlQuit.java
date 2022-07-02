package org.libsdl.api.quit;

import static org.libsdl.api.event.SDL_eventaction.SDL_PEEKEVENT;
import static org.libsdl.api.event.SdlEvents.SDL_PeepEvents;
import static org.libsdl.api.event.SdlEvents.SDL_PumpEvents;
import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;

public final class SdlQuit {

    private SdlQuit() {
    }

    public static boolean SDL_QuitRequested() {
        SDL_PumpEvents();
        int eventCount = SDL_PeepEvents(null, 0, SDL_PEEKEVENT, SDL_QUIT, SDL_QUIT);
        return eventCount > 0;
    }
}
