package org.libsdl.api.surface;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.sun.jna.Memory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.libsdl.api.SdlTest;
import org.libsdl.api.rect.SDL_Rect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_InitSubSystem;
import static org.libsdl.api.Sdl.SDL_QuitSubSystem;
import static org.libsdl.api.SdlTest.assertNoMemoryLeak;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.libsdl.api.surface.SdlSurface.SDL_CreateRGBSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_FillRect;
import static org.libsdl.api.surface.SdlSurface.SDL_FillRects;
import static org.libsdl.api.surface.SdlSurface.SDL_FreeSurface;
import static org.libsdl.api.surface.SdlSurface.SDL_SaveBMP;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SdlSurfaceTest {

    private int numOfAllocationsBefore;

    @BeforeEach
    public void setUp() {
        SDL_InitSubSystem(SDL_INIT_VIDEO);
        numOfAllocationsBefore = SDL_GetNumAllocations();
    }

    @Test
    public void createSurfaceShouldFillSDL_Surface() {
        SDL_Surface s = SDL_CreateRGBSurface(
                0,
                400,
                300,
                32,
                0,
                0,
                0,
                0);
        assertEquals(96, s.size());
        assertEquals(400, s.w);
        assertEquals(300, s.h);
        SDL_FreeSurface(s);

        assertNoMemoryLeak(numOfAllocationsBefore);
    }

    @Test
    public void fillRectsShouldCorrectlyAmendPixels() throws IOException, URISyntaxException {
        Path tempDirectory = Files.createTempDirectory("sdl-surface-test");
        Path test1File = tempDirectory.resolve("test1-actual.bmp");
        Path test2File = tempDirectory.resolve("test2-actual.bmp");

        SDL_Surface surface = SDL_CreateRGBSurface(0, 500, 500, 32, 0, 0, 0, 0);

        SDL_Rect backgroundRect = new SDL_Rect();
        backgroundRect.x = 0;
        backgroundRect.y = 0;
        backgroundRect.w = 500;
        backgroundRect.h = 500;

        SDL_Rect[] rectangles1 = new SDL_Rect[3];
        rectangles1[0] = new SDL_Rect();
        rectangles1[0].x = 10;
        rectangles1[0].y = 20;
        rectangles1[0].w = 50;
        rectangles1[0].h = 60;
        rectangles1[1] = new SDL_Rect();
        rectangles1[1].x = 110;
        rectangles1[1].y = 120;
        rectangles1[1].w = 150;
        rectangles1[1].h = 160;
        rectangles1[2] = new SDL_Rect();
        rectangles1[2].x = 210;
        rectangles1[2].y = 220;
        rectangles1[2].w = 250;
        rectangles1[2].h = 260;

        SDL_FillRect(surface, backgroundRect, 0x00FFFFFF);
        SDL_FillRects(surface, rectangles1, 0x00FFFF00);
        SDL_SaveBMP(surface, test1File.toString());

        int size = backgroundRect.size();
        Memory rectangles2Memory = new Memory(size * 3L);
        SDL_Rect[] rectangles2 = new SDL_Rect[3];
        rectangles2[0] = new SDL_Rect(rectangles2Memory);
        rectangles2[0].x = 10;
        rectangles2[0].y = 20;
        rectangles2[0].w = 50;
        rectangles2[0].h = 60;
        rectangles2[0].write();
        rectangles2[1] = new SDL_Rect(rectangles2Memory.share(size, size));
        rectangles2[1].x = 110;
        rectangles2[1].y = 120;
        rectangles2[1].w = 150;
        rectangles2[1].h = 160;
        rectangles2[1].write();
        rectangles2[2] = new SDL_Rect(rectangles2Memory.share(size * 2L, size));
        rectangles2[2].x = 210;
        rectangles2[2].y = 220;
        rectangles2[2].w = 250;
        rectangles2[2].h = 260;
        rectangles2[2].write();

        SDL_FillRect(surface, backgroundRect, 0x00AFAFAF);
        SDL_FillRects(surface, rectangles2Memory, 3, 0x00AFAF00);
        SDL_SaveBMP(surface, test2File.toString());

        byte[] expectedTest1Bmp = Files.readAllBytes(SdlTest.getSampleFile(this, "test1-expected.bmp"));
        byte[] actualTest1Bmp = Files.readAllBytes(test1File);
        assertArrayEquals(expectedTest1Bmp, actualTest1Bmp);
        Files.deleteIfExists(test1File);
        byte[] expectedTest2Bmp = Files.readAllBytes(SdlTest.getSampleFile(this, "test2-expected.bmp"));
        byte[] actualTest2Bmp = Files.readAllBytes(test2File);
        assertArrayEquals(expectedTest2Bmp, actualTest2Bmp);
        Files.deleteIfExists(test2File);
        Files.deleteIfExists(tempDirectory);

        SDL_FreeSurface(surface);
        assertNoMemoryLeak(numOfAllocationsBefore);
    }

    @AfterEach
    public void tearDown() {
        SDL_QuitSubSystem(SDL_INIT_VIDEO);
    }
}
