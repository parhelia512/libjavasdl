package org.libsdl.api.guid;

import java.nio.charset.StandardCharsets;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import org.libsdl.jna.SdlNativeLibraryLoader;

public final class SdlGuid {

    public static String SDL_GUIDToString(
            SDL_GUID guid) {
        Memory textBuffer = new Memory(33L);
        InternalNativeFunctions.SDL_GUIDToString(guid, textBuffer, (int) textBuffer.size());
        return textBuffer.getString(0L, StandardCharsets.US_ASCII.toString());
    }

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
