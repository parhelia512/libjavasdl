package org.libsdl.api.pixels;

import org.junit.jupiter.api.Test;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.ContiguousArrayList;

import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static org.libsdl.api.pixels.SdlPixels.SDL_SetPaletteColors;
import static org.libsdl.api.surface.SdlSurface.SDL_BlitSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_CreateRGBSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_FreeSurface;
import static org.libsdl.api.timer.SdlTimer.SDL_Delay;
import static org.libsdl.api.video.SdlVideo.SDL_CreateWindow;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;
import static org.libsdl.api.video.SdlVideo.SDL_GetWindowSurface;
import static org.libsdl.api.video.SdlVideo.SDL_UpdateWindowSurface;
import static org.libsdl.api.video.SdlVideoConst.SDL_WINDOWPOS_CENTERED;

public final class SdlPixelsTest {

    @Test
    public void testPaletteColors() throws InterruptedException {
        int w = 320;
        int h = 200;

        SDL_Init(SDL_INIT_VIDEO);
        SDL_Window window = SDL_CreateWindow("Test Window", SDL_WINDOWPOS_CENTERED(), SDL_WINDOWPOS_CENTERED(), w, h, 0);
        SDL_Surface windowSurface = SDL_GetWindowSurface(window);

        SDL_Surface image = SDL_CreateRGBSurface(0, w, h, 8, 0, 0, 0, 0);
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
        image.pixels.write(0L, offscreen, 0, offscreen.length);

        SDL_Palette originalPalette = image.format.palette;

/*
        SDL_Color[] colors = (SDL_Color[]) new SDL_Color().toArray(3);
        colors[0].r = 0;
        colors[0].g = 0;
        colors[0].b = (byte) 255;
        colors[0].a = 0;
//        colors[1] = new SDL_Color((byte)255, 0, 0, 0);
        colors[1].r = 0;
        colors[1].g = (byte) 255;
        colors[1].b = 0;
        colors[1].a = 0;
        colors[2].r = (byte) 255;
        colors[2].g = (byte) 255;
        colors[2].b = 0;
        colors[2].a = 0;
//        colors[0].write();
*/

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

//        colors[0].autoWrite();
//        SDL_SetPaletteColors(originalPalette, colors[0].getPointer(), 0, 3);
        SDL_SetPaletteColors(originalPalette, colorList, 0, 3);
//        SDL_Color[] colors = {
//                new SDL_Color(255, 0, 0, 0),
//                new SDL_Color(0, 255, 0, 0)
//        };
//        SDL_SetPaletteColors(originalPalette, colors, 0, 2);

        SDL_BlitSurface(image, null, windowSurface, null);
        SDL_UpdateWindowSurface(window);
        SDL_Delay(2000);

//        SDL_FreePalette(originalPalette);

//        SDL_Palette palette = SDL_AllocPalette(256);
//        SDL_Color[] colors2 = new SDL_Color[256];
//        for (int i = 0; i < colors2.length; i++) {
//            colors2[i] = new SDL_Color((byte) i, (byte) i, (byte) i, (byte) 0);
//        }
//        SDL_SetPaletteColors(palette, colors2, 0, 256);
//        image.format.palette = palette;
//
//        SDL_BlitSurface(image, null, windowSurface, null);
//        SDL_UpdateWindowSurface(window);
//        SDL_Delay(2000);

        System.gc();
        SDL_FreeSurface(image);
        SDL_DestroyWindow(window);
        SDL_Quit();
    }

    // TODO: How about new ContiguousArrayList<>(SDL_Color.class, 256, existingPointer);

}
