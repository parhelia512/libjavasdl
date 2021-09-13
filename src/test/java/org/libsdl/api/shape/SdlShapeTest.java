package org.libsdl.api.shape;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.SdlTest;
import org.libsdl.api.event.events.SDL_Event;
import org.libsdl.api.pixels.SDL_Color;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;

import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.error.SdlError.SDL_GetError;
import static org.libsdl.api.event.SdlEvents.SDL_KEYDOWN;
import static org.libsdl.api.event.SdlEvents.SDL_PollEvent;
import static org.libsdl.api.event.SdlEvents.SDL_QUIT;
import static org.libsdl.api.keycode.SDL_Keycode.SDLK_SPACE;
import static org.libsdl.api.pixels.SDL_PixelFormatEnum.SDL_ISPIXELFORMAT_ALPHA;
import static org.libsdl.api.shape.SdlShape.SDL_CreateShapedWindow;
import static org.libsdl.api.shape.SdlShape.SDL_GetShapedWindowMode;
import static org.libsdl.api.shape.SdlShape.SDL_INVALID_SHAPE_ARGUMENT;
import static org.libsdl.api.shape.SdlShape.SDL_NONSHAPEABLE_WINDOW;
import static org.libsdl.api.shape.SdlShape.SDL_SetWindowShape;
import static org.libsdl.api.shape.SdlShape.SDL_WINDOW_LACKS_SHAPE;
import static org.libsdl.api.shape.WindowShapeMode.ShapeModeColorKey;
import static org.libsdl.api.surface.SdlSurface.SDL_FreeSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_LoadBMP;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_SHOWN;
import static org.libsdl.api.video.SdlVideo.SDL_DestroyWindow;
import static org.libsdl.api.video.SdlVideo.SDL_WINDOWPOS_CENTERED;

public class SdlShapeTest {

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    // TODO: Does not work
    @Test
    public void windowModeConstant() throws URISyntaxException {
        Path sampleFile = SdlTest.getSampleFile(this, "shape-24bit.bmp");
        SDL_Surface shape = SDL_LoadBMP(sampleFile.toString());
        System.out.println("Shape bitmap resolution: " + shape.w + " x " + shape.h);
        boolean isAlpha = SDL_ISPIXELFORMAT_ALPHA(shape.format.format);
        System.out.println("Has alpha channel: " + isAlpha);

        SDL_Window window = SDL_CreateShapedWindow("Test window", SDL_WINDOWPOS_CENTERED(), SDL_WINDOWPOS_CENTERED(), 400, 300, SDL_WINDOW_SHOWN);
        System.out.println("Press SPACE to set shape");

        final AtomicBoolean shouldRun = new AtomicBoolean(true);

        new Thread(() -> {
            try {
                Thread.sleep(5000L);
                shouldRun.set(false);
            } catch (InterruptedException e) {
                throw new CancellationException();
            }
        }).start();

        SDL_Event evt = new SDL_Event();
        while (shouldRun.get()) {
            while (SDL_PollEvent(evt) != 0) {
                switch (evt.type) {
                    case SDL_QUIT:
                        shouldRun.set(false);
                        break;
                    case SDL_KEYDOWN:
                        if (evt.key.keysym.sym == SDLK_SPACE) {
                            SDL_WindowShapeMode shapeMode1 = new SDL_WindowShapeMode();
                            shapeMode1.mode = ShapeModeColorKey;
                            shapeMode1.parameters.setType("colorKey");
                            shapeMode1.parameters.colorKey = new SDL_Color();
                            shapeMode1.parameters.colorKey.r = 0;
                            shapeMode1.parameters.colorKey.g = 0;
                            shapeMode1.parameters.colorKey.b = 0;
                            shapeMode1.parameters.colorKey.a = (byte) 255;
                            int result = SDL_SetWindowShape(window, shape, shapeMode1);
                            if (result == SDL_INVALID_SHAPE_ARGUMENT) {
                                System.out.println("SDL_INVALID_SHAPE_ARGUMENT");
                                System.out.println(SDL_GetError());
                            } else if (result == SDL_NONSHAPEABLE_WINDOW) {
                                System.out.println("SDL_NONSHAPEABLE_WINDOW");
                                System.out.println(SDL_GetError());
                            } else {
                                System.out.println("UNKNOWN ERROR");
                                System.out.println(SDL_GetError());
                            }

                            SDL_WindowShapeMode shapeMode2 = new SDL_WindowShapeMode();
                            int result2 = SDL_GetShapedWindowMode(window, shapeMode2);
                            if (result2 == 0) {
                                System.out.println("Shape mode: " + shapeMode2.mode);
                                System.out.println("Shape parameters: " + shapeMode2.parameters);
                            } else if (result2 == SDL_NONSHAPEABLE_WINDOW) {
                                System.out.println("SDL_NONSHAPEABLE_WINDOW");
                                System.out.println(SDL_GetError());
                            } else if (result2 == SDL_WINDOW_LACKS_SHAPE) {
                                System.out.println("SDL_WINDOW_LACKS_SHAPE");
                                System.out.println(SDL_GetError());
                            } else {
                                System.out.println("UNKNOWN ERROR");
                                System.out.println(SDL_GetError());
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        SDL_DestroyWindow(window);
        SDL_FreeSurface(shape);
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
