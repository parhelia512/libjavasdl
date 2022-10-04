package org.libsdl.api.version;

import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.version.SdlVersionConst.SDL_MAJOR_VERSION;
import static org.libsdl.api.version.SdlVersionConst.SDL_MINOR_VERSION;
import static org.libsdl.api.version.SdlVersionConst.SDL_PATCHLEVEL;

public final class SdlVersion {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    // TODO: Custom documentation

    public static SDL_version SDL_GetNativeLibraryVersion() {
        SDL_version ver = new SDL_version();
        SDL_GetVersion(ver);
        return ver;
    }

    public static SDL_version SDL_GetJavaBindingsVersion() {
        SDL_version ver = new SDL_version();
        ver.major = SDL_MAJOR_VERSION;
        ver.minor = SDL_MINOR_VERSION;
        ver.patch = SDL_PATCHLEVEL;
        return ver;
    }

    public static boolean SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion() {
        SDL_version nativeLibraryVersion = SDL_GetNativeLibraryVersion();
        SDL_version javaBindingsVersion = SDL_GetJavaBindingsVersion();
        if (compareVersions(nativeLibraryVersion, javaBindingsVersion) < 0) {
            // "Minimum version of the SDL library found (" + nativeLibraryVersion + ") is older than the application requires (" + javaBindingsVersion + ")".
            return false;
        } else {
            // Everything is OK.
            return true;
        }
    }

    public static int compareVersions(
            SDL_version version1,
            SDL_version version2) {
        int result = Integer.compare(version1.major, version2.major);
        if (result == 0) {
            result = Integer.compare(version1.minor, version2.minor);
            if (result == 0) {
                result = Integer.compare(version1.patch, version2.patch);
            }
        }
        return result;
    }

    public static native void SDL_GetVersion(
            SDL_version ver);

    public static native String SDL_GetRevision();
}
