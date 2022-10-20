package io.github.libsdl4j.api.clipboard;

import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_clipboard.h
 *
 * <p>Include file for SDL clipboard handling</p>
 */
public final class SdlClipboard {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlClipboard.class);
    }

    private SdlClipboard() {
    }

    /**
     * Put UTF-8 text into the clipboard.
     *
     * @param text the text to store in the clipboard
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetClipboardText()
     * @see #SDL_HasClipboardText()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetClipboardText(
            String text);

    /**
     * Get UTF-8 text from the clipboard, which must be freed with SDL_free().
     *
     * <p>This functions returns empty string if there was not enough memory left for
     * a copy of the clipboard's content.</p>
     *
     * @return the clipboard text on success or an empty string on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HasClipboardText()
     * @see #SDL_SetClipboardText(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static String SDL_GetClipboardText() {
        Pointer text = InternalNativeFunctions.SDL_GetClipboardText();
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(text);
    }

    /**
     * Query whether the clipboard exists and contains a non-empty text string.
     *
     * @return true if the clipboard has text, or false if it does not.
     * @see #SDL_GetClipboardText()
     * @see #SDL_SetClipboardText(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_HasClipboardText();

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetClipboardText();
    }
}
