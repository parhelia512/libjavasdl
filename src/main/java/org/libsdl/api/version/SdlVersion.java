package org.libsdl.api.version;

import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "AbbreviationAsWordInName"})
public final class SdlVersion {

    static {
        NativeLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    public static SDL_version SDL_VERSION() {
        SDL_version v = new SDL_version();
        v.major = SdlVersionConst.SDL_MAJOR_VERSION;
        v.minor = SdlVersionConst.SDL_MINOR_VERSION;
        v.patch = SdlVersionConst.SDL_PATCHLEVEL;
        return v;
    }

    public static int SDL_VERSIONNUM(
            int major,
            int minor,
            int patch) {
        return major * 1000 + minor * 100 + patch;
    }

    public static int SDL_COMPILEDVERSION() {
        return SDL_VERSIONNUM(SdlVersionConst.SDL_MAJOR_VERSION, SdlVersionConst.SDL_MINOR_VERSION, SdlVersionConst.SDL_PATCHLEVEL);
    }

    public static boolean SDL_VERSION_ATLEAST(
            int x,
            int y,
            int z) {
        return SDL_COMPILEDVERSION() >= SDL_VERSIONNUM(x, y, z);
    }

    public static native void SDL_GetVersion(
            SDL_version ver);

    public static native String SDL_GetRevision();
}
