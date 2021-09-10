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
 * <p>The term "device_index" identifies currently plugged in joystick devices between 0 and SDL_NumJoysticks(), with the exact joystick
 * behind a device_index changing as joysticks are plugged and unplugged.</p>
 *
 * <p>The term "instance_id" is the current instantiation of a joystick device in the system, if the joystick is removed and then re-inserted
 * then it will get a new instance_id, instance_id's are monotonically increasing identifiers of a joystick plugged in.</p>
 *
 * <p>The term "player_index" is the number assigned to a player on a specific
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

    /**
     * <p>Set max recognized G-force from accelerometer</p>
     * <p>See src/joystick/uikit/SDL_sysjoystick.m for notes on why this is needed</p>
     */
    public static final double SDL_IPHONE_MAX_GFORCE = 5.0;

    public static final int SDL_JOYSTICK_AXIS_MAX = 32767;
    public static final int SDL_JOYSTICK_AXIS_MIN = -32768;

    public static final int SDL_HAT_CENTERED = 0x00;
    public static final int SDL_HAT_UP = 0x01;
    public static final int SDL_HAT_RIGHT = 0x02;
    public static final int SDL_HAT_DOWN = 0x04;
    public static final int SDL_HAT_LEFT = 0x08;
    public static final int SDL_HAT_RIGHTUP = SDL_HAT_RIGHT | SDL_HAT_UP;
    public static final int SDL_HAT_RIGHTDOWN = SDL_HAT_RIGHT | SDL_HAT_DOWN;
    public static final int SDL_HAT_LEFTUP = SDL_HAT_LEFT | SDL_HAT_UP;
    public static final int SDL_HAT_LEFTDOWN = SDL_HAT_LEFT | SDL_HAT_DOWN;

    public static void SDL_LockJoysticks() {
        NativeFunctions.SDL_LockJoysticks();
    }

    public static void SDL_UnlockJoysticks() {
        NativeFunctions.SDL_UnlockJoysticks();
    }

    public static int SDL_NumJoysticks() {
        return NativeFunctions.SDL_NumJoysticks();
    }

    public static String SDL_JoystickNameForIndex(int deviceIndex) {
        return NativeFunctions.SDL_JoystickNameForIndex(deviceIndex);
    }

    public static int SDL_JoystickGetDevicePlayerIndex(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDevicePlayerIndex(deviceIndex);
    }

    public static SDL_JoystickGUID SDL_JoystickGetDeviceGUID(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceGUID(deviceIndex);
    }

    public static short SDL_JoystickGetDeviceVendor(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceVendor(deviceIndex);
    }

    public static short SDL_JoystickGetDeviceProduct(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceProduct(deviceIndex);
    }

    public static short SDL_JoystickGetDeviceProductVersion(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceProductVersion(deviceIndex);
    }

    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static int SDL_JoystickGetDeviceType(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceType(deviceIndex);
    }

    public static SDL_JoystickID SDL_JoystickGetDeviceInstanceID(int deviceIndex) {
        return NativeFunctions.SDL_JoystickGetDeviceInstanceID(deviceIndex);
    }

    public static SDL_Joystick SDL_JoystickOpen(int deviceIndex) {
        return NativeFunctions.SDL_JoystickOpen(deviceIndex);
    }

    public static SDL_Joystick SDL_JoystickFromInstanceID(SDL_JoystickID instanceId) {
        return NativeFunctions.SDL_JoystickFromInstanceID(instanceId);
    }

    public static SDL_Joystick SDL_JoystickFromPlayerIndex(int playerIndex) {
        return NativeFunctions.SDL_JoystickFromPlayerIndex(playerIndex);
    }

    public static int SDL_JoystickAttachVirtual(@MagicConstant(valuesFromClass = SDL_JoystickType.class) int type, int naxes, int nbuttons, int nhats) {
        return NativeFunctions.SDL_JoystickAttachVirtual(type, naxes, nbuttons, nhats);
    }

    public static int SDL_JoystickDetachVirtual(int deviceIndex) {
        return NativeFunctions.SDL_JoystickDetachVirtual(deviceIndex);
    }

    public static boolean SDL_JoystickIsVirtual(int deviceIndex) {
        return NativeFunctions.SDL_JoystickIsVirtual(deviceIndex);
    }

    public static int SDL_JoystickSetVirtualAxis(SDL_Joystick joystick, int axis, short value) {
        return NativeFunctions.SDL_JoystickSetVirtualAxis(joystick, axis, value);
    }

    public static int SDL_JoystickSetVirtualButton(SDL_Joystick joystick, int button, byte value) {
        return NativeFunctions.SDL_JoystickSetVirtualButton(joystick, button, value);
    }

    public static int SDL_JoystickSetVirtualHat(SDL_Joystick joystick, int hat, byte value) {
        return NativeFunctions.SDL_JoystickSetVirtualHat(joystick, hat, value);
    }

    public static String SDL_JoystickName(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickName(joystick);
    }

    public static int SDL_JoystickGetPlayerIndex(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetPlayerIndex(joystick);
    }

    public static void SDL_JoystickSetPlayerIndex(SDL_Joystick joystick, int playerIndex) {
        NativeFunctions.SDL_JoystickSetPlayerIndex(joystick, playerIndex);
    }

    public static SDL_JoystickGUID SDL_JoystickGetGUID(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetGUID(joystick);
    }

    public static short SDL_JoystickGetVendor(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetVendor(joystick);
    }

    public static short SDL_JoystickGetProduct(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetProduct(joystick);
    }

    public static short SDL_JoystickGetProductVersion(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetProductVersion(joystick);
    }

    public static String SDL_JoystickGetSerial(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetSerial(joystick);
    }

    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public static int SDL_JoystickGetType(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetType(joystick);
    }

    public static String SDL_JoystickGetGUIDString(SDL_JoystickGUID guid) {
        Memory textBuffer = new Memory(33L);
        NativeFunctions.SDL_JoystickGetGUIDString(guid, textBuffer, (int) textBuffer.size());
        return textBuffer.getString(0L, StandardCharsets.US_ASCII.toString());
    }

    public static SDL_JoystickGUID SDL_JoystickGetGUIDFromString(String guid) {
        return NativeFunctions.SDL_JoystickGetGUIDFromString(guid);
    }

    public static boolean SDL_JoystickGetAttached(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickGetAttached(joystick);
    }

    public static SDL_JoystickID SDL_JoystickInstanceID(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickInstanceID(joystick);
    }

    public static int SDL_JoystickNumAxes(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickNumAxes(joystick);
    }

    public static int SDL_JoystickNumBalls(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickNumBalls(joystick);
    }

    public static int SDL_JoystickNumHats(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickNumHats(joystick);
    }

    public static int SDL_JoystickNumButtons(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickNumButtons(joystick);
    }

    public static void SDL_JoystickUpdate() {
        NativeFunctions.SDL_JoystickUpdate();
    }

    public static int SDL_JoystickEventState(int state) {
        return NativeFunctions.SDL_JoystickEventState(state);
    }

    public static short SDL_JoystickGetAxis(SDL_Joystick joystick, int axis) {
        return NativeFunctions.SDL_JoystickGetAxis(joystick, axis);
    }

    public static boolean SDL_JoystickGetAxisInitialState(SDL_Joystick joystick, int axis, ShortByReference state) {
        return NativeFunctions.SDL_JoystickGetAxisInitialState(joystick, axis, state);
    }

    public static byte SDL_JoystickGetHat(SDL_Joystick joystick, int hat) {
        return NativeFunctions.SDL_JoystickGetHat(joystick, hat);
    }

    public static int SDL_JoystickGetBall(SDL_Joystick joystick, int ball, IntByReference dx, IntByReference dy) {
        return NativeFunctions.SDL_JoystickGetBall(joystick, ball, dx, dy);
    }

    public static byte SDL_JoystickGetButton(SDL_Joystick joystick, int button) {
        return NativeFunctions.SDL_JoystickGetButton(joystick, button);
    }

    public static int SDL_JoystickRumble(SDL_Joystick joystick, short low_frequency_rumble, short high_frequency_rumble, int duration_ms) {
        return NativeFunctions.SDL_JoystickRumble(joystick, low_frequency_rumble, high_frequency_rumble, duration_ms);
    }

    public static int SDL_JoystickRumbleTriggers(SDL_Joystick joystick, short left_rumble, short right_rumble, int duration_ms) {
        return NativeFunctions.SDL_JoystickRumbleTriggers(joystick, left_rumble, right_rumble, duration_ms);
    }

    public static boolean SDL_JoystickHasLED(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickHasLED(joystick);
    }

    public static int SDL_JoystickSetLED(SDL_Joystick joystick, byte red, byte green, byte blue) {
        return NativeFunctions.SDL_JoystickSetLED(joystick, red, green, blue);
    }

    public static int SDL_JoystickSendEffect(SDL_Joystick joystick, Pointer data, int size) {
        return NativeFunctions.SDL_JoystickSendEffect(joystick, data, size);
    }

    public static void SDL_JoystickClose(SDL_Joystick joystick) {
        NativeFunctions.SDL_JoystickClose(joystick);
    }

    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public static int SDL_JoystickCurrentPowerLevel(SDL_Joystick joystick) {
        return NativeFunctions.SDL_JoystickCurrentPowerLevel(joystick);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
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
                short low_frequency_rumble,
                short high_frequency_rumble,
                int duration_ms);

        public static native int SDL_JoystickRumbleTriggers(
                SDL_Joystick joystick,
                short left_rumble,
                short right_rumble,
                int duration_ms);

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
}
