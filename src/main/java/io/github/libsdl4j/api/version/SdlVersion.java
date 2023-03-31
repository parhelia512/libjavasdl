package io.github.libsdl4j.api.version;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

import static io.github.libsdl4j.api.version.SdlVersionConst.SDL_MAJOR_VERSION;
import static io.github.libsdl4j.api.version.SdlVersionConst.SDL_MINOR_VERSION;
import static io.github.libsdl4j.api.version.SdlVersionConst.SDL_PATCHLEVEL;

/**
 * Definitions from file SDL_version.h
 *
 * <p>This header defines the current SDL version.</p>
 */
public final class SdlVersion {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    /**
     * Get the version of the native SDL library that is currently loaded in memory.
     *
     * <p>The SDL library is a native library (written in C) and must be loaded and linked dynamically.
     * It is therefore possible that the actually loaded version
     * will be different than what the Java bindings expect.</p>
     *
     * <p>This method returns the actual native SDL library version, while {@link #SDL_GetJavaBindingsVersion()}
     * tells you what version the Java bindings expect.</p>
     *
     * <p>This function may be called safely at any time, even before SDL_Init().</p>
     *
     * <p>This is a Java-style version of a raw C-style function ({@link #SDL_GetVersion(SDL_version)}). Prefer this function over the raw C-style one.</p>
     *
     * @return the SDL_version structure that contains the version information
     * @see #SDL_GetJavaBindingsVersion()
     * @see #SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion()
     */
    public static SDL_version SDL_GetNativeLibraryVersion() {
        SDL_version ver = new SDL_version();
        SDL_GetVersion(ver);
        return ver;
    }

    /**
     * Get the version of native SDL library that the Java bindings expect.
     *
     * <p>The SDL library is a native library (written in C) and must be loaded and linked dynamically.
     * It is therefore possible that the actually loaded version
     * will be different than what the Java bindings expect.</p>
     *
     * <p>This method returns what version the Java bindings expect to work with,
     * while {@link #SDL_GetNativeLibraryVersion()} tells you the version of the actually loaded native SDL library.</p>
     *
     * <p>You should always check that the actually loaded native SDL library version is of
     * the same major number as the Java bindings expect, and that the minor and patch number are same or greater.</p>
     *
     * <p>This function may be called safely at any time, even before SDL_Init().</p>
     *
     * @return the SDL_version structure that contains the version information
     * @see #SDL_GetNativeLibraryVersion()
     * @see #SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion()
     */
    public static SDL_version SDL_GetJavaBindingsVersion() {
        SDL_version ver = new SDL_version();
        ver.major = SDL_MAJOR_VERSION;
        ver.minor = SDL_MINOR_VERSION;
        ver.patch = SDL_PATCHLEVEL;
        return ver;
    }

    /**
     * Check the version of the native SDL library is compatible with the Java bindings.
     *
     * <p>The SDL library is a native library (written in C) and must be loaded and linked dynamically.
     * It is therefore possible that the actually loaded version
     * will be different than what the Java bindings expect.</p>
     *
     * <p>This function checks that the version is compatible.
     * Compatibility means that the major version numbers must match,
     * minor version number of the native library is equal or greater then what the Java bindings require
     * and if it matches, then the patch version number of the native library must be also equal or greater.</p>
     *
     * <p>This function may be called safely at any time, even before SDL_Init().</p>
     *
     * @return true if the actually loaded native SDL library is safe to use, false if not.
     */
    public static boolean SDL_CheckNativeLibraryMatchesAtLeastJavaBindingsVersion() {
        SDL_version nativeLibraryVersion = SDL_GetNativeLibraryVersion();
        SDL_version javaBindingsVersion = SDL_GetJavaBindingsVersion();
        if (nativeLibraryVersion.major != javaBindingsVersion.major) {
            // "SDL library major version number (" + nativeLibraryVersion + ") does not match the version required by application (" + javaBindingsVersion + ")".
            return false;
        } else if (compareVersions(nativeLibraryVersion, javaBindingsVersion) < 0) {
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

    /**
     * Get the version of the native SDL library that is currently loaded in memory.
     *
     * <p>The SDL library is a native library (written in C) and must be loaded and linked dynamically.
     * It is therefore possible that the actually loaded version
     * will be different than what the Java bindings expect.</p>
     *
     * <p>This method returns the actual native SDL library version, while {@link #SDL_GetJavaBindingsVersion()}
     * tells you what version the Java bindings expect.</p>
     *
     * <p>This function may be called safely at any time, even before SDL_Init().</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_GetNativeLibraryVersion()}.</p>
     *
     * @param ver the SDL_version structure that contains the version information
     * @see #SDL_GetNativeLibraryVersion()
     * @see #SDL_GetJavaBindingsVersion()
     * @see #SDL_GetRevision()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetVersion(
            SDL_version ver);

    /**
     * Get the code revision of the native SDL library that is currently loaded in memory.
     *
     * <p>This value is the revision of the code you are linked with and may be
     * different from the code you are compiling with, which is found in the
     * constant SDL_REVISION.</p>
     *
     * <p>The revision is arbitrary string (a hash value) uniquely identifying the
     * exact revision of the SDL library in use, and is only useful in comparing
     * against other revisions. It is NOT an incrementing number.</p>
     *
     * <p>If SDL wasn't built from a git repository with the appropriate tools, this
     * will return an empty string.</p>
     *
     * <p>Prior to SDL 2.0.16, before development moved to GitHub, this returned a
     * hash for a Mercurial repository.</p>
     *
     * <p>You shouldn't use this function for anything but logging it for debugging
     * purposes. The string is not intended to be reliable in any way.</p>
     *
     * @return an arbitrary string, uniquely identifying the exact revision of
     * the SDL library in use.
     * @see #SDL_GetNativeLibraryVersion()
     * @see #SDL_GetJavaBindingsVersion()
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetRevision();
}
