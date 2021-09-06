package org.libsdl.api.stdinc;

import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlStdinc {

    static {
        NativeLoader.registerNativeMethods(SdlStdinc.class);
    }

    private SdlStdinc() {
    }

    public static int SDL_FOURCC(
            int a,
            int b,
            int c,
            int d) {
        return a | (b << 8) | (c << 16) | (d << 24);
    }

    public static native String SDL_getenv(String name);

    public static native int SDL_setenv(String name, String value, int overwrite);

//    // TODO: Test and then possibly enable
//    public static native Pointer SDL_malloc(size_t size);
//
//    public static native Pointer SDL_calloc(int nmemb, size_t size);
//
//    public static native Pointer SDL_realloc(Pointer mem, size_t size);

    public static native void SDL_free(Pointer mem);

//    /**
//     * Get the current set of SDL memory functions
//     */
//    public static native void SDL_GetMemoryFunctions(PointerByReference malloc_func,
//                                                     PointerByReference calloc_func,
//                                                     PointerByReference realloc_func,
//                                                     PointerByReference free_func);
//
//    /**
//     * Replace SDL's memory allocation functions with a custom set
//     */
//    public static native int SDL_SetMemoryFunctions(Pointer malloc_func,
//                                                    Pointer calloc_func,
//                                                    Pointer realloc_func,
//                                                    Pointer free_func);

    /**
     * Get the number of outstanding (unfreed) allocations
     */
    public static native int SDL_GetNumAllocations();
}
