package org.libsdl.api.stdinc;

import com.sun.jna.Pointer;
import org.junit.jupiter.api.Test;

import org.libsdl.jna.size_t;

import static org.junit.jupiter.api.Assertions.*;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;
import static org.libsdl.api.stdinc.SdlStdinc.SDL_malloc;

public class SdlStdincTest {

    public static final int MAX = 1_000_000;

    @Test
    public void allocationShouldNotCauseMemoryLeak() {
        int allocationCountBefore = SDL_GetNumAllocations();
        for (int i = 0; i < MAX; i++) {
            Pointer memoryBlob = SDL_malloc(new size_t(65536));
            SDL_free(memoryBlob);
        }
        int allocationCountAfter = SDL_GetNumAllocations();
        assertEquals(0, allocationCountAfter - allocationCountBefore);
    }
}
