package io.github.libsdl4j.api.stdinc;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.jna.size_t;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.filesystem.SdlFilesystem.SDL_GetBasePath;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_GetMemoryFunctions;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_GetOriginalMemoryFunctions;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_SetMemoryFunctions;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_free;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_getenv;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_malloc;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_setenv;
import static io.github.libsdl4j.api.stdinc.SdlStdinc.SDL_utf8strlen;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SdlStdincTest {

    @Test
    public void allocationShouldNotCauseMemoryLeak() {
        int allocationCountBefore = SDL_GetNumAllocations();
        for (int i = 0; i < 1_000_000; i++) {
            Pointer memoryBlob = SDL_malloc(new size_t(65536));
            SDL_free(memoryBlob);
        }
        int allocationCountAfter = SDL_GetNumAllocations();
        assertEquals(0, allocationCountAfter - allocationCountBefore);
    }

    @Test
    @Disabled    // The test is disabled because it takes a lot of time. But it was successful.
    public void getenvShouldNotCauseMemoryLeak() {
        System.out.println(System.getenv());
        String value = SDL_getenv("USERNAME");
        System.out.println(value);

        int allocationCountBefore = SDL_GetNumAllocations();
        for (int i = 0; i < 10; i++) {
            System.gc();
            for (int j = 0; j < 10_000_000; j++) {
                value = SDL_getenv("USERNAME");
                SDL_setenv("USERNAME", "TestText" + j, 1);
            }
            System.out.println(value);
        }
        int allocationCountAfter = SDL_GetNumAllocations();

        System.out.println(allocationCountBefore + " == " + allocationCountAfter);
        assertEquals(allocationCountBefore, allocationCountAfter);
    }

    @Test
    @Disabled    // The test is disabled because it takes a lot of time. But it was successful.
    public void replacingMemoryFunctionsAndCallingThemShouldCauseNoMemoryLeaks() {
        for (int i = 0; i < 10_000_000; i++) {
            Pointer mem = SDL_malloc(new size_t(32768L));
            SDL_free(mem);
        }

        AllocationFunctions allocationFunctions = SDL_GetOriginalMemoryFunctions();
        for (int i = 0; i < 10_000_000; i++) {
            Pointer mem = allocationFunctions.getMallocFunction().SDL_malloc(new size_t(32768L));
            mem.setLong(0L, 0x1122334455667788L);
            assertEquals(0x1122334455667788L, mem.getLong(0L));
            mem.setLong(0L, 0x3399339933993399L);
            SDL_free(mem);
        }
        for (int i = 0; i < 10_000_000; i++) {
            Pointer mem = SDL_malloc(new size_t(32768L));
            mem.setLong(0L, 0x1122334455667788L);
            assertEquals(0x1122334455667788L, mem.getLong(0L));
            mem.setLong(0L, 0x3399339933993399L);
            allocationFunctions.getFreeFunction().SDL_free(mem);
        }

        AllocationFunctions allocationFunctions2 = SDL_GetMemoryFunctions();
        for (int i = 0; i < 10_000_000; i++) {
            Pointer mem = allocationFunctions2.getMallocFunction().SDL_malloc(new size_t(32768L));
            mem.setLong(0L, 0x1122334455667788L);
            assertEquals(0x1122334455667788L, mem.getLong(0L));
            mem.setLong(0L, 0x3399339933993399L);
            SDL_free(mem);
        }
        for (int i = 0; i < 10_000_000; i++) {
            Pointer mem = SDL_malloc(new size_t(32768L));
            mem.setLong(0L, 0x1122334455667788L);
            assertEquals(0x1122334455667788L, mem.getLong(0L));
            mem.setLong(0L, 0x3399339933993399L);
            allocationFunctions2.getFreeFunction().SDL_free(mem);
        }

        // There must be no OutOfMemoryError by now

        restoreOriginalMemoryFunctions();
    }

    @Test
    @Disabled    // The test is disabled because it takes a lot of time. But it was successful.
    public void replacingMemoryFunctionsAndCallingSDL_mallocShouldCauseNoMemoryLeak() {
        SDL_malloc_func mallocEmulation = this::mallocEmulation;
        SDL_calloc_func callocEmulation = this::callocEmulation;
        SDL_realloc_func reallocEmulation = this::reallocEmulation;
        SDL_free_func freeEmulation = this::freeEmulation;

        SDL_SetMemoryFunctions(mallocEmulation, callocEmulation, reallocEmulation, freeEmulation);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 1_000_000; i++) {
                Pointer mem = SDL_malloc(new size_t(1024L));
                String testText = "SampleText";
                mem.setString(0L, testText);
                assertEquals(testText.length(), SDL_utf8strlen(mem).intValue());
                SDL_free(mem);
                mem = null;
            }
            System.gc();
        }

        // There must be no OutOfMemoryError by now

        restoreOriginalMemoryFunctions();

        // Prevent Callbacks from GC
        mallocEmulation.toString();
        callocEmulation.toString();
        reallocEmulation.toString();
        freeEmulation.toString();
    }

    private int allocationsCount = 0;

    @Test
    @Disabled("Fails, breaks SDL for remaining tests")
    public void replacingMemoryFunctionsAndCallingNativeFunctionThatAllocatesShouldCauseNoMemoryLeak() {
        SDL_malloc_func mallocEmulation = this::mallocEmulation;
        SDL_calloc_func callocEmulation = this::callocEmulation;
        SDL_realloc_func reallocEmulation = this::reallocEmulation;
        SDL_free_func freeEmulation = this::freeEmulation;

        SDL_SetMemoryFunctions(mallocEmulation, callocEmulation, reallocEmulation, freeEmulation);
        int allocationCountBefore = allocationsCount;
        String basePath = SDL_GetBasePath();
        System.out.println(basePath);
        assertFalse(basePath.isEmpty());
        System.gc();
        int allocationCountAfter = allocationsCount;
        assertEquals(allocationCountBefore, allocationCountAfter);

        restoreOriginalMemoryFunctions();

        // Prevent Callbacks from GC
        mallocEmulation.toString();
        callocEmulation.toString();
        reallocEmulation.toString();
        freeEmulation.toString();
    }

    private void restoreOriginalMemoryFunctions() {
        PointerByReference mallocRef = new PointerByReference();
        PointerByReference callocRef = new PointerByReference();
        PointerByReference reallocRef = new PointerByReference();
        PointerByReference freeRef = new PointerByReference();
        SDL_GetOriginalMemoryFunctions(mallocRef, callocRef, reallocRef, freeRef);
        SDL_SetMemoryFunctions(mallocRef.getValue(), callocRef.getValue(), reallocRef.getValue(), freeRef.getValue());
    }

    private Pointer mallocEmulation(size_t size) {
        allocationsCount++;
        Memory mem = new Memory(size.longValue());
        return mem;
    }

    private Pointer callocEmulation(size_t nItems, size_t itemSize) {
        allocationsCount++;
        Memory mem = new Memory(nItems.longValue() * itemSize.longValue());
        return mem;
    }

    private Pointer reallocEmulation(Pointer originalMemory, size_t newSize) {
        allocationsCount++;
        Memory mem = new Memory(newSize.longValue());
        return mem;
    }

    private void freeEmulation(Pointer memory) {
        allocationsCount--;
    }
}
