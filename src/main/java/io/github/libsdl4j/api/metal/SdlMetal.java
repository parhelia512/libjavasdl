package io.github.libsdl4j.api.metal;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_metal.h
 *
 * <p>Functions for creating Metal layers and views on macOS/iOS on top of an SDL window.</p>
 */
public final class SdlMetal {

    // TODO: Test on macOS

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMetal.class);
    }

    private SdlMetal() {
    }

    /**
     * Create a CAMetalLayer-backed NSView/UIView and attach it to the specified
     * window.
     *
     * <p>On macOS, this does <i>not</i> associate a MTLDevice with the CAMetalLayer on
     * its own. It is up to user code to do that.</p>
     *
     * <p>The returned handle can be casted directly to a NSView or UIView. To access
     * the backing CAMetalLayer, call SDL_Metal_GetLayer().</p>
     *
     * @see #SDL_Metal_DestroyView(SDL_MetalView)
     * @see #SDL_Metal_GetLayer(SDL_MetalView)
     * @since This function is available since SDL 2.0.12.
     */
    public static native SDL_MetalView SDL_Metal_CreateView(
            SDL_Window window);

    /**
     * Destroy an existing SDL_MetalView object.
     *
     * <p>This should be called before SDL_DestroyWindow, if SDL_Metal_CreateView was
     * called after SDL_CreateWindow.</p>
     *
     * @see #SDL_Metal_CreateView(SDL_Window)
     * @since This function is available since SDL 2.0.12.
     */
    public static native void SDL_Metal_DestroyView(
            SDL_MetalView view);

    /**
     * Get a pointer to the backing CAMetalLayer for the given view.
     *
     * @see #SDL_Metal_CreateView(SDL_Window)
     * @since This function is available since SDL 2.0.14.
     */
    public static native Pointer SDL_Metal_GetLayer(
            SDL_MetalView view);

    /**
     * Get the size of a window's underlying drawable in pixels (for use with
     * setting viewport, scissor etc).
     *
     * @param window SDL_Window from which the drawable size should be queried
     * @param w      Pointer to variable for storing the width in pixels, may be null
     * @param h      Pointer to variable for storing the height in pixels, may be null
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_CreateWindow(String, int, int, int, int, int)
     * @since This function is available since SDL 2.0.14.
     */
    public static native void SDL_Metal_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);
}
