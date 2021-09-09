package org.libsdl.api.filesystem;

import com.sun.jna.Pointer;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.NativeLoader;

public final class SdlFilesystem {

    public static String SDL_GetBasePath() {
        Pointer path = NativeFunctions.SDL_GetBasePath();
        return JnaUtils.extractStringAndReleaseNativeMemory(path);
    }

    public static String SDL_GetPrefPath(String org, String app) {
        Pointer path = NativeFunctions.SDL_GetPrefPath(org, app);
        return JnaUtils.extractStringAndReleaseNativeMemory(path);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native Pointer SDL_GetBasePath();

        public static native Pointer SDL_GetPrefPath(
                String org,
                String app);
    }
}
