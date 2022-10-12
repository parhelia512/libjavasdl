package org.libsdl.api.pixels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.ContiguousArrayList;

import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static org.libsdl.api.pixels.SdlPixels.SDL_AllocPalette;
import static org.libsdl.api.pixels.SdlPixels.SDL_FreePalette;
import static org.libsdl.api.pixels.SdlPixels.SDL_SetPaletteColors;
import static org.libsdl.api.surface.SdlSurface.SDL_BlitSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_CreateRGBSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_FreeSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_SetSurfacePalette;
import static org.libsdl.api.timer.SdlTimer.SDL_Delay;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;
import static org.libsdl.api.video.SdlVideo.SDL_GetWindowSurface;
import static org.libsdl.api.video.SdlVideo.SDL_UpdateWindowSurface;
import static org.libsdl.api.video.SdlVideoConst.SDL_WINDOWPOS_CENTERED;

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
        ContiguousArrayList<SDL_Color> colorList = new ContiguousArrayList<>(SDL_Color.class, 3);
        colorList.get(0).r = 0;
        colorList.get(0).g = 0;
        colorList.get(0).b = (byte) 255;
        colorList.get(0).a = 0;
        colorList.get(1).r = 0;
        colorList.get(1).g = (byte) 255;
        colorList.get(1).b = 0;
        colorList.get(1).a = 0;
        colorList.get(2).r = (byte) 255;
        colorList.get(2).g = (byte) 255;
        colorList.get(2).b = 0;
        colorList.get(2).a = 0;
        SDL_SetPaletteColors(firstPalette, colorList, 0, 3);

        SDL_Color color0 = firstPalette.getColors(0);
        Assertions.assertEquals(colorList.get(0).r, color0.r);
        Assertions.assertEquals(colorList.get(0).g, color0.g);
        Assertions.assertEquals(colorList.get(0).b, color0.b);
        Assertions.assertEquals(colorList.get(0).a, color0.a);

        SDL_SetSurfacePalette(imageSurface, firstPalette);

        SDL_BlitSurface(imageSurface, null, windowSurface, null);
        SDL_UpdateWindowSurface(window);
        SDL_Delay(2000);

        if (true) {
            SDL_Palette secondPalette = SDL_AllocPalette(256);
            ContiguousArrayList<SDL_Color> colors2 = new ContiguousArrayList<>(SDL_Color.class, 3);
            colors2.get(0).r = (byte) 64;
            colors2.get(0).g = 0;
            colors2.get(0).b = (byte) 64;
            colors2.get(0).a = 0;
            colors2.get(1).r = (byte) 128;
            colors2.get(1).g = 0;
            colors2.get(1).b = (byte) 128;
            colors2.get(1).a = 0;
            colors2.get(2).r = (byte) 192;
            colors2.get(2).g = 0;
            colors2.get(2).b = (byte) 192;
            colors2.get(2).a = 0;
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
