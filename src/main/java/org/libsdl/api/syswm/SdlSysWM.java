package org.libsdl.api.syswm;

import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

public class SdlSysWM {

    /**
     * Get driver-specific information about a window.
     *
     * You must include SDL_syswm.h for the declaration of SDL_SysWMinfo.
     *
     * The caller must initialize the <code>info</code> structure's version by
     * <code>SDL_version</code> object (preferably from <code>SDL_GetVersion()</code>),
     * and then this function will fill in the rest
     * of the structure with information about the given window.
     *
     * @param window the window about which information is being requested
     * @param info an SDL_SysWMinfo structure filled in with window information
     * @return SDL_TRUE if the function is implemented and the `version` member
     *         of the `info` struct is valid, or SDL_FALSE if the information
     *         could not be retrieved; call SDL_GetError() for more information.
     *
     * @since This function is available since SDL 2.0.0.
     */
    public static boolean SDL_GetWindowWMInfo(
            SDL_Window window,
            SDL_SysWMinfo info) {
        return NativeFunctions.SDL_GetWindowWMInfo(window, info);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native boolean SDL_GetWindowWMInfo(
                SDL_Window window,
                SDL_SysWMinfo info);
    }
}
