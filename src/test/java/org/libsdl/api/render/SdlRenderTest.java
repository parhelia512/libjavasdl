package org.libsdl.api.render;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.video.SDL_Window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.libsdl.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.log.SdlLog.SDL_LogSetOutputFunction;
import static org.libsdl.api.render.SDL_RendererFlags.SDL_RENDERER_ACCELERATED;
import static org.libsdl.api.render.SdlRender.SDL_CreateRenderer;
import static org.libsdl.api.render.SdlRender.SDL_DestroyRenderer;
import static org.libsdl.api.render.SdlRender.SDL_GetNumRenderDrivers;
import static org.libsdl.api.render.SdlRender.SDL_RenderGetViewport;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;

public final class SdlRenderTest {

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_EVERYTHING);
    }

    @Test
    public void control() {
        int renderDriversCount = SDL_GetNumRenderDrivers();
        assertTrue(renderDriversCount > 0);
    }

    @Test
    public void registerLogCallback() {
        SDL_Window window = SDL_CreateWindow("Test window", 200, 250, 400, 300, SDL_WINDOW_SHOWN);
        if (window == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }
        SDL_Renderer renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
        if (renderer == null) {
            throw new AssertionError("SDL Failure: " + SDL_GetError());
        }

        SDL_Rect rect = new SDL_Rect();
        SDL_RenderGetViewport(renderer, rect);
        System.out.println(rect.x + ", " + rect.y + ", " + rect.w + " x " + rect.h);
        assertEquals(400, rect.w);
        assertEquals(300, rect.h);

        SDL_DestroyRenderer(renderer);
        SDL_DestroyWindow(window);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_EVERYTHING);
    }
}
