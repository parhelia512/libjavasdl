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

    public static void SDL_EnsureLinkedLibraryMatchesAtLeastJavaBindingsVersion() {
        SDL_version linkedLibraryVersion = SDL_GetLinkedLibraryVersion();
        if (!SDL_VERSION_ATLEAST(linkedLibraryVersion.major, linkedLibraryVersion.minor, linkedLibraryVersion.patch)) {
            throw new IllegalStateException("Minimum version of the SDL library found (" + linkedLibraryVersion + ") is older than the application requires (" + SDL_GetJavaBindingsVersion() + ")");
        }
    }

    public static void SDL_VERSION(
            SDL_version ver) {
        ver.major = SdlVersionConst.SDL_MAJOR_VERSION;
        ver.minor = SdlVersionConst.SDL_MINOR_VERSION;
        ver.patch = SdlVersionConst.SDL_PATCHLEVEL;
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
