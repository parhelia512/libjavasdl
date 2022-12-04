package io.github.libsdl4j.api.hints;

import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_hints.h
 *
 * <p>Official documentation for SDL configuration variables</p>
 *
 * <p>This file contains functions to set and get configuration hints,
 * as well as listing each of them alphabetically.</p>
 *
 * <p>The convention for naming hints is SDL_HINT_X, where "SDL_X" is
 * the environment variable that can be used to override the default.</p>
 *
 * <p>In general these hints are just that - they may or may not be
 * supported or applicable on any given platform, but they provide
 * a way for an application or user to give the library a hint as
 * to how they would like the library to work.</p>
 */
public final class SdlHints {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlHints.class);
    }

    private SdlHints() {
    }

    /**
     * Set a hint with a specific priority.
     *
     * <p>The priority controls the behavior when setting a hint that already has a
     * value. Hints will replace existing hints of their priority and lower.
     * Environment variables are considered to have override priority.</p>
     *
     * @param name     the hint to set
     * @param value    the value of the hint variable
     * @param priority the SDL_HintPriority level for the hint
     * @return true if the hint was set, false otherwise.
     * @see #SDL_GetHint(String)
     * @see #SDL_SetHint(String, String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_SetHintWithPriority(
            String name,
            String value,
            @MagicConstant(valuesFromClass = SDL_HintPriority.class) int priority);

    /**
     * Set a hint with normal priority.
     *
     * <p>Hints will not be set if there is an existing override hint or environment
     * variable that takes precedence. You can use SDL_SetHintWithPriority() to
     * set the hint with override priority instead.</p>
     *
     * @param name  the hint to set
     * @param value the value of the hint variable
     * @return true if the hint was set, false otherwise.
     * @see #SDL_GetHint(String)
     * @see #SDL_SetHintWithPriority(String, String, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_SetHint(
            String name,
            String value);

    /**
     * Reset a hint to the default value.
     *
     * <p>This will reset a hint to the value of the environment variable, or null if
     * the environment isn't set. Callbacks will be called normally with this
     * change.</p>
     *
     * @param name the hint to set
     * @return true if the hint was set, false otherwise.
     * @see #SDL_GetHint(String)
     * @see #SDL_SetHint(String, String)
     * @since This function is available since SDL 2.24.0.
     */
    public static native boolean SDL_ResetHint(
            String name);

    /**
     * Reset all hints to the default values.
     *
     * <p>This will reset all hints to the value of the associated environment
     * variable, or null if the environment isn't set. Callbacks will be called
     * normally with this change.</p>
     *
     * @see #SDL_GetHint(String)
     * @see #SDL_SetHint(String, String)
     * @see #SDL_ResetHint(String)
     * @since This function is available since SDL 2.26.0.
     */
    public static native void SDL_ResetHints();

    /**
     * Get the value of a hint.
     *
     * @param name the hint to query
     * @return the string value of a hint or null if the hint isn't set.
     * @see #SDL_SetHint(String, String)
     * @see #SDL_SetHintWithPriority(String, String, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetHint(
            String name);

    /**
     * Get the boolean value of a hint variable.
     *
     * @param name         the name of the hint to get the boolean value from
     * @param defaultValue the value to return if the hint does not exist
     * @return the boolean value of a hint or the provided default value if the
     * hint does not exist.
     * @see #SDL_GetHint(String)
     * @see #SDL_SetHint(String, String)
     * @since This function is available since SDL 2.0.5.
     */
    public static native boolean SDL_GetHintBoolean(
            String name,
            boolean defaultValue);

    /**
     * Add a function to watch a particular hint.
     *
     * @param name     the hint to watch
     * @param callback An SDL_HintCallback function that will be called when the
     *                 hint value changes
     * @param userdata a pointer to pass to the callback function
     * @see #SDL_DelHintCallback(String, SDL_HintCallback, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_AddHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    /**
     * Remove a function watching a particular hint.
     *
     * @param name     the hint being watched
     * @param callback An SDL_HintCallback function that should no longer be called when the
     *                 hint value changes
     * @param userdata a pointer being passed to the callback function
     * @see #SDL_AddHintCallback(String, SDL_HintCallback, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DelHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    /**
     * Clear all hints.
     *
     * <p>This function is automatically called during SDL_Quit(), and deletes all
     * callbacks without calling them and frees all memory associated with hints.
     * If you're calling this from application code you probably want to call
     * SDL_ResetHints() instead.</p>
     *
     * <p>This function will be removed from the API the next time we rev the ABI.</p>
     *
     * @see #SDL_ResetHints()
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_ClearHints();
}
