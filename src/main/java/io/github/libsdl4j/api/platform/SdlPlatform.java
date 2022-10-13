package io.github.libsdl4j.api.platform;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_platform.h
 *
 * <p>Try to get a standard set of platform defines.</p>
 */
public final class SdlPlatform {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlPlatform.class);
    }

    private SdlPlatform() {
    }

    /**
     * Get the name of the platform.
     *
     * <p>Here are the names returned for some (but not all) supported platforms:</p>
     * <ul>
     *     <li>"Windows"</li>
     *     <li>"Mac OS X"</li>
     *     <li>"Linux"</li>
     *     <li>"iOS"</li>
     *     <li>"Android"</li>
     * </ul>
     *
     * @return the name of the platform. If the correct platform name is not
     * available, returns a string beginning with the text "Unknown".
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetPlatform();
}
