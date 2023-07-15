package io.github.libsdl4j.api.joystick;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import io.github.libsdl4j.api.joystick.virtual.SDL_VirtualJoystickDesc;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;


/**
 * Definitions from file SDL_joystick.h
 *
 * <p>Include file for SDL joystick event handling</p>
 *
 * <p>The term "deviceIndex" identifies currently plugged in joystick devices between 0 and SDL_NumJoysticks(), with the exact joystick
 * behind a deviceIndex changing as joysticks are plugged and unplugged.</p>
 *
 * <p>The term "instanceId" is the current instantiation of a joystick device in the system, if the joystick is removed and then re-inserted
 * then it will get a new instanceId, instanceId's are monotonically increasing identifiers of a joystick plugged in.</p>
 *
 * <p>The term "playerIndex" is the number assigned to a player on a specific
 * controller. For XInput controllers this returns the XInput user index.
 * Many joysticks will not be able to supply this information.</p>
 *
 * <p>The term JoystickGUID is a stable 128-bit identifier for a joystick device that does not change over time, it identifies class of
 * the device (a X360 wired controller for example). This identifier is platform dependent.</p>
 *
 * <p>In order to use these functions, SDL_Init() must have been called
 * with the {@link io.github.libsdl4j.api.SdlSubSystemConst#SDL_INIT_JOYSTICK SDL_INIT_JOYSTICK} flag.  This causes SDL to scan the system
 * for joysticks, and load appropriate drivers.</p>
 *
 * <p>If you would like to receive joystick updates while the application
 * is in the background, you should set the following hint before calling
 * SDL_Init(): SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS</p>
 */
