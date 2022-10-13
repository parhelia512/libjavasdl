package io.github.libsdl4j.api.syswm;

import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_syswm.h
 *
 * <p>Include file for SDL custom system window manager hooks.</p>
 */
public final class SdlSysWM {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlSysWM.class);
    }

    private SdlSysWM() {
    }

    /**
     * Get driver-specific information about a window.
     *
     * <p>The caller must initialize the {@code info} structure's version by using
     * {@code SDL_GetJavaBindingsVersion()}, and then this function will fill in the rest
     * of the structure with information about the given window.</p>
     *
     * @param window the window about which information is being requested
     * @param info   an SDL_SysWMinfo structure filled in with window information
     * @return true if the function is implemented and the {@code version} member
     * of the {@code info} struct is valid, or
     * false if the information could not be retrieved;
     * call SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GetWindowWMInfo(
            SDL_Window window,
            SDL_SysWMInfo info);
}
