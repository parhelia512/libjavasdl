package io.github.libsdl4j.api.guid;

import java.nio.charset.StandardCharsets;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_guid.h
 *
 * <p>This class contains functions for handling {@link SDL_GUID} values.</p>
 */
public final class SdlGuid {

    /**
     * Get an ASCII string representation for a given {@link SDL_GUID}.
     *
     * <p>You should supply at least 33 bytes for pszGUID.</p>
     *
     * @param guid the {@link SDL_GUID} you wish to convert to string
     * @see #SDL_GUIDFromString(String)
     * @since This function is available since SDL 2.24.0.
     */
    public static String SDL_GUIDToString(
            SDL_GUID guid) {
        try (Memory textBuffer = new Memory(33L)) {
            InternalNativeFunctions.SDL_GUIDToString(guid, textBuffer, (int) textBuffer.size());
            return textBuffer.getString(0L, StandardCharsets.US_ASCII.toString());
        }
    }

    /**
     * Convert a GUID string into a {@link SDL_GUID} structure.
     *
     * <p>Performs no error checking. If this function is given a string containing
     * an invalid GUID, the function will silently succeed, but the GUID generated
     * will not be useful.</p>
     *
     * @param pchGUID string containing an ASCII representation of a GUID
     * @return a {@link SDL_GUID} structure.
     * @see #SDL_GUIDToString(SDL_GUID)
     * @since This function is available since SDL 2.24.0.
     */
    public static native SDL_GUID SDL_GUIDFromString(
            String pchGUID);

    private final static class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native void SDL_GUIDToString(
                SDL_GUID guid,
                Pointer pszGUID,
                int cbGUID);
    }
}
