package io.github.libsdl4j.api.pixels;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.api.video.SDL_Window;

import static io.github.libsdl4j.api.Sdl.SDL_Init;
import static io.github.libsdl4j.api.Sdl.SDL_Quit;
import static io.github.libsdl4j.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static io.github.libsdl4j.api.pixels.SdlPixels.SDL_AllocPalette;
import static io.github.libsdl4j.api.pixels.SdlPixels.SDL_FreePalette;
import static io.github.libsdl4j.api.pixels.SdlPixels.SDL_SetPaletteColors;
import static io.github.libsdl4j.api.surface.SdlSurface.SDL_BlitSurface;
import static io.github.libsdl4j.api.surface.SdlSurface.SDL_CreateRGBSurface;
import static io.github.libsdl4j.api.surface.SdlSurface.SDL_FreeSurface;
import static io.github.libsdl4j.api.surface.SdlSurface.SDL_SetSurfacePalette;
import static io.github.libsdl4j.api.timer.SdlTimer.SDL_Delay;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_CreateWindow;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_DestroyWindow;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_GetWindowSurface;
import static io.github.libsdl4j.api.video.SdlVideo.SDL_UpdateWindowSurface;
import static io.github.libsdl4j.api.video.SdlVideoConst.SDL_WINDOWPOS_CENTERED;

public final class SdlPixelsTest {

    @Test
    public void testPaletteColors() {
        int w = 320;
        int h = 200;

        SDL_Init(SDL_INIT_VIDEO);
        SDL_Window window = SDL_CreateWindow("Test Window", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, w, h, 0);
        SDL_Surface windowSurface = SDL_GetWindowSurface(window);

        SDL_Surface imageSurface = SDL_CreateRGBSurface(0, w, h, 8, 0, 0, 0, 0);
        byte[] offscreen = new byte[w * h];
        for (int i = 0; i < w * h; i = i + 16) {
            offscreen[i] = 0x00;
            offscreen[i + 1] = 0x00;
            offscreen[i + 2] = 0x00;
            offscreen[i + 3] = 0x00;
            offscreen[i + 4] = 0x01;
            offscreen[i + 5] = 0x01;
            offscreen[i + 6] = 0x01;
            offscreen[i + 7] = 0x01;
            offscreen[i + 8] = 0x02;
            offscreen[i + 9] = 0x02;
            offscreen[i + 10] = 0x02;
            offscreen[i + 11] = 0x02;
            offscreen[i + 12] = -0x01;
            offscreen[i + 13] = -0x01;
            offscreen[i + 14] = -0x01;
            offscreen[i + 15] = -0x01;
        }
        imageSurface.getPixels().write(0L, offscreen, 0, offscreen.length);

        SDL_Palette firstPalette = SDL_AllocPalette(256);
        List<SDL_Color> colorList = Arrays.asList(
                new SDL_Color(0, 0, 255, 0),
                new SDL_Color(0, 255, 0, 0),
                new SDL_Color(255, 255, 0, 0));
        SDL_SetPaletteColors(firstPalette, colorList, 0, 3);

        SDL_Color color0 = firstPalette.getColors(0);
        Assertions.assertEquals(colorList.get(0).r, color0.r);
        Assertions.assertEquals(colorList.get(0).g, color0.g);
        Assertions.assertEquals(colorList.get(0).b, color0.b);
        Assertions.assertEquals(colorList.get(0).a, color0.a);

        SDL_SetSurfacePalette(imageSurface, firstPalette);

        SDL_Color color0b = imageSurface.getFormat().getPalette().getColors(0);
        Assertions.assertEquals(colorList.get(0).r, color0b.r);
        Assertions.assertEquals(colorList.get(0).g, color0b.g);
        Assertions.assertEquals(colorList.get(0).b, color0b.b);
        Assertions.assertEquals(colorList.get(0).a, color0b.a);

        SDL_BlitSurface(imageSurface, null, windowSurface, null);
        SDL_UpdateWindowSurface(window);
        SDL_Delay(2000);

        if (true) {
            SDL_Palette secondPalette = SDL_AllocPalette(256);
            List<SDL_Color> colors2 = Arrays.asList(
                    new SDL_Color(64, 0, 64, 0),
                    new SDL_Color(128, 0, 128, 0),
                    new SDL_Color(192, 0, 192, 0));
            SDL_SetPaletteColors(secondPalette, colors2, 0, 3);
            SDL_SetSurfacePalette(imageSurface, secondPalette);

            SDL_BlitSurface(imageSurface, null, windowSurface, null);
            SDL_UpdateWindowSurface(window);
            SDL_Delay(2000);
            SDL_FreePalette(secondPalette);
        }

        SDL_FreeSurface(imageSurface);
        SDL_DestroyWindow(window);
        SDL_Quit();
    }
}
