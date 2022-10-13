package io.github.libsdl4j.api.quit;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_QUIT;
import static io.github.libsdl4j.api.event.SDL_eventaction.SDL_PEEKEVENT;
import static io.github.libsdl4j.api.event.SdlEvents.SDL_PeepEvents;
import static io.github.libsdl4j.api.event.SdlEvents.SDL_PumpEvents;

/**
 * Definitions from file SDL_quit.h
 *
 * <p>Include file for SDL quit event handling.</p>
 *
 * <p>An {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_QUIT SDL_QUIT}
 * event is generated when the user tries to close the application
 * window.  If it is ignored or filtered out, the window will remain open.
 * If it is not ignored or filtered, it is queued normally and the window
 * is allowed to close.  When the window is closed, screen updates will
 * complete, but have no effect.</p>
 *
 * <p>SDL_Init() installs signal handlers for SIGINT (keyboard interrupt)
 * and SIGTERM (system termination request), if handlers do not already
 * exist, that generate {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_QUIT SDL_QUIT} events as well.
 * There is no way to determine the cause of an {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_QUIT SDL_QUIT}
 * event, but setting a signal
 * handler in your application will override the default generation of
 * quit events for that signal.</p>
 *
 * @see io.github.libsdl4j.api.Sdl#SDL_Quit() SDL_Quit()
 */
public final class SdlQuit {

    private SdlQuit() {
    }

    public static boolean SDL_QuitRequested() {
        SDL_PumpEvents();
        int eventCount = SDL_PeepEvents(null, 0, SDL_PEEKEVENT, SDL_QUIT, SDL_QUIT);
        return eventCount > 0;
    }
}
