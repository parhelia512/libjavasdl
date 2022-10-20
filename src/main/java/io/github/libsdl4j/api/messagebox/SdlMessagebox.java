package io.github.libsdl4j.api.messagebox;

import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_ERROR;
import static io.github.libsdl4j.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_INFORMATION;
import static io.github.libsdl4j.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_WARNING;

public final class SdlMessagebox {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMessagebox.class);
    }

    private SdlMessagebox() {
    }

    /**
     * Create a modal message box.
     *
     * <p>If your needs aren't complex, it might be easier to use
     * SDL_ShowSimpleMessageBox.</p>
     *
     * <p>This function should be called on the thread that created the parent
     * window, or on the main thread if the messagebox has no parent. It will
     * block execution of that thread until the user clicks a button or closes the
     * messagebox.</p>
     *
     * <p>This function may be called at any time, even before SDL_Init(). This makes
     * it useful for reporting errors like a failure to create a renderer or
     * OpenGL context.</p>
     *
     * <p>On X11, SDL rolls its own dialog box with X11 primitives instead of a
     * formal toolkit like GTK+ or Qt.</p>
     *
     * <p>Note that if SDL_Init() would fail because there isn't any available video
     * target, this function is likely to fail for the same reasons. If this is a
     * concern, check the return value from this function and fall back to writing
     * to stderr if you can.</p>
     *
     * @param messageboxdata the SDL_MessageBoxData structure with title, text and
     *                       other options
     * @param buttonid       the pointer to which user id of hit button should be copied
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_ShowSimpleMessageBox(int, String, String, SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ShowMessageBox(
            SDL_MessageBoxData messageboxdata,
            IntByReference buttonid);

    /**
     * Display a simple modal message box.
     *
     * <p>If your needs aren't complex, this function is preferred over
     * SDL_ShowMessageBox.</p>
     *
     * <p>{@code flags} may be any of the following:</p>
     * <ul>
     *     <li>{@code SDL_MESSAGEBOX_ERROR}: error dialog</li>
     *     <li>{@code SDL_MESSAGEBOX_WARNING}: warning dialog</li>
     *     <li>{@code SDL_MESSAGEBOX_INFORMATION}: informational dialog</li>
     * </ul>
     *
     * <p>This function should be called on the thread that created the parent
     * window, or on the main thread if the messagebox has no parent. It will
     * block execution of that thread until the user clicks a button or closes the
     * messagebox.</p>
     *
     * <p>This function may be called at any time, even before SDL_Init(). This makes
     * it useful for reporting errors like a failure to create a renderer or
     * OpenGL context.</p>
     *
     * <p>On X11, SDL rolls its own dialog box with X11 primitives instead of a
     * formal toolkit like GTK+ or Qt.</p>
     *
     * <p>Note that if SDL_Init() would fail because there isn't any available video
     * target, this function is likely to fail for the same reasons. If this is a
     * concern, check the return value from this function and fall back to writing
     * to stderr if you can.</p>
     *
     * @param flags   an SDL_MessageBoxFlags value
     * @param title   UTF-8 title text
     * @param message UTF-8 message text
     * @param window  the parent window, or null for no parent
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_ShowMessageBox(SDL_MessageBoxData, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ShowSimpleMessageBox(
            @MagicConstant(flags = {SDL_MESSAGEBOX_INFORMATION, SDL_MESSAGEBOX_WARNING, SDL_MESSAGEBOX_ERROR}) int flags,
            String title,
            String message,
            SDL_Window window);
}
