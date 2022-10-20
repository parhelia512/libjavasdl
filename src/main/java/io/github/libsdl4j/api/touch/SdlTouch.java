package io.github.libsdl4j.api.touch;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_touch.h
 *
 * <p>Include file for SDL touch event handling.</p>
 */
public final class SdlTouch {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlTouch.class);
    }

    private SdlTouch() {
    }

    /**
     * Get the number of registered touch devices.
     *
     * <p>On some platforms SDL first sees the touch device if it was actually used.
     * Therefore SDL_GetNumTouchDevices() may return 0 although devices are
     * available. After using all devices at least once the number will be
     * correct.</p>
     *
     * <p>This was fixed for Android in SDL 2.0.1.</p>
     *
     * @return the number of registered touch devices.
     * @see #SDL_GetTouchDevice(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumTouchDevices();

    /**
     * Get the touch ID with the given index.
     *
     * @param index the touch device index
     * @return the touch ID with the given index on success or 0 if the index is
     * invalid; call SDL_GetError() for more information.
     * @see #SDL_GetNumTouchDevices()
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_TouchID SDL_GetTouchDevice(
            int index);

    /**
     * Get the touch device name as reported from the driver or null if the index
     * is invalid.
     *
     * @since This function is available since SDL 2.0.22.
     */
    public static native String SDL_GetTouchName(
            int index);

    /**
     * Get the type of the given touch device.
     *
     * @since This function is available since SDL 2.0.10.
     */
    @MagicConstant(valuesFromClass = SDL_TouchDeviceType.class)
    public static native int SDL_GetTouchDeviceType(
            SDL_TouchID touchID);

    /**
     * Get the number of active fingers for a given touch device.
     *
     * @param touchID the ID of a touch device
     * @return the number of active fingers for a given touch device on success
     * or 0 on failure; call SDL_GetError() for more information.
     * @see #SDL_GetTouchFinger(SDL_TouchID, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumTouchFingers(
            SDL_TouchID touchID);

    /**
     * Get the finger object for specified touch device ID and finger index.
     *
     * <p>The returned resource is owned by SDL and should not be deallocated.</p>
     *
     * @param touchID the ID of the requested touch device
     * @param index   the index of the requested finger
     * @return a pointer to the SDL_Finger object or null if no object at the
     * given ID and index could be found.
     * @see io.github.libsdl4j.api.gesture.SdlGesture#SDL_RecordGesture(SDL_TouchID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Finger SDL_GetTouchFinger(
            SDL_TouchID touchID,
            int index);
}
