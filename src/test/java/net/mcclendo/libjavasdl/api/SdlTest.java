package net.mcclendo.libjavasdl.api;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public final class SdlTest {

    private static final Logger LOG = Logger.getLogger(SdlTest.class.getCanonicalName());

    @Test
    public void control() {
        Assert.assertEquals(
                0,
                Sdl.SDL_Init(0));

        Assert.assertEquals(
                0,
                Sdl.SDL_InitSubSystem(Sdl.SDL_INIT_TIMER));

        Assert.assertEquals(
                0,
                Sdl.SDL_InitSubSystem(Sdl.SDL_INIT_AUDIO));

        Sdl.SDL_QuitSubSystem(Sdl.SDL_INIT_AUDIO);

        Assert.assertEquals(
                0,
                Sdl.SDL_WasInit(Sdl.SDL_INIT_AUDIO));

        Assert.assertNotEquals(
                0,
                Sdl.SDL_WasInit(0));

        Sdl.SDL_QuitSubSystem(Sdl.SDL_INIT_TIMER);

        Assert.assertEquals(
                0,
                Sdl.SDL_WasInit(0));

        Sdl.SDL_Quit();
    }

    @Test
    @SuppressWarnings("checkstyle:npathcomplexity")
    public void everything() {
        Assert.assertEquals(
                0,
                Sdl.SDL_Init(Sdl.SDL_INIT_EVERYTHING + Sdl.SDL_INIT_NOPARACHUTE));

        int init = Sdl.SDL_WasInit(0);

        if ((init & Sdl.SDL_INIT_TIMER) != 0) {
            init -= Sdl.SDL_INIT_TIMER;
        }

        if ((init & Sdl.SDL_INIT_AUDIO) != 0) {
            init -= Sdl.SDL_INIT_AUDIO;
        }

        if ((init & Sdl.SDL_INIT_VIDEO) != 0) {
            init -= Sdl.SDL_INIT_VIDEO;
        }

        if ((init & Sdl.SDL_INIT_JOYSTICK) != 0) {
            init -= Sdl.SDL_INIT_JOYSTICK;
        }

        if ((init & Sdl.SDL_INIT_HAPTIC) != 0) {
            init -= Sdl.SDL_INIT_HAPTIC;
        }

        if ((init & Sdl.SDL_INIT_GAMECONTROLLER) != 0) {
            init -= Sdl.SDL_INIT_GAMECONTROLLER;
        }

        if ((init & Sdl.SDL_INIT_EVENTS) != 0) {
            init -= Sdl.SDL_INIT_EVENTS;
        }

        if ((init & Sdl.SDL_INIT_NOPARACHUTE) != 0) {
            init -= Sdl.SDL_INIT_NOPARACHUTE;
        }

        Sdl.SDL_Quit();

        Assert.assertEquals(0, init);
    }
}
