package io.github.libsdl4j.api.stdinc;

import com.sun.jna.CallbackReference;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;

/**
 * Definitions from file SDL_stdinc.h
 *
 * <p>This is a general header that includes C language support.</p>
 */
public final class SdlStdinc {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlStdinc.class);
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
     * Get the original set of SDL memory functions
     *
     * @since This function is available since SDL 2.24.0.
     */
    public static AllocationFunctions SDL_GetOriginalMemoryFunctions() {
        PointerByReference mallocFunc = new PointerByReference();
        PointerByReference callocFunc = new PointerByReference();
        PointerByReference reallocFunc = new PointerByReference();
        PointerByReference freeFunc = new PointerByReference();

        SDL_GetOriginalMemoryFunctions(mallocFunc, callocFunc, reallocFunc, freeFunc);

        return collectAllocationFunctions(mallocFunc, callocFunc, reallocFunc, freeFunc);
    }

    /**
     * Get the original set of SDL memory functions
     *
     * @since This function is available since SDL 2.24.0.
     */
    public static native void SDL_GetOriginalMemoryFunctions(
            PointerByReference mallocFunc,
            PointerByReference callocFunc,
            PointerByReference reallocFunc,
            PointerByReference freeFunc);

    /**
     * Get the current set of SDL memory functions
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static AllocationFunctions SDL_GetMemoryFunctions() {
        PointerByReference mallocFunc = new PointerByReference();
        PointerByReference callocFunc = new PointerByReference();
        PointerByReference reallocFunc = new PointerByReference();
        PointerByReference freeFunc = new PointerByReference();

        SDL_GetMemoryFunctions(mallocFunc, callocFunc, reallocFunc, freeFunc);

        return collectAllocationFunctions(mallocFunc, callocFunc, reallocFunc, freeFunc);
    }

    /**
     * Get the current set of SDL memory functions
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native void SDL_GetMemoryFunctions(
            PointerByReference mallocFunc,
            PointerByReference callocFunc,
            PointerByReference reallocFunc,
            PointerByReference freeFunc);

    private static AllocationFunctions collectAllocationFunctions(
            PointerByReference mallocFunc,
            PointerByReference callocFunc,
            PointerByReference reallocFunc,
            PointerByReference freeFunc) {
        SDL_malloc_func mallocCallback = (SDL_malloc_func) CallbackReference.getCallback(SDL_malloc_func.class, mallocFunc.getValue());
        SDL_calloc_func callocCallback = (SDL_calloc_func) CallbackReference.getCallback(SDL_calloc_func.class, callocFunc.getValue());
        SDL_realloc_func reallocCallback = (SDL_realloc_func) CallbackReference.getCallback(SDL_realloc_func.class, reallocFunc.getValue());
        SDL_free_func freeCallback = (SDL_free_func) CallbackReference.getCallback(SDL_free_func.class, freeFunc.getValue());
        return new AllocationFunctions(mallocCallback, callocCallback, reallocCallback, freeCallback);
    }

    /**
     * Replace SDL's memory allocation functions with a custom set
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_SetMemoryFunctions(
            SDL_malloc_func mallocFunc,
            SDL_calloc_func callocFunc,
            SDL_realloc_func reallocFunc,
            SDL_free_func freeFunc);

    /**
     * Replace SDL's memory allocation functions with a custom set
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_SetMemoryFunctions(
            Pointer mallocFunc,
            Pointer callocFunc,
            Pointer reallocFunc,
            Pointer freeFunc);

    /**
     * Get the number of outstanding (unfreed) allocations
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_GetNumAllocations();

    public static native String SDL_getenv(
            String name);

    public static native int SDL_setenv(
            String name,
            String value,
            int overwrite);

    public static byte SDL_min(
            byte x,
            byte y) {
        return x < y ? x : y;
    }

    public static short SDL_min(
            short x,
            short y) {
        return x < y ? x : y;
    }

    public static int SDL_min(
            int x,
            int y) {
        return x < y ? x : y;
    }

    public static long SDL_min(
            long x,
            long y) {
        return x < y ? x : y;
    }

    public static float SDL_min(
            float x,
            float y) {
        return x < y ? x : y;
    }

    public static double SDL_min(
            double x,
            double y) {
        return x < y ? x : y;
    }

    public static byte SDL_max(
            byte x,
            byte y) {
        return x > y ? x : y;
    }

    public static short SDL_max(
            short x,
            short y) {
        return x > y ? x : y;
    }

    public static int SDL_max(
            int x,
            int y) {
        return x > y ? x : y;
    }

    public static long SDL_max(
            long x,
            long y) {
        return x > y ? x : y;
    }

    public static float SDL_max(
            float x,
            float y) {
        return x > y ? x : y;
    }

    public static double SDL_max(
            double x,
            double y) {
        return x > y ? x : y;
    }

    public static byte SDL_clamp(
            byte x,
            byte a,
            byte b) {
        return x < a ? a : x > b ? b : x;
    }

    public static short SDL_clamp(
            short x,
            short a,
            short b) {
        return x < a ? a : x > b ? b : x;
    }

    public static int SDL_clamp(
            int x,
            int a,
            int b) {
        return x < a ? a : x > b ? b : x;
    }

    public static long SDL_clamp(
            long x,
            long a,
            long b) {
        return x < a ? a : x > b ? b : x;
    }

    public static float SDL_clamp(
            float x,
            float a,
            float b) {
        return x < a ? a : x > b ? b : x;
    }

    public static native size_t SDL_utf8strlen(
            Pointer stringInMemory);
}
