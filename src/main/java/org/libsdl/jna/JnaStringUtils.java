package org.libsdl.jna;

import com.sun.jna.Pointer;

import static org.libsdl.api.stdinc.SdlStdinc.SDL_free;

public class JnaStringUtils {

    public static String extractStringAndReleaseNativeMemory(Pointer pointer) {
        String result = pointer.getString(0L);
        SDL_free(pointer);
        return result;
    }
}
