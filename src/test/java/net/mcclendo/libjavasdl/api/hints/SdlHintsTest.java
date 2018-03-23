package net.mcclendo.libjavasdl.api.hints;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

import net.mcclendo.libjavasdl.api.Sdl;

import com.sun.jna.Pointer;

@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class SdlHintsTest {

    @Test
    public void getSetHints() {

        Sdl.SDL_Init(0);

        Assert.assertNull(SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));
        Assert.assertTrue(SdlHints.SDL_SetHint(SdlHints.SDL_HINT_RENDER_VSYNC, "1"));
        Assert.assertEquals("1", SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));
        Assert.assertTrue(SdlHints.SDL_SetHintWithPriority(SdlHints.SDL_HINT_RENDER_VSYNC, "0", SdlHints.SDL_HINT_OVERRIDE));
        Assert.assertEquals("0", SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));
        Assert.assertFalse(SdlHints.SDL_SetHintWithPriority(SdlHints.SDL_HINT_RENDER_VSYNC, "1", SdlHints.SDL_HINT_NORMAL));

        Sdl.SDL_Quit();
    }

    @Test
    public void getHintBoolean() {

        Sdl.SDL_Init(0);

        Assert.assertFalse(SdlHints.SDL_GetHintBoolean(SdlHints.SDL_HINT_RENDER_VSYNC, false));
        Assert.assertTrue(SdlHints.SDL_SetHint(SdlHints.SDL_HINT_RENDER_VSYNC, "1"));
        Assert.assertTrue(SdlHints.SDL_GetHintBoolean(SdlHints.SDL_HINT_RENDER_VSYNC, false));

        Sdl.SDL_Quit();
    }

    @Test
    public void hintCallbacks() {

        Sdl.SDL_Init(0);

        final AtomicInteger count = new AtomicInteger();
        final SDL_HintCallback callback = (u, n, ov, nv) -> count.incrementAndGet();

        SdlHints.SDL_AddHintCallback(
                SdlHints.SDL_HINT_RENDER_VSYNC,
                callback,
                Pointer.NULL);
        Assert.assertEquals(1, count.get());
        Assert.assertTrue(SdlHints.SDL_SetHint(SdlHints.SDL_HINT_RENDER_VSYNC, "1"));
        Assert.assertEquals(2, count.get());

        SdlHints.SDL_DelHintCallback(
                SdlHints.SDL_HINT_RENDER_VSYNC,
                callback,
                Pointer.NULL);
        Assert.assertTrue(SdlHints.SDL_SetHint(SdlHints.SDL_HINT_RENDER_VSYNC, "1"));
        Assert.assertEquals(2, count.get());

        Sdl.SDL_Quit();
    }

    @Test
    public void clearHints() {

        Sdl.SDL_Init(0);

        Assert.assertNull(SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));
        Assert.assertTrue(SdlHints.SDL_SetHint(SdlHints.SDL_HINT_RENDER_VSYNC, "1"));
        Assert.assertNotNull(SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));
        SdlHints.SDL_ClearHints();
        Assert.assertNull(SdlHints.SDL_GetHint(SdlHints.SDL_HINT_RENDER_VSYNC));

        Sdl.SDL_Quit();
    }
}
