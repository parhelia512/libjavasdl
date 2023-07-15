package io.github.libsdl4j.api.mouse;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.surface.SDL_Surface;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_DISABLE;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_ENABLE;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_QUERY;

/**
 * Definitions from file SDL_mouse.h
 *
 * <p>Include file for SDL mouse event handling.</p>
 */
public final class SdlMouse {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMouse.class);
    }

    private SdlMouse() {
    }

    /**
     * Get the window which currently has mouse focus.
     *
     * @return the window with mouse focus.
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_GetMouseFocus();

    /**
     * Retrieve the current state of the mouse.
     *
     * <p>The current button state is returned as a button bitmask, which can be
     * tested using the {@code SDL_BUTTON(X)} macros (where {@code X} is generally 1 for the
     * left, 2 for middle, 3 for the right button), and {@code x} and {@code y} are set to the
     * mouse cursor position relative to the focus window. You can pass null for
     * either {@code x} or {@code y}.</p>
     *
     * @param x the x coordinate of the mouse cursor position relative to the
     *          focus window
     * @param y the y coordinate of the mouse cursor position relative to the
     *          focus window
     * @return a 32-bit button bitmask of the current button state.
     * @see #SDL_GetGlobalMouseState(IntByReference, IntByReference)
     * @see #SDL_GetRelativeMouseState(IntByReference, IntByReference)
     * @see io.github.libsdl4j.api.event.SdlEvents#SDL_PumpEvents()
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
    public static native int SDL_GetMouseState(
            IntByReference x,
            IntByReference y);

    /**
     * Get the current state of the mouse in relation to the desktop.
     *
     * <p>This works similarly to SDL_GetMouseState(), but the coordinates will be
     * reported relative to the top-left of the desktop. This can be useful if you
     * need to track the mouse outside of a specific window and SDL_CaptureMouse()
     * doesn't fit your needs. For example, it could be useful if you need to
     * track the mouse while dragging a window, where coordinates relative to a
     * window might not be in sync at all times.</p>
     *
     * <p>Note: SDL_GetMouseState() returns the mouse position as SDL understands it
     * from the last pump of the event queue. This function, however, queries the
     * OS for the current mouse position, and as such, might be a slightly less
     * efficient function. Unless you know what you're doing and have a good
     * reason to use this function, you probably want SDL_GetMouseState() instead.</p>
     *
     * @param x filled in with the current X coord relative to the desktop; can be
     *          null
     * @param y filled in with the current Y coord relative to the desktop; can be
     *          null
     * @return the current button state as a bitmask which can be tested using
     * the SDL_BUTTON(X) macros.
     * @see #SDL_CaptureMouse(boolean)
     * @since This function is available since SDL 2.0.4.
     */
    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
    public static native int SDL_GetGlobalMouseState(
            IntByReference x,
            IntByReference y);

    /**
     * Retrieve the relative state of the mouse.
     *
     * <p>The current button state is returned as a button bitmask, which can be
     * tested using the {@code SDL_BUTTON(X)} macros (where {@code X} is generally 1 for the
     * left, 2 for middle, 3 for the right button), and {@code x} and {@code y} are set to the
     * mouse deltas since the last call to SDL_GetRelativeMouseState() or since
     * event initialization. You can pass null for either {@code x} or {@code y}.</p>
     *
     * @param x a pointer filled with the last recorded x coordinate of the mouse
     * @param y a pointer filled with the last recorded y coordinate of the mouse
     * @return a 32-bit button bitmask of the relative button state.
     * @see #SDL_GetMouseState(IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
    public static native int SDL_GetRelativeMouseState(
            IntByReference x,
            IntByReference y);

    /**
     * Move the mouse cursor to the given position within the window.
     *
     * <p>This function generates a mouse motion event if relative mode is not
     * enabled. If relative mode is enabled, you can force mouse events for the
     * warp by setting the SDL_HINT_MOUSE_RELATIVE_WARP_MOTION hint.</p>
     *
     * <p>Note that this function will appear to succeed, but not actually move the
     * mouse when used over Microsoft Remote Desktop.</p>
     *
     * @param window the window to move the mouse into, or null for the current
     *               mouse focus
     * @param x      the x coordinate within the window
     * @param y      the y coordinate within the window
     * @see #SDL_WarpMouseGlobal(int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_WarpMouseInWindow(
            SDL_Window window,
            int x,
            int y);

    /**
     * Move the mouse to the given position in global screen space.
     *
     * <p>This function generates a mouse motion event.</p>
     *
     * <p>A failure of this function usually means that it is unsupported by a
     * platform.</p>
     *
     * <p>Note that this function will appear to succeed, but not actually move the
     * mouse when used over Microsoft Remote Desktop.</p>
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_WarpMouseInWindow(SDL_Window, int, int)
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_WarpMouseGlobal(
            int x,
            int y);

    /**
     * Set relative mouse mode.
     *
     * <p>While the mouse is in relative mode, the cursor is hidden, the mouse
     * position is constrained to the window, and SDL will report continuous
     * relative mouse motion even if the mouse is at the edge of the window.</p>
     *
     * <p>This function will flush any pending mouse motion.</p>
     *
     * @param enabled true to enable relative mode, false to disable.
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * If relative mode is not supported, this returns -1.
     * @see #SDL_GetRelativeMouseMode()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetRelativeMouseMode(
            boolean enabled);

    /**
     * Capture the mouse and to track input outside an SDL window.
     *
     * <p>Capturing enables your app to obtain mouse events globally, instead of just
     * within your window. Not all video targets support this function. When
     * capturing is enabled, the current window will get all mouse events, but
     * unlike relative mode, no change is made to the cursor and it is not
     * restrained to your window.</p>
     *
     * <p>This function may also deny mouse input to other windows--both those in
     * your application and others on the system--so you should use this function
     * sparingly, and in small bursts. For example, you might want to track the
     * mouse while the user is dragging something, until the user releases a mouse
     * button. It is not recommended that you capture the mouse for long periods
     * of time, such as the entire time your app is running. For that, you should
     * probably use SDL_SetRelativeMouseMode() or SDL_SetWindowGrab(), depending
     * on your goals.</p>
     *
     * <p>While captured, mouse events still report coordinates relative to the
     * current (foreground) window, but those coordinates may be outside the
     * bounds of the window (including negative values). Capturing is only allowed
     * for the foreground window. If the window loses focus while capturing, the
     * capture will be disabled automatically.</p>
     *
     * <p>While capturing is enabled, the current window will have the
     * {@code SDL_WINDOW_MOUSE_CAPTURE} flag set.</p>
     *
     * <p>Please note that as of SDL 2.0.22, SDL will attempt to "auto capture" the
     * mouse while the user is pressing a button; this is to try and make mouse
     * behavior more consistent between platforms, and deal with the common case
     * of a user dragging the mouse outside of the window. This means that if you
     * are calling SDL_CaptureMouse() only to deal with this situation, you no
     * longer have to (although it is safe to do so). If this causes problems for
     * your app, you can disable auto capture by setting the
     * {@code SDL_HINT_MOUSE_AUTO_CAPTURE} hint to zero.</p>
     *
     * @param enabled true to enable capturing, false to disable.
     * @return 0 on success or -1 if not supported; call SDL_GetError() for more
     * information.
     * @see #SDL_GetGlobalMouseState(IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_CaptureMouse(
            boolean enabled);

    /**
     * Query whether relative mouse mode is enabled.
     *
     * @return true if relative mode is enabled or false otherwise.
     * @see #SDL_SetRelativeMouseMode(boolean)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GetRelativeMouseMode();

    /**
     * Create a cursor using the specified bitmap data and mask (in MSB format).
     *
     * <p>{@code mask} has to be in MSB (Most Significant Bit) format.</p>
     *
     * <p>The cursor width ({@code w}) must be a multiple of 8 bits.</p>
     *
     * <p>The cursor is created in black and white according to the following:</p>
     * <ul>
     *     <li>data=0, mask=1: white</li>
     *     <li>data=1, mask=1: black</li>
     *     <li>data=0, mask=0: transparent</li>
     *     <li>data=1, mask=0: inverted color if possible, black if not.</li>
     * </ul>
     *
     * <p>Cursors created with this function must be freed with SDL_FreeCursor().</p>
     *
     * <p>If you want to have a color cursor, or create your cursor from an
     * SDL_Surface, you should use SDL_CreateColorCursor(). Alternately, you can
     * hide the cursor and draw your own as part of your game's rendering, but it
     * will be bound to the framerate.</p>
     *
     * <p>Also, since SDL 2.0.0, SDL_CreateSystemCursor() is available, which
     * provides twelve readily available system cursors to pick from.</p>
     *
     * @param data the color value for each pixel of the cursor
     * @param mask the mask value for each pixel of the cursor
     * @param w    the width of the cursor
     * @param h    the height of the cursor
     * @param hotX the X-axis location of the upper left corner of the cursor
     *             relative to the actual mouse position
     * @param hotY the Y-axis location of the upper left corner of the cursor
     *             relative to the actual mouse position
     * @return a new cursor with the specified parameters on success or null on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_FreeCursor(SDL_Cursor)
     * @see #SDL_SetCursor(SDL_Cursor)
     * @see #SDL_ShowCursor(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Cursor SDL_CreateCursor(
            Pointer data,
            Pointer mask,
            int w,
            int h,
            int hotX,
            int hotY);

    /**
     * Create a color cursor.
     *
     * @param surface an SDL_Surface structure representing the cursor image
     * @param hotX    the x position of the cursor hot spot
     * @param hotY    the y position of the cursor hot spot
     * @return the new cursor on success or null on failure; call SDL_GetError()
     * for more information.
     * @see #SDL_CreateCursor(Pointer, Pointer, int, int, int, int)
     * @see #SDL_FreeCursor(SDL_Cursor)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Cursor SDL_CreateColorCursor(
            SDL_Surface surface,
            int hotX,
            int hotY);

    /**
     * Create a system cursor.
     *
     * @param id an SDL_SystemCursor enum value
     * @return a cursor on success or null on failure; call SDL_GetError() for
     * more information.
     * @see #SDL_FreeCursor(SDL_Cursor)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Cursor SDL_CreateSystemCursor(
            @MagicConstant(valuesFromClass = SDL_SystemCursor.class) int id);

    /**
     * Set the active cursor.
     *
     * <p>This function sets the currently active cursor to the specified one. If the
     * cursor is currently visible, the change will be immediately represented on
     * the display. SDL_SetCursor(null) can be used to force cursor redraw, if
     * this is desired for any reason.</p>
     *
     * @param cursor a cursor to make active
     * @see #SDL_CreateCursor(Pointer, Pointer, int, int, int, int)
     * @see #SDL_GetCursor()
     * @see #SDL_ShowCursor(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetCursor(
            SDL_Cursor cursor);

    /**
     * Get the active cursor.
     *
     * <p>This function returns a pointer to the current cursor which is owned by the
     * library. It is not necessary to free the cursor with SDL_FreeCursor().</p>
     *
     * @return the active cursor or null if there is no mouse.
     * @see #SDL_SetCursor(SDL_Cursor)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Cursor SDL_GetCursor();

    /**
     * Get the default cursor.
     *
     * <p>You do not have to call SDL_FreeCursor() on the return value, but it is
     * safe to do so.</p>
     *
     * @return the default cursor on success or null on failure.
     * @see #SDL_CreateSystemCursor(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Cursor SDL_GetDefaultCursor();

    /**
     * Free a previously-created cursor.
     *
     * <p>Use this function to free cursor resources created with SDL_CreateCursor(),
     * SDL_CreateColorCursor() or SDL_CreateSystemCursor().</p>
     *
     * @param cursor the cursor to free
     * @see #SDL_CreateColorCursor(SDL_Surface, int, int)
     * @see #SDL_CreateCursor(Pointer, Pointer, int, int, int, int)
     * @see #SDL_CreateSystemCursor(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreeCursor(
            SDL_Cursor cursor);

    /**
     * Toggle whether or not the cursor is shown.
     *
     * <p>The cursor starts off displayed but can be turned off. Passing {@code SDL_ENABLE}
     * displays the cursor and passing {@code SDL_DISABLE} hides it.</p>
     *
     * <p>The current state of the mouse cursor can be queried by passing
     * {@code SDL_QUERY}; either {@code SDL_DISABLE} or {@code SDL_ENABLE} will be returned.</p>
     *
     * @param toggle {@code SDL_ENABLE} to show the cursor, {@code SDL_DISABLE} to hide it,
     *               {@code SDL_QUERY} to query the current state without changing it.
     * @return {@code SDL_ENABLE} if the cursor is shown, or {@code SDL_DISABLE} if the
     * cursor is hidden, or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_CreateCursor(Pointer, Pointer, int, int, int, int)
     * @see #SDL_SetCursor(SDL_Cursor)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(intValues = {SDL_ENABLE, SDL_DISABLE})
    public static native int SDL_ShowCursor(
            @MagicConstant(intValues = {SDL_ENABLE, SDL_DISABLE, SDL_QUERY}) int toggle);
}
