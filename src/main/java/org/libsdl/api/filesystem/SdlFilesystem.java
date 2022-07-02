package org.libsdl.api.filesystem;

import com.sun.jna.Pointer;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.NativeLoader;

public final class SdlFilesystem {

    public static String SDL_GetBasePath() {
        Pointer path = InternalNativeFunctions.SDL_GetBasePath();
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(path);
    }

    public static String SDL_GetPrefPath(String org, String app) {
        Pointer path = InternalNativeFunctions.SDL_GetPrefPath(org, app);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(path);
    }

    private SdlFilesystem() {
    }

    private static final class InternalNativeFunctions {

        static {
            NativeLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetBasePath();

        public static native Pointer SDL_GetPrefPath(
                String org,
                String app);
    }
}
