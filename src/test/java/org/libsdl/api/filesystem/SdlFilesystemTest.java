package org.libsdl.api.filesystem;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.libsdl.api.SDL_SubSystem.SDL_INIT_VIDEO;
import static org.libsdl.api.Sdl.SDL_Init;
import static org.libsdl.api.Sdl.SDL_Quit;
import static org.libsdl.api.filesystem.SdlFilesystem.SDL_GetBasePath;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;

class SdlFilesystemTest {

    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    @Test
    public void basePathShouldBeValid() {
        int allocCountBefore = SDL_GetNumAllocations();

        Path actualBasePath = Paths.get(SDL_GetBasePath());
        Path expectedBasePath = Paths.get(System.getProperty("java.home"), "bin");
        assertEquals(expectedBasePath, actualBasePath);

        int allocCountAfter = SDL_GetNumAllocations();
        System.out.println(allocCountAfter);
        assertEquals(allocCountBefore, allocCountAfter);
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
