package org.libsdl.api.log;

import com.sun.jna.Pointer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.video.SDL_Window;

import static org.libsdl.api.SDL_SubSystem.SDL_INIT_EVERYTHING;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_ASSERT;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_INFO;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_VERBOSE;
import static org.libsdl.api.log.SdlLog.SDL_LogMessage;
import static org.libsdl.api.log.SdlLog.SDL_LogSetAllPriority;
import static org.libsdl.api.log.SdlLog.SDL_LogSetOutputFunction;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;

public final class SdlLogTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_EVERYTHING);
    }

    @Test
    public void registerLogCallback() {
        SDL_LogSetOutputFunction(SdlLog::routeSdlLoggingToSlf4j, Pointer.NULL);
        SDL_LogSetAllPriority(SDL_LOG_PRIORITY_VERBOSE);

        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        SDL_LogMessage(SDL_LOG_CATEGORY_ASSERT, SDL_LOG_PRIORITY_INFO, "Sample message %d, %d", 10, 20);

        SDL_DestroyWindow(window);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_EVERYTHING);
    }
}
