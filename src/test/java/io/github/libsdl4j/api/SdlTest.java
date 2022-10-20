package io.github.libsdl4j.api;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SdlTest {

    public static void assertNoMemoryLeak(int numOfAllocationsBefore) {
        int numOfAllocationsAfter = SDL_GetNumAllocations();
        assertEquals(numOfAllocationsBefore, numOfAllocationsAfter, "There is a memory leak. Number of allocations before the test was " + numOfAllocationsBefore + ", after the test " + numOfAllocationsAfter);
    }

    @NotNull
    public static Path getSampleFile(Object testClass, String fileName) throws URISyntaxException {
        URL sampleFileUrl = testClass.getClass().getResource(fileName);
        return Paths.get(sampleFileUrl.toURI()).toAbsolutePath();
    }

    @Test
    public void control() {
        Sdl.SDL_Init(0);
        Sdl.SDL_Quit();
    }
}
