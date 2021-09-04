package org.libsdl.api.version;

import org.libsdl.api.log.SDL_version;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "AbbreviationAsWordInName"})
public final class SdlVersion {

    public static final int SDL_MAJOR_VERSION = 2;
    public static final int SDL_MINOR_VERSION = 0;
    public static final int SDL_PATCHLEVEL = 8;

    static {
        NativeLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    public static SDL_version SDL_VERSION() {
        final SDL_version v = new SDL_version();
        v.major = SDL_MAJOR_VERSION;
        v.minor = SDL_MINOR_VERSION;
        v.patch = SDL_PATCHLEVEL;

        return v;
    }

    public static int SDL_VERSIONNUM(
            int x,
            int y,
            int z) {
        return ((x) * 1000 + (y) * 100 + (z));
    }

    public static int SDL_COMPILEDVERSION() {
        return SDL_VERSIONNUM(SDL_MAJOR_VERSION, SDL_MINOR_VERSION, SDL_PATCHLEVEL);
    }

    public static boolean SDL_VERSION_ATLEAST(
            int x,
            int y,
            int z) {
        return (SDL_COMPILEDVERSION() >= SDL_VERSIONNUM(x, y, z));
    }

    public static native void SDL_GetVersion(
            SDL_version ver);

    public static native String SDL_GetRevision();

    public static native int SDL_GetRevisionNumber();

}
