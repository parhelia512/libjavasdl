package io.github.libsdl4j.api.keyboard;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.keycode.SDL_Keycode;
import io.github.libsdl4j.api.keycode.SDL_Keymod;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.scancode.SDL_Scancode;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_keyboard.h
 *
 * <p>Include file for SDL keyboard event handling</p>
 */
public final class SdlKeyboard {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    /**
     * Query the window which currently has keyboard focus.
     *
     * @return the window with keyboard focus.
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Window SDL_GetKeyboardFocus();

    /**
     * Get a snapshot of the current state of the keyboard.
     *
     * <p>The pointer returned is a pointer to an internal SDL array. It will be
     * valid for the whole lifetime of the application and should not be freed by
     * the caller.</p>
     *
     * <p>A array element with a value of 1 means that the key is pressed and a value
     * of 0 means that it is not. Indexes into this array are obtained by using
     * SDL_Scancode values.</p>
     *
     * <p>Use SDL_PumpEvents() to update the state array.</p>
     *
     * <p>This function gives you the current state after all events have been
     * processed, so if a key or button has been pressed and released before you
     * process events, then the pressed state will never show up in the
     * SDL_GetKeyboardState() calls.</p>
     *
     * <p>Note: This function doesn't take into account whether shift has been
     * pressed or not.</p>
     *
     * @param numkeys if non-null, receives the length of the returned array
     * @return a pointer to an array of key states.
     * @see io.github.libsdl4j.api.event.SdlEvents#SDL_PumpEvents() SDL_PumpEvents()
     * @see #SDL_ResetKeyboard()
     * @since This function is available since SDL 2.0.0.
     */
    // TODO: Test and make more Java friendly. i.e. introduce a new Java class encapsulating the returned byte array
    public static native Pointer SDL_GetKeyboardState(
            IntByReference numkeys);

    /**
     * Clear the state of the keyboard
     *
     * <p>This function will generate key up events for all pressed keys.</p>
     *
     * @see #SDL_GetKeyboardState(IntByReference)
     * @since This function is available since SDL 2.24.0.
     */
    public static native void SDL_ResetKeyboard();

