package org.libsdl.api.metal;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.SdlNativeLibraryLoader;

// TODO: Test on macOS

/**
 * <p>Adapted from SDL_metal.h</p>
 *
 * <p>Functions for creating Metal layers and views on macOS/iOS on top of an SDL window.</p>
 */
public final class SdlMetal {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMetal.class);
    }

    private SdlMetal() {
    }

    public static native SDL_MetalView SDL_Metal_CreateView(
            SDL_Window window);

    public static native void SDL_Metal_DestroyView(
            SDL_MetalView view);

    public static native Pointer SDL_Metal_GetLayer(
            SDL_MetalView view);

    public static native void SDL_Metal_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);
}
