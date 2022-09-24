package org.libsdl.api.stdinc;

import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;
import org.libsdl.jna.size_t;

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
        return (a & 0xFF) | ((b & 0xFF) << 8) | ((c & 0xFF) << 16) | ((d & 0xFF) << 24);
    }

    public static native Pointer SDL_malloc(
            size_t size);

    public static native Pointer SDL_calloc(
            int nmemb,
            size_t size);

    public static native Pointer SDL_realloc(
            Pointer mem,
            size_t size);

    public static native void SDL_free(
            Pointer mem);

    /**
     * Get the number of outstanding (unfreed) allocations
     */
    public static native int SDL_GetNumAllocations();
}
