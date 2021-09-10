package org.libsdl.api.metal;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

// TODO: Test on macOS

/**
 *  <p>Adapted from SDL_metal.h</p>
 *
 *  <p>Functions for creating Metal layers and views on macOS/iOS on top of an SDL window.</p>
 */
public final class SdlMetal {

    public static SDL_MetalView SDL_Metal_CreateView(SDL_Window window) {
        return NativeFunctions.SDL_Metal_CreateView(window);
    }

    public static void SDL_Metal_DestroyView(SDL_MetalView view) {
        NativeFunctions.SDL_Metal_DestroyView(view);
    }

    public static Pointer SDL_Metal_GetLayer(SDL_MetalView view) {
        return NativeFunctions.SDL_Metal_GetLayer(view);
    }

    public static void SDL_Metal_GetDrawableSize(SDL_Window window, IntByReference w, IntByReference h) {
        NativeFunctions.SDL_Metal_GetDrawableSize(window, w, h);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
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
}
