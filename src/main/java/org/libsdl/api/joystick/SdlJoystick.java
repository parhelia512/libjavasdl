package org.libsdl.api.joystick;

import java.nio.charset.StandardCharsets;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;


/**
 * <p>Adapted from SDL_joystick.h</p>
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
 * with the ::SDL_INIT_JOYSTICK flag.  This causes SDL to scan the system
 * for joysticks, and load appropriate drivers.</p>
 *
 * <p>If you would like to receive joystick updates while the application
 * is in the background, you should set the following hint before calling
 * SDL_Init(): SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS</p>
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlJoystick {

    static {
        NativeLoader.registerNativeMethods(SdlJoystick.class);
    }

    private SdlJoystick() {
    }

    public static native void SDL_LockJoysticks();

    public static native void SDL_UnlockJoysticks();

    public static native int SDL_NumJoysticks();

    public static native String SDL_JoystickNameForIndex(
            int deviceIndex);

    public static native int SDL_JoystickGetDevicePlayerIndex(
            int deviceIndex);

    public static native SDL_JoystickGUID SDL_JoystickGetDeviceGUID(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceVendor(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceProduct(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceProductVersion(
            int deviceIndex);

    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static native int SDL_JoystickGetDeviceType(
            int deviceIndex);

    public static native SDL_JoystickID SDL_JoystickGetDeviceInstanceID(
            int deviceIndex);

    public static native SDL_Joystick SDL_JoystickOpen(
            int deviceIndex);

    public static native SDL_Joystick SDL_JoystickFromInstanceID(
            SDL_JoystickID instanceId);

    public static native SDL_Joystick SDL_JoystickFromPlayerIndex(
            int playerIndex);

    public static native int SDL_JoystickAttachVirtual(
            @MagicConstant(valuesFromClass = SDL_JoystickType.class) int type,
            int naxes,
            int nbuttons,
            int nhats);

    public static native int SDL_JoystickDetachVirtual(
            int deviceIndex);

    public static native boolean SDL_JoystickIsVirtual(
            int deviceIndex);

    public static native int SDL_JoystickSetVirtualAxis(
            SDL_Joystick joystick,
            int axis,
            short value);

    public static native int SDL_JoystickSetVirtualButton(
            SDL_Joystick joystick,
            int button,
            byte value);

    public static native int SDL_JoystickSetVirtualHat(
            SDL_Joystick joystick,
            int hat,
            byte value);

    public static native String SDL_JoystickName(
            SDL_Joystick joystick);

    public static native int SDL_JoystickGetPlayerIndex(
            SDL_Joystick joystick);

    public static native void SDL_JoystickSetPlayerIndex(
            SDL_Joystick joystick,
            int playerIndex);

    public static native SDL_JoystickGUID SDL_JoystickGetGUID(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetVendor(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetProduct(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetProductVersion(
            SDL_Joystick joystick);

    public static native String SDL_JoystickGetSerial(
            SDL_Joystick joystick);

    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static native int SDL_JoystickGetType(
            SDL_Joystick joystick);

    public static String SDL_JoystickGetGUIDString(
            SDL_JoystickGUID guid) {
        Memory textBuffer = new Memory(33L);
        SDL_JoystickGetGUIDString(guid, textBuffer, (int) textBuffer.size());
        return textBuffer.getString(0L, StandardCharsets.US_ASCII.toString());
    }

    /**
     * @deprecated Use more Java-style version {@link #SDL_JoystickGetGUIDString(SDL_JoystickGUID)}
     */
    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public static native void SDL_JoystickGetGUIDString(
            SDL_JoystickGUID guid,
            Pointer pszGUID,
            int cbGUID);

    public static native SDL_JoystickGUID SDL_JoystickGetGUIDFromString(
            String pchGUID);

    public static native boolean SDL_JoystickGetAttached(
            SDL_Joystick joystick);

    public static native SDL_JoystickID SDL_JoystickInstanceID(
            SDL_Joystick joystick);

    public static native int SDL_JoystickNumAxes(
            SDL_Joystick joystick);

    public static native int SDL_JoystickNumBalls(
            SDL_Joystick joystick);

    public static native int SDL_JoystickNumHats(
            SDL_Joystick joystick);

    public static native int SDL_JoystickNumButtons(
            SDL_Joystick joystick);

    public static native void SDL_JoystickUpdate();

    public static native int SDL_JoystickEventState(
            int state);

    public static native short SDL_JoystickGetAxis(
            SDL_Joystick joystick,
            int axis);

    public static native boolean SDL_JoystickGetAxisInitialState(
            SDL_Joystick joystick,
            int axis,
            ShortByReference state);

    public static native byte SDL_JoystickGetHat(
            SDL_Joystick joystick,
            int hat);

    public static native int SDL_JoystickGetBall(
            SDL_Joystick joystick,
            int ball,
            IntByReference dx,
            IntByReference dy);

    public static native byte SDL_JoystickGetButton(
            SDL_Joystick joystick,
            int button);

    public static native int SDL_JoystickRumble(
            SDL_Joystick joystick,
            short lowFrequencyRumble,
            short highFrequencyRumble,
            int durationMs);

    public static native int SDL_JoystickRumbleTriggers(
            SDL_Joystick joystick,
            short leftRumble,
            short rightRumble,
            int durationMs);

    public static native boolean SDL_JoystickHasLED(
            SDL_Joystick joystick);

    public static native int SDL_JoystickSetLED(
            SDL_Joystick joystick,
            byte red,
            byte green,
            byte blue);

    public static native int SDL_JoystickSendEffect(
            SDL_Joystick joystick,
            Pointer data,
            int size);

    public static native void SDL_JoystickClose(
            SDL_Joystick joystick);

    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public static native int SDL_JoystickCurrentPowerLevel(
            SDL_Joystick joystick);
}