public final class SdlJoystick {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlJoystick.class);
    }

    private SdlJoystick() {
    }

    /**
     * Locking for multi-threaded access to the joystick API
     *
     * <p>If you are using the joystick API or handling events from multiple threads
     * you should use these locking functions to protect access to the joysticks.</p>
     *
     * <p>In particular, you are guaranteed that the joystick list won't change, so
     * the API functions that take a joystick index will be valid, and joystick
     * and game controller events will not be delivered.</p>
     *
     * <p>As of SDL 2.26.0, you can take the joystick lock around reinitializing the
     * joystick subsystem, to prevent other threads from seeing joysticks in an
     * uninitialized state. However, all open joysticks will be closed and SDL
     * functions called with them will fail.</p>
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native void SDL_LockJoysticks();

    /**
     * Unlocking for multi-threaded access to the joystick API
     *
     * <p>If you are using the joystick API or handling events from multiple threads
     * you should use these locking functions to protect access to the joysticks.</p>
     *
     * <p>In particular, you are guaranteed that the joystick list won't change, so
     * the API functions that take a joystick index will be valid, and joystick
     * and game controller events will not be delivered.</p>
     *
     * @since This function is available since SDL 2.0.7.
     */
    public static native void SDL_UnlockJoysticks();

    /**
     * Count the number of joysticks attached to the system.
     *
     * @return the number of attached joysticks on success or a negative error
     * code on failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickName(SDL_Joystick)
     * @see #SDL_JoystickPath(SDL_Joystick)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_NumJoysticks();

    /**
     * Get the implementation dependent name of a joystick.
     *
     * <p>This can be called before any joysticks are opened.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system)
     * @return the name of the selected joystick. If no name can be found, this
     * function returns null; call SDL_GetError() for more information.
     * @see #SDL_JoystickName(SDL_Joystick)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_JoystickNameForIndex(
            int deviceIndex);

    /**
     * Get the implementation dependent path of a joystick.
     *
     * <p>This can be called before any joysticks are opened.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system)
     * @return the path of the selected joystick. If no path can be found, this
     * function returns null; call SDL_GetError() for more information.
     * @see #SDL_JoystickPath(SDL_Joystick)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.24.0.
     */
    public static native String SDL_JoystickPathForIndex(
            int deviceIndex);

    /**
     * Get the player index of a joystick, or -1 if it's not available This can be
     * called before any joysticks are opened.
     *
     * @since This function is available since SDL 2.0.9.
     */
    public static native int SDL_JoystickGetDevicePlayerIndex(
            int deviceIndex);

    /**
     * Get the implementation-dependent GUID for the joystick at a given device
     * index.
     *
     * <p>This function can be called before any joysticks are opened.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the GUID of the selected joystick. If called on an invalid index,
     * this function returns a zero GUID
     * @see #SDL_JoystickGetGUID(SDL_Joystick)
     * @see #SDL_JoystickGetGUIDString(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_JoystickGUID SDL_JoystickGetDeviceGUID(
            int deviceIndex);

    /**
     * Get the USB vendor ID of a joystick, if available.
     *
     * <p>This can be called before any joysticks are opened. If the vendor ID isn't
     * available this function returns 0.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the USB vendor ID of the selected joystick. If called on an
     * invalid index, this function returns zero
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetDeviceVendor(
            int deviceIndex);

    /**
     * Get the USB product ID of a joystick, if available.
     *
     * <p>This can be called before any joysticks are opened. If the product ID isn't
     * available this function returns 0.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the USB product ID of the selected joystick. If called on an
     * invalid index, this function returns zero
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetDeviceProduct(
            int deviceIndex);

    /**
     * Get the product version of a joystick, if available.
     *
     * <p>This can be called before any joysticks are opened. If the product version
     * isn't available this function returns 0.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the product version of the selected joystick. If called on an
     * invalid index, this function returns zero
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetDeviceProductVersion(
            int deviceIndex);

    /**
     * Get the type of a joystick, if available.
     *
     * <p>This can be called before any joysticks are opened.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the SDL_JoystickType of the selected joystick. If called on an
     * invalid index, this function returns {@code SDL_JOYSTICK_TYPE_UNKNOWN}
     * @since This function is available since SDL 2.0.6.
     */
    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static native int SDL_JoystickGetDeviceType(
            int deviceIndex);

    /**
     * Get the instance ID of a joystick.
     *
     * <p>This can be called before any joysticks are opened.</p>
     *
     * @param deviceIndex the index of the joystick to query (the N'th joystick
     *                    on the system
     * @return the instance id of the selected joystick. If called on an invalid
     * index, this function returns -1
     * @since This function is available since SDL 2.0.6.
     */
    public static native SDL_JoystickID SDL_JoystickGetDeviceInstanceID(
            int deviceIndex);

    /**
     * Open a joystick for use.
     *
     * <p>The {@code deviceIndex} argument refers to the N'th joystick presently
     * recognized by SDL on the system. It is **NOT** the same as the instance ID
     * used to identify the joystick in future events. See
     * SDL_JoystickInstanceID() for more details about instance IDs.</p>
     *
     * <p>The joystick subsystem must be initialized before a joystick can be opened
     * for use.</p>
     *
     * @param deviceIndex the index of the joystick to query
     * @return a joystick identifier or null if an error occurred; call
     * SDL_GetError() for more information.
     * @see #SDL_JoystickClose(SDL_Joystick)
     * @see #SDL_JoystickInstanceID(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Joystick SDL_JoystickOpen(
            int deviceIndex);

    /**
     * Get the SDL_Joystick associated with an instance id.
     *
     * @param instanceId the instance id to get the SDL_Joystick for
     * @return an SDL_Joystick on success or null on failure; call SDL_GetError()
     * for more information.
     * @since This function is available since SDL 2.0.4.
     */
    public static native SDL_Joystick SDL_JoystickFromInstanceID(
            SDL_JoystickID instanceId);

    /**
     * Get the SDL_Joystick associated with a player index.
     *
     * @param playerIndex the player index to get the SDL_Joystick for
     * @return an SDL_Joystick on success or null on failure; call SDL_GetError()
     * for more information.
     * @since This function is available since SDL 2.0.12.
     */
    public static native SDL_Joystick SDL_JoystickFromPlayerIndex(
            int playerIndex);

    /**
     * Attach a new virtual joystick.
     *
     * @return the joystick's device index, or -1 if an error occurred.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickAttachVirtual(
            @MagicConstant(valuesFromClass = SDL_JoystickType.class) int type,
            int naxes,
            int nbuttons,
            int nhats);

    /**
     * Attach a new virtual joystick with extended properties.
     *
     * @return the joystick's device index, or -1 if an error occurred.
     * @since This function is available since SDL 2.24.0.
     */
    public static native int SDL_JoystickAttachVirtualEx(
            SDL_VirtualJoystickDesc desc);

    /**
     * Detach a virtual joystick.
     *
     * @param deviceIndex a value previously returned from
     *                    SDL_JoystickAttachVirtual()
     * @return 0 on success, or -1 if an error occurred.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickDetachVirtual(
            int deviceIndex);

    /**
     * Query whether or not the joystick at a given device index is virtual.
     *
     * @param deviceIndex a joystick device index.
     * @return true if the joystick is virtual, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_JoystickIsVirtual(
            int deviceIndex);

    /**
     * Set values on an opened, virtual-joystick's axis.
     *
     * <p>Please note that values set here will not be applied until the next call to
     * SDL_JoystickUpdate, which can either be called directly, or can be called
     * indirectly through various other SDL APIs, including, but not limited to
     * the following: SDL_PollEvent, SDL_PumpEvents, SDL_WaitEventTimeout,
     * SDL_WaitEvent.</p>
     *
     * <p>Note that when sending trigger axes, you should scale the value to the full
     * range of short data type. For example, a trigger at rest would have the value of
     * {@code SDL_JOYSTICK_AXIS_MIN}.</p>
     *
     * @param joystick the virtual joystick on which to set state.
     * @param axis     the specific axis on the virtual joystick to set.
     * @param value    the new value for the specified axis.
     * @return 0 on success, -1 on error.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickSetVirtualAxis(
            SDL_Joystick joystick,
            int axis,
            short value);

    /**
     * Set values on an opened, virtual-joystick's button.
     *
     * <p>Please note that values set here will not be applied until the next call to
     * SDL_JoystickUpdate, which can either be called directly, or can be called
     * indirectly through various other SDL APIs, including, but not limited to
     * the following: SDL_PollEvent, SDL_PumpEvents, SDL_WaitEventTimeout,
     * SDL_WaitEvent.</p>
     *
     * @param joystick the virtual joystick on which to set state.
     * @param button   the specific button on the virtual joystick to set.
     * @param value    the new value for the specified button.
     * @return 0 on success, -1 on error.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickSetVirtualButton(
            SDL_Joystick joystick,
            int button,
            byte value);

    /**
     * Set values on an opened, virtual-joystick's hat.
     *
     * <p>Please note that values set here will not be applied until the next call to
     * SDL_JoystickUpdate, which can either be called directly, or can be called
     * indirectly through various other SDL APIs, including, but not limited to
     * the following: SDL_PollEvent, SDL_PumpEvents, SDL_WaitEventTimeout,
     * SDL_WaitEvent.</p>
     *
     * @param joystick the virtual joystick on which to set state.
     * @param hat      the specific hat on the virtual joystick to set.
     * @param value    the new value for the specified hat.
     * @return 0 on success, -1 on error.
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickSetVirtualHat(
            SDL_Joystick joystick,
            int hat,
            byte value);

    /**
     * Get the implementation dependent name of a joystick.
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the name of the selected joystick. If no name can be found, this
     * function returns null; call SDL_GetError() for more information.
     * @see #SDL_JoystickNameForIndex(int)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_JoystickName(
            SDL_Joystick joystick);

    /**
     * Get the implementation dependent path of a joystick.
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the path of the selected joystick. If no path can be found, this
     * function returns null; call SDL_GetError() for more information.
     * @see #SDL_JoystickPathForIndex(int)
     * @since This function is available since SDL 2.24.0.
     */
    public static native String SDL_JoystickPath(
            SDL_Joystick joystick);

    /**
     * Get the player index of an opened joystick.
     *
     * <p>For XInput controllers this returns the XInput user index. Many joysticks
     * will not be able to supply this information.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the player index, or -1 if it's not available.
     * @since This function is available since SDL 2.0.9.
     */
    public static native int SDL_JoystickGetPlayerIndex(
            SDL_Joystick joystick);

    /**
     * Set the player index of an opened joystick.
     *
     * @param joystick    the SDL_Joystick obtained from SDL_JoystickOpen()
     * @param playerIndex Player index to assign to this joystick, or -1 to clear
     *                    the player index and turn off player LEDs.
     * @since This function is available since SDL 2.0.12.
     */
    public static native void SDL_JoystickSetPlayerIndex(
            SDL_Joystick joystick,
            int playerIndex);

    /**
     * Get the implementation-dependent GUID for the joystick.
     *
     * <p>This function requires an open joystick.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the GUID of the given joystick. If called on an invalid index,
     * this function returns a zero GUID; call SDL_GetError() for more
     * information.
     * @see #SDL_JoystickGetDeviceGUID(int)
     * @see #SDL_JoystickGetGUIDString(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_JoystickGUID SDL_JoystickGetGUID(
            SDL_Joystick joystick);

    /**
     * Get the USB vendor ID of an opened joystick, if available.
     *
     * <p>If the vendor ID isn't available this function returns 0.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the USB vendor ID of the selected joystick, or 0 if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetVendor(
            SDL_Joystick joystick);

    /**
     * Get the USB product ID of an opened joystick, if available.
     *
     * <p>If the product ID isn't available this function returns 0.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the USB product ID of the selected joystick, or 0 if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetProduct(
            SDL_Joystick joystick);

    /**
     * Get the product version of an opened joystick, if available.
     *
     * <p>If the product version isn't available this function returns 0.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the product version of the selected joystick, or 0 if unavailable.
     * @since This function is available since SDL 2.0.6.
     */
    public static native short SDL_JoystickGetProductVersion(
            SDL_Joystick joystick);

    /**
     * Get the firmware version of an opened joystick, if available.
     *
     * <p>If the firmware version isn't available this function returns 0.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the firmware version of the selected joystick, or 0 if
     * unavailable.
     * @since This function is available since SDL 2.24.0.
     */
    public static native short SDL_JoystickGetFirmwareVersion(
            SDL_Joystick joystick);

    /**
     * Get the serial number of an opened joystick, if available.
     *
     * <p>Returns the serial number of the joystick, or null if it is not available.</p>
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the serial number of the selected joystick, or null if
     * unavailable.
     * @since This function is available since SDL 2.0.14.
     */
    public static native String SDL_JoystickGetSerial(
            SDL_Joystick joystick);

    /**
     * Get the type of an opened joystick.
     *
     * @param joystick the SDL_Joystick obtained from SDL_JoystickOpen()
     * @return the SDL_JoystickType of the selected joystick.
     * @since This function is available since SDL 2.0.6.
     */
    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static native int SDL_JoystickGetType(
            SDL_Joystick joystick);

    /**
     * Get an ASCII string representation for a given SDL_JoystickGUID.
     *
     * @param guid the SDL_JoystickGUID you wish to convert to string
     * @see #SDL_JoystickGetDeviceGUID(int)
     * @see #SDL_JoystickGetGUID(SDL_Joystick)
     * @see #SDL_JoystickGetGUIDFromString(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static String SDL_JoystickGetGUIDString(
            SDL_JoystickGUID guid) {
        try (Memory textBuffer = new Memory(33L)) {
            InternalNativeFunctions.SDL_JoystickGetGUIDString(guid, textBuffer, (int) textBuffer.size());
            return textBuffer.getString(0L, "US_ASCII");
        }
    }

    /**
     * Convert a GUID string into a SDL_JoystickGUID structure.
     *
     * <p>Performs no error checking. If this function is given a string containing
     * an invalid GUID, the function will silently succeed, but the GUID generated
     * will not be useful.</p>
     *
     * @param pchGUID string containing an ASCII representation of a GUID
     * @return a SDL_JoystickGUID structure.
     * @see #SDL_JoystickGetGUIDString(SDL_JoystickGUID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_JoystickGUID SDL_JoystickGetGUIDFromString(
            String pchGUID);

    /**
     * Get the device information encoded in a SDL_JoystickGUID structure
     *
     * @param guid    the SDL_JoystickGUID you wish to get info about
     * @param vendor  A pointer filled in with the device VID, or 0 if not
     *                available
     * @param product A pointer filled in with the device PID, or 0 if not
     *                available
     * @param version A pointer filled in with the device version, or 0 if not
     *                available
     * @param crc16   A pointer filled in with a CRC used to distinguish different
     *                products with the same VID/PID, or 0 if not available
     * @see #SDL_JoystickGetDeviceGUID(int)
     * @since This function is available since SDL 2.26.0.
     */
    public static native void SDL_GetJoystickGUIDInfo(
            SDL_JoystickGUID guid,
            ShortByReference vendor,
            ShortByReference product,
            ShortByReference version,
            ShortByReference crc16);

    /**
     * Get the status of a specified joystick.
     *
     * @param joystick the joystick to query
     * @return true if the joystick has been opened, false if it has not;
     * call SDL_GetError() for more information.
     * @see #SDL_JoystickClose(SDL_Joystick)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_JoystickGetAttached(
            SDL_Joystick joystick);

    /**
     * Get the instance ID of an opened joystick.
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @return the instance ID of the specified joystick on success or a negative
     * error code on failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_JoystickID SDL_JoystickInstanceID(
            SDL_Joystick joystick);

    /**
     * Get the number of general axis controls on a joystick.
     *
     * <p>Often, the directional pad on a game controller will either look like 4
     * separate buttons or a POV hat, and not axes, but all of this is up to the
     * device and platform.</p>
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @return the number of axis controls/number of axes on success or a
     * negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_JoystickGetAxis(SDL_Joystick, int)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickNumAxes(
            SDL_Joystick joystick);

    /**
     * Get the number of trackballs on a joystick.
     *
     * <p>Joystick trackballs have only relative motion events associated with them
     * and their state cannot be polled.</p>
     *
     * <p>Most joysticks do not have trackballs.</p>
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @return the number of trackballs on success or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickGetBall(SDL_Joystick, int, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickNumBalls(
            SDL_Joystick joystick);

    /**
     * Get the number of POV hats on a joystick.
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @return the number of POV hats on success or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickGetHat(SDL_Joystick, int)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickNumHats(
            SDL_Joystick joystick);

    /**
     * Get the number of buttons on a joystick.
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @return the number of buttons on success or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickGetButton(SDL_Joystick, int)
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickNumButtons(
            SDL_Joystick joystick);

    /**
     * Update the current state of the open joysticks.
     *
     * <p>This is called automatically by the event loop if any joystick events are
     * enabled.</p>
     *
     * @see #SDL_JoystickEventState(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_JoystickUpdate();

    /**
     * Enable/disable joystick event polling.
     *
     * <p>If joystick events are disabled, you must call SDL_JoystickUpdate()
     * yourself and manually check the state of the joystick when you want
     * joystick information.</p>
     *
     * <p>It is recommended that you leave joystick event handling enabled.</p>
     *
     * **WARNING**: Calling this function may delete all events currently in SDL's
     * event queue.
     *
     * @param state can be one of {@code SDL_QUERY}, {@code SDL_IGNORE}, or {@code SDL_ENABLE}
     * @return 1 if enabled, 0 if disabled, or a negative error code on failure;
     * call SDL_GetError() for more information.
     *
     * <p>If {@code state} is {@code SDL_QUERY} then the current state is returned,
     * otherwise the new processing state is returned.</p>
     * @see io.github.libsdl4j.api.gamecontroller.SdlGamecontroller#SDL_GameControllerEventState(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickEventState(
            int state);

    /**
     * Get the current state of an axis control on a joystick.
     *
     * <p>SDL makes no promises about what part of the joystick any given axis refers
     * to. Your game should have some sort of configuration UI to let users
     * specify what each axis should be bound to. Alternately, SDL's higher-level
     * Game Controller API makes a great effort to apply order to this lower-level
     * interface, so you know that a specific axis is the "left thumb stick," etc.</p>
     *
     * <p>The value returned by SDL_JoystickGetAxis() is a signed integer (-32768 to
     * 32767) representing the current position of the axis. It may be necessary
     * to impose certain tolerances on these values to account for jitter.</p>
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @param axis     the axis to query; the axis indices start at index 0
     * @return a 16-bit signed integer representing the current position of the
     * axis or 0 on failure; call SDL_GetError() for more information.
     * @see #SDL_JoystickNumAxes(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native short SDL_JoystickGetAxis(
            SDL_Joystick joystick,
            int axis);

    /**
     * Get the initial state of an axis control on a joystick.
     *
     * <p>The state is a value ranging from -32768 to 32767.</p>
     *
     * <p>The axis indices start at index 0.</p>
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @param axis     the axis to query; the axis indices start at index 0
     * @param state    Upon return, the initial value is supplied here.
     * @return true if this axis has any initial value, or false if not.
     * @since This function is available since SDL 2.0.6.
     */
    public static native boolean SDL_JoystickGetAxisInitialState(
            SDL_Joystick joystick,
            int axis,
            ShortByReference state);

    /**
     * Get the current state of a POV hat on a joystick.
     *
     * <p>The returned value will be one of the following positions:</p>
     *
     * - {@code SDL_HAT_CENTERED}
     * - {@code SDL_HAT_UP}
     * - {@code SDL_HAT_RIGHT}
     * - {@code SDL_HAT_DOWN}
     * - {@code SDL_HAT_LEFT}
     * - {@code SDL_HAT_RIGHTUP}
     * - {@code SDL_HAT_RIGHTDOWN}
     * - {@code SDL_HAT_LEFTUP}
     * - {@code SDL_HAT_LEFTDOWN}
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @param hat      the hat index to get the state from; indices start at index 0
     * @return the current hat position.
     * @see #SDL_JoystickNumHats(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native byte SDL_JoystickGetHat(
            SDL_Joystick joystick,
            int hat);

    /**
     * Get the ball axis change since the last poll.
     *
     * <p>Trackballs can only return relative motion since the last call to
     * SDL_JoystickGetBall(), these motion deltas are placed into {@code dx} and {@code dy}.</p>
     *
     * <p>Most joysticks do not have trackballs.</p>
     *
     * @param joystick the SDL_Joystick to query
     * @param ball     the ball index to query; ball indices start at index 0
     * @param dx       stores the difference in the x axis position since the last poll
     * @param dy       stores the difference in the y axis position since the last poll
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_JoystickNumBalls(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickGetBall(
            SDL_Joystick joystick,
            int ball,
            IntByReference dx,
            IntByReference dy);

    /**
     * Get the current state of a button on a joystick.
     *
     * @param joystick an SDL_Joystick structure containing joystick information
     * @param button   the button index to get the state from; indices start at
     *                 index 0
     * @return 1 if the specified button is pressed, 0 otherwise.
     * @see #SDL_JoystickNumButtons(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native byte SDL_JoystickGetButton(
            SDL_Joystick joystick,
            int button);

    /**
     * Start a rumble effect.
     *
     * <p>Each call to this function cancels any previous rumble effect, and calling
     * it with 0 intensity stops any rumbling.</p>
     *
     * @param joystick            The joystick to vibrate
     * @param lowFrequencyRumble  The intensity of the low frequency (left)
     *                            rumble motor, from 0 to 0xFFFF
     * @param highFrequencyRumble The intensity of the high frequency (right)
     *                            rumble motor, from 0 to 0xFFFF
     * @param durationMs          The duration of the rumble effect, in milliseconds
     * @return 0, or -1 if rumble isn't supported on this joystick
     * @see #SDL_JoystickHasRumble(SDL_Joystick)
     * @since This function is available since SDL 2.0.9.
     */
    public static native int SDL_JoystickRumble(
            SDL_Joystick joystick,
            short lowFrequencyRumble,
            short highFrequencyRumble,
            int durationMs);

    /**
     * Start a rumble effect in the joystick's triggers
     *
     * <p>Each call to this function cancels any previous trigger rumble effect, and
     * calling it with 0 intensity stops any rumbling.</p>
     *
     * <p>Note that this is rumbling of the _triggers_ and not the game controller as
     * a whole. This is currently only supported on Xbox One controllers. If you
     * want the (more common) whole-controller rumble, use SDL_JoystickRumble()
     * instead.</p>
     *
     * @param joystick    The joystick to vibrate
     * @param leftRumble  The intensity of the left trigger rumble motor, from 0
     *                    to 0xFFFF
     * @param rightRumble The intensity of the right trigger rumble motor, from 0
     *                    to 0xFFFF
     * @param durationMs  The duration of the rumble effect, in milliseconds
     * @return 0, or -1 if trigger rumble isn't supported on this joystick
     * @see #SDL_JoystickHasRumbleTriggers(SDL_Joystick)
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickRumbleTriggers(
            SDL_Joystick joystick,
            short leftRumble,
            short rightRumble,
            int durationMs);

    /**
     * Query whether a joystick has an LED.
     *
     * <p>An example of a joystick LED is the light on the back of a PlayStation 4's
     * DualShock 4 controller.</p>
     *
     * @param joystick The joystick to query
     * @return true if the joystick has a modifiable LED, false otherwise.
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_JoystickHasLED(
            SDL_Joystick joystick);

    /**
     * Query whether a joystick has rumble support.
     *
     * @param joystick The joystick to query
     * @return true if the joystick has rumble, false otherwise.
     * @see #SDL_JoystickRumble(SDL_Joystick, short, short, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native boolean SDL_JoystickHasRumble(
            SDL_Joystick joystick);

    /**
     * Query whether a joystick has rumble support on triggers.
     *
     * @param joystick The joystick to query
     * @return true if the joystick has trigger rumble, false otherwise.
     * @see #SDL_JoystickRumbleTriggers(SDL_Joystick, short, short, int)
     * @since This function is available since SDL 2.0.18.
     */
    public static native boolean SDL_JoystickHasRumbleTriggers(
            SDL_Joystick joystick);

    /**
     * Update a joystick's LED color.
     *
     * <p>An example of a joystick LED is the light on the back of a PlayStation 4's
     * DualShock 4 controller.</p>
     *
     * @param joystick The joystick to update
     * @param red      The intensity of the red LED
     * @param green    The intensity of the green LED
     * @param blue     The intensity of the blue LED
     * @return 0 on success, -1 if this joystick does not have a modifiable LED
     * @since This function is available since SDL 2.0.14.
     */
    public static native int SDL_JoystickSetLED(
            SDL_Joystick joystick,
            byte red,
            byte green,
            byte blue);

    /**
     * Send a joystick specific effect packet
     *
     * @param joystick The joystick to affect
     * @param data     The data to send to the joystick
     * @param size     The size of the data to send to the joystick
     * @return 0, or -1 if this joystick or driver doesn't support effect packets
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_JoystickSendEffect(
            SDL_Joystick joystick,
            Pointer data,
            int size);

    /**
     * Close a joystick previously opened with SDL_JoystickOpen().
     *
     * @param joystick The joystick device to close
     * @see #SDL_JoystickOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_JoystickClose(
            SDL_Joystick joystick);

    /**
     * Get the battery level of a joystick as SDL_JoystickPowerLevel.
     *
     * @param joystick the SDL_Joystick to query
     * @return the current battery level as SDL_JoystickPowerLevel on success or
     * {@code SDL_JOYSTICK_POWER_UNKNOWN} if it is unknown
     * @since This function is available since SDL 2.0.4.
     */
    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public static native int SDL_JoystickCurrentPowerLevel(
            SDL_Joystick joystick);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native void SDL_JoystickGetGUIDString(
                SDL_JoystickGUID guid,
                Pointer pszGUID,
                int cbGUID);
    }
}