    /**
     * Get the current key modifier state for the keyboard.
     *
     * @return an OR'd combination of the modifier keys for the keyboard. See
     * SDL_Keymod for details.
     * @see #SDL_GetKeyboardState(IntByReference)
     * @see #SDL_SetModState(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_Keymod.class)
    public static native int SDL_GetModState();

    /**
     * Set the current key modifier state for the keyboard.
     *
     * <p>The inverse of SDL_GetModState(), SDL_SetModState() allows you to impose
     * modifier key states on your application. Simply pass your desired modifier
     * states into {@code modstate}. This value may be a bitwise, OR'd combination of
     * SDL_Keymod values.</p>
     *
     * <p>This does not change the keyboard state, only the key modifier flags that
     * SDL reports.</p>
     *
     * @param modstate the desired SDL_Keymod for the keyboard
     * @see #SDL_GetModState()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetModState(
            @MagicConstant(valuesFromClass = SDL_Keymod.class) int modstate);

    /**
     * Get the key code corresponding to the given scancode according to the
     * current keyboard layout.
     *
     * <p>See SDL_Keycode for details.</p>
     *
     * @param scancode the desired SDL_Scancode to query
     * @return the SDL_Keycode that corresponds to the given SDL_Scancode.
     * @see #SDL_GetKeyName(int)
     * @see #SDL_GetScancodeFromKey(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public static native int SDL_GetKeyFromScancode(
            @MagicConstant(valuesFromClass = SDL_Scancode.class) int scancode);

    /**
     * Get the scancode corresponding to the given key code according to the
     * current keyboard layout.
     *
     * <p>See SDL_Scancode for details.</p>
     *
     * @param key the desired SDL_Keycode to query
     * @return the SDL_Scancode that corresponds to the given SDL_Keycode.
     * @see #SDL_GetKeyFromScancode(int)
     * @see #SDL_GetScancodeName(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public static native int SDL_GetScancodeFromKey(
            @MagicConstant(valuesFromClass = SDL_Keycode.class) int key);

    /**
     * Get a human-readable name for a scancode.
     *
     * <p>See SDL_Scancode for details.</p>
     *
     * **Warning**: The returned name is by design not stable across platforms,
     * e.g. the name for {@code SDL_SCANCODE_LGUI} is "Left GUI" under Linux but "Left
     * Windows" under Microsoft Windows, and some scancodes like
     * {@code SDL_SCANCODE_NONUSBACKSLASH} don't have any name at all. There are even
     * scancodes that share names, e.g. {@code SDL_SCANCODE_RETURN} and
     * {@code SDL_SCANCODE_RETURN2} (both called "Return"). This function is therefore
     * unsuitable for creating a stable cross-platform two-way mapping between
     * strings and scancodes.
     *
     * @param scancode the desired SDL_Scancode to query
     * @return a pointer to the name for the scancode. If the scancode doesn't
     * have a name this function returns an empty string ("").
     * @see #SDL_GetScancodeFromKey(int)
     * @see #SDL_GetScancodeFromName(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetScancodeName(
            @MagicConstant(valuesFromClass = SDL_Scancode.class) int scancode);

    /**
     * Get a scancode from a human-readable name.
     *
     * @param name the human-readable scancode name
     * @return the SDL_Scancode, or {@code SDL_SCANCODE_UNKNOWN} if the name wasn't
     * recognized; call SDL_GetError() for more information.
     * @see #SDL_GetKeyFromName(String)
     * @see #SDL_GetScancodeFromKey(int)
     * @see #SDL_GetScancodeName(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public static native int SDL_GetScancodeFromName(
            String name);

    /**
     * Get a human-readable name for a key.
     *
     * <p>See SDL_Scancode and SDL_Keycode for details.</p>
     *
     * @param key the desired SDL_Keycode to query
     * @return a pointer to a UTF-8 string that stays valid at least until the
     * next call to this function. If you need it around any longer, you
     * must copy it. If the key doesn't have a name, this function
     * returns an empty string ("").
     * @see #SDL_GetKeyFromName(String)
     * @see #SDL_GetKeyFromScancode(int)
     * @see #SDL_GetScancodeFromKey(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetKeyName(
            @MagicConstant(valuesFromClass = SDL_Keycode.class) int key);

    /**
     * Get a key code from a human-readable name.
     *
     * @param name the human-readable key name
     * @return key code, or {@code SDLK_UNKNOWN} if the name wasn't recognized; call
     * SDL_GetError() for more information.
     * @see #SDL_GetKeyFromScancode(int)
     * @see #SDL_GetKeyName(int)
     * @see #SDL_GetScancodeFromName(String)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public static native int SDL_GetKeyFromName(
            String name);

    /**
     * Start accepting Unicode text input events.
     *
     * <p>This function will start accepting Unicode text input events in the focused
     * SDL window, and start emitting SDL_TextInputEvent (SDL_TEXTINPUT) and
     * SDL_TextEditingEvent (SDL_TEXTEDITING) events. Please use this function in
     * pair with SDL_StopTextInput().</p>
     *
     * <p>On some platforms using this function activates the screen keyboard.</p>
     *
     * @see #SDL_SetTextInputRect(SDL_Rect)
     * @see #SDL_StopTextInput()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_StartTextInput();

    /**
     * Check whether or not Unicode text input events are enabled.
     *
     * @return true if text input events are enabled else false.
     * @see #SDL_StartTextInput()
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IsTextInputActive();

    /**
     * Stop receiving any text input events.
     *
     * @see #SDL_StartTextInput()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_StopTextInput();

    /**
     * Dismiss the composition window/IME without disabling the subsystem.
     *
     * @see #SDL_StartTextInput()
     * @see #SDL_StopTextInput()
     * @since This function is available since SDL 2.0.22.
     */
    public static native void SDL_ClearComposition();

    /**
     * Returns if an IME Composite or Candidate window is currently shown.
     *
     * @since This function is available since SDL 2.0.22.
     */
    public static native boolean SDL_IsTextInputShown();

    /**
     * Set the rectangle used to type Unicode text inputs.
     *
     * <p>To start text input in a given location, this function is intended to be
     * called before SDL_StartTextInput, although some platforms support moving
     * the rectangle even while text input (and a composition) is active.</p>
     *
     * <p>Note: If you want to use the system native IME window, try setting hint
     * **SDL_HINT_IME_SHOW_UI** to **1**, otherwise this function won't give you
     * any feedback.</p>
     *
     * @param rect the SDL_Rect structure representing the rectangle to receive
     *             text (ignored if null)
     * @see #SDL_StartTextInput()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetTextInputRect(
            SDL_Rect rect);

    /**
     * Check whether the platform has screen keyboard support.
     *
     * @return true if the platform has some screen keyboard support or
     * false if not.
     * @see #SDL_StartTextInput()
     * @see #SDL_IsScreenKeyboardShown(SDL_Window)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_HasScreenKeyboardSupport();

    /**
     * Check whether the screen keyboard is shown for given window.
     *
     * @param window the window for which screen keyboard should be queried
     * @return true if screen keyboard is shown or false if not.
     * @see #SDL_HasScreenKeyboardSupport()
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IsScreenKeyboardShown(
            SDL_Window window);
}
