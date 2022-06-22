package org.libsdl.api.video;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.event.SDL_Event;

import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.event.SDL_EventType.SDL_KEYDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;
import static org.libsdl.api.event.SDL_EventType.SDL_WINDOWEVENT;
import static org.libsdl.api.event.SdlEvents.SDL_PollEvent;
import static org.libsdl.api.keycode.SDL_Keycode.SDLK_SPACE;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;

public final class SdlVideoTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_VIDEO);
    }

    @Test
    public void showWindowEventIds() throws InterruptedException {
        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN | SDL_WindowFlags.SDL_WINDOW_RESIZABLE);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        final AtomicBoolean shouldRun = new AtomicBoolean(true);

        new Thread(() -> {
            try {
                Thread.sleep(10_000L);
                shouldRun.set(false);
            } catch (InterruptedException e) {
                throw new CancellationException();
            }
        }).start();

        SDL_Event evt = new SDL_Event();
        while (shouldRun.get()) {
            while (SDL_PollEvent(evt) != 0) {
                System.out.printf("%1$x (%1$d) %n", evt.type);
                switch (evt.type) {
                    case SDL_QUIT:
                        shouldRun.set(false);
                        break;
                    case SDL_KEYDOWN:
                        if (evt.key.keysym.sym == SDLK_SPACE) {
                            System.out.println("SPACE pressed");
                        }
                        break;
                    case SDL_WINDOWEVENT:
                        System.out.println("Window event " + evt.window.event);
                    default:
                        break;
                }
            }
        }

        SDL_DestroyWindow(window);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_VIDEO);
    }

}
