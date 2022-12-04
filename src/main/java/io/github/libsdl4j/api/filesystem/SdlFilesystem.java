package io.github.libsdl4j.api.filesystem;

import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_filesystem.h
 *
 * Include file for filesystem SDL API functions
 */
public final class SdlFilesystem {

    /**
     * Get the directory where the application was run from.
     *
     * <p>This is not necessarily a fast call, so you should call this once near
     * startup and save the string if you need it.</p>
     *
     * <p><b>Mac OS X and iOS Specific Functionality:</b> If the application is in a
     * ".app" bundle, this function returns the Resource directory (e.g.
     * MyApp.app/Contents/Resources/). This behaviour can be overridden by adding
     * a property to the Info.plist file. Adding a string key with the name
     * {@code SDL_FILESYSTEM_BASE_DIR_TYPE} with a supported value will change the
     * behaviour.</p>
     *
     * <p>Supported values for the {@code SDL_FILESYSTEM_BASE_DIR_TYPE} property (Given an
     * application in /Applications/SDLApp/MyApp.app):</p>
     *
     * <ul>
     *     <li><p>{@code resource}: bundle resource directory (the default). For example:</p>
     *         <p>{@code /Applications/SDLApp/MyApp.app/Contents/Resources}</p></li>
     *     <li><p>{@code bundle}: the Bundle directory. For example:</p>
     *         <p>{@code /Applications/SDLApp/MyApp.app/}</p></li>
     *     <li><p>{@code parent}: the containing directory of the bundle. For example:</p>
     *         <p>{@code /Applications/SDLApp/}</p></li>
     * </ul>
     *
     * <p><b>Nintendo 3DS Specific Functionality</b>: This function returns "romfs"
     * directory of the application as it is uncommon to store resources outside
     * the executable. As such it is not a writable directory.</p>
     *
     * <p>The returned path is guaranteed to end with a path separator ('\' on
     * Windows, '/' on most other platforms).</p>
     *
     * @return an absolute path in UTF-8 encoding to the application data
     * directory. {@code null} will be returned on error or when the platform
     * doesn't implement this functionality, call SDL_GetError() for more
     * information.
     * @see #SDL_GetPrefPath(String, String)
     * @since This function is available since SDL 2.0.1.
     */
    public static String SDL_GetBasePath() {
        Pointer path = InternalNativeFunctions.SDL_GetBasePath();
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(path);
    }

    /**
     * Get the user-and-app-specific path where files can be written.
     *
     * <p>Get the "pref dir". This is meant to be where users can write personal
     * files (preferences and save games, etc) that are specific to your
     * application. This directory is unique per user, per application.</p>
     *
     * <p>This function will decide the appropriate location in the native
     * filesystem, create the directory if necessary, and return a string of the
     * absolute path to the directory in UTF-8 encoding.</p>
     *
     * <p>On Windows, the string might look like:</p>
     * <p>{@code C:\\Users\\bob\\AppData\\Roaming\\My Company\\My Program Name\\}</p>
     *
     * <p>On Linux, the string might look like:</p>
     * <p>{@code /home/bob/.local/share/My Program Name/}</p>
     *
     * <p>On Mac OS X, the string might look like:</p>
     * <p>{@code /Users/bob/Library/Application Support/My Program Name/}</p>
     *
     * <p>You should assume the path returned by this function is the only safe place
     * to write files (and that SDL_GetBasePath(), while it might be writable, or
     * even the parent of the returned path, isn't where you should be writing
     * things).</p>
     *
     * <p>Both the org and app strings may become part of a directory name, so please
     * follow these rules:</p>
     *
     * <ul>
     *     <li>Try to use the same org string (_including case-sensitivity_) for all
     *         your applications that use this function.</li>
     *     <li>Always use a unique app string for each one, and make sure it never
     *         changes for an app once you've decided on it.</li>
     *     <li>Unicode characters are legal, as long as it's UTF-8 encoded, but...</li>
     *     <li>...only use letters, numbers, and spaces. Avoid punctuation like "Game
     *         Name 2: Bad Guy's Revenge!" ... "Game Name 2" is sufficient.</li>
     * </ul>
     *
     * <p>The returned path is guaranteed to end with a path separator ('\' on
     * Windows, '/' on most other platforms).</p>
     *
     * @param org the name of your organization
     * @param app the name of your application
     * @return a UTF-8 string of the user directory in platform-dependent
     * notation. {@code null} if there's a problem (creating directory failed,
     * etc.).
     * @see #SDL_GetBasePath()
     * @since This function is available since SDL 2.0.1.
     */
    public static String SDL_GetPrefPath(
            String org,
            String app) {
        Pointer path = InternalNativeFunctions.SDL_GetPrefPath(org, app);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(path);
    }

    private SdlFilesystem() {
    }

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetBasePath();

        public static native Pointer SDL_GetPrefPath(
                String org,
                String app);
    }
}
