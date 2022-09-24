package org.libsdl.api.version;

import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.version.SdlVersionConst.SDL_MAJOR_VERSION;
import static org.libsdl.api.version.SdlVersionConst.SDL_MINOR_VERSION;
import static org.libsdl.api.version.SdlVersionConst.SDL_PATCHLEVEL;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "AbbreviationAsWordInName"})
public final class SdlVersion {

    static {
        NativeLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    // TODO: Custom documentation

    public static SDL_version SDL_GetLinkedLibraryVersion() {
        SDL_version ver = new SDL_version();
        SDL_GetVersion(ver);
        return ver;
    }

    public static SDL_version SDL_GetJavaBindingsVersion() {
        SDL_version ver = new SDL_version();
        SDL_VERSION(ver);
        return ver;
    }

    public static boolean SDL_CheckLinkedLibraryMatchesAtLeastJavaBindingsVersion() {
        SDL_version linkedLibraryVersion = SDL_GetLinkedLibraryVersion();
        if (!SDL_VERSION_ATLEAST(linkedLibraryVersion.major, linkedLibraryVersion.minor, linkedLibraryVersion.patch)) {
            // "Minimum version of the SDL library found (" + linkedLibraryVersion + ") is older than the application requires (" + SDL_GetJavaBindingsVersion() + ")"
            return false;
        } else {
            return true;
        }
    }

    public static void SDL_VERSION(
            SDL_version ver) {
        ver.major = SDL_MAJOR_VERSION;
        ver.minor = SDL_MINOR_VERSION;
        ver.patch = SDL_PATCHLEVEL;
    }

    public static int SDL_VERSIONNUM(
            int major,
            int minor,
            int patch) {
        return major * 1000 + minor * 100 + patch;
    }

    public static int SDL_COMPILEDVERSION() {
        return SDL_VERSIONNUM(SDL_MAJOR_VERSION, SDL_MINOR_VERSION, SDL_PATCHLEVEL);
    }

    public static boolean SDL_VERSION_ATLEAST(
            int x,
            int y,
            int z) {
        return (SDL_MAJOR_VERSION >= x) &&
                (SDL_MAJOR_VERSION > x || SDL_MINOR_VERSION >= y) &&
                (SDL_MAJOR_VERSION > x || SDL_MINOR_VERSION > y || SDL_PATCHLEVEL >= z);
    }

    public static native void SDL_GetVersion(
            SDL_version ver);

    public static native String SDL_GetRevision();
}
