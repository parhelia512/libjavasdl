package io.github.libsdl4j.api.gesture;

import io.github.libsdl4j.api.rwops.SDL_RWops;
import io.github.libsdl4j.api.touch.SDL_TouchID;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_gesture.h
 *
 * <p>Include file for SDL gesture event handling.</p>
 */
public final class SdlGesture {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlGesture.class);
    }

    private SdlGesture() {
    }

    /**
     * Begin recording a gesture on a specified touch device or all touch devices.
     *
     * <p>If the parameter {@code touchId} is -1 (i.e., all devices), this function will
     * always return 1, regardless of whether there actually are any devices.</p>
     *
     * @param touchId the touch device id, or -1 for all touch devices
     * @return 1 on success or 0 if the specified device could not be found.
     * @see io.github.libsdl4j.api.touch.SdlTouch#SDL_GetTouchDevice(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_RecordGesture(
            SDL_TouchID touchId);

    /**
     * Save all currently loaded Dollar Gesture templates.
     *
     * @param dst a SDL_RWops to save to
     * @return the number of saved templates on success or 0 on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_LoadDollarTemplates(SDL_TouchID, SDL_RWops)
     * @see #SDL_SaveDollarTemplate(SDL_GestureID, SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SaveAllDollarTemplates(
            SDL_RWops dst);

    /**
     * Save a currently loaded Dollar Gesture template.
     *
     * @param gestureId a gesture id
     * @param dst       a SDL_RWops to save to
     * @return 1 on success or 0 on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_LoadDollarTemplates(SDL_TouchID, SDL_RWops)
     * @see #SDL_SaveAllDollarTemplates(SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SaveDollarTemplate(
            SDL_GestureID gestureId,
            SDL_RWops dst);

    /**
     * Load Dollar Gesture templates from a file.
     *
     * @param touchId a touch id
     * @param src     a SDL_RWops to load from
     * @return the number of loaded templates on success or a negative error code
     * (or 0) on failure; call SDL_GetError() for more information.
     * @see #SDL_SaveAllDollarTemplates(SDL_RWops)
     * @see #SDL_SaveDollarTemplate(SDL_GestureID, SDL_RWops)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_LoadDollarTemplates(
            SDL_TouchID touchId,
            SDL_RWops src);
}
