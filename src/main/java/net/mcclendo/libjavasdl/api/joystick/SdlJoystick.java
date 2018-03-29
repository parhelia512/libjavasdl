package net.mcclendo.libjavasdl.api.joystick;

import net.mcclendo.libjavasdl.loader.NativeLoader;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlJoystick {

    public static final int SDL_JOYSTICK_TYPE_UNKNOWN = 0;
    public static final int SDL_JOYSTICK_TYPE_GAMECONTROLLER = 1;
    public static final int SDL_JOYSTICK_TYPE_WHEEL = 2;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_STICK = 3;
    public static final int SDL_JOYSTICK_TYPE_FLIGHT_STICK = 4;
    public static final int SDL_JOYSTICK_TYPE_DANCE_PAD = 5;
    public static final int SDL_JOYSTICK_TYPE_GUITAR = 6;
    public static final int SDL_JOYSTICK_TYPE_DRUM_KIT = 7;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_PAD = 8;
    public static final int SDL_JOYSTICK_TYPE_THROTTLE = 9;

    public static final int SDL_JOYSTICK_POWER_UNKNOWN = -1;
    public static final int SDL_JOYSTICK_POWER_EMPTY = 0;
    public static final int SDL_JOYSTICK_POWER_LOW = 1;
    public static final int SDL_JOYSTICK_POWER_MEDIUM = 2;
    public static final int SDL_JOYSTICK_POWER_FULL = 3;
    public static final int SDL_JOYSTICK_POWER_WIRED = 4;
    public static final int SDL_JOYSTICK_POWER_MAX = 5;

    public static final int SDL_JOYSTICK_AXIS_MAX = 32767;
    public static final int SDL_JOYSTICK_AXIS_MIN = -32768;

    public static final int SDL_HAT_CENTERED = 0x00;
    public static final int SDL_HAT_UP = 0x01;
    public static final int SDL_HAT_RIGHT = 0x02;
    public static final int SDL_HAT_DOWN = 0x04;
    public static final int SDL_HAT_LEFT = 0x08;
    public static final int SDL_HAT_RIGHTUP = (SDL_HAT_RIGHT | SDL_HAT_UP);
    public static final int SDL_HAT_RIGHTDOWN = (SDL_HAT_RIGHT | SDL_HAT_DOWN);
    public static final int SDL_HAT_LEFTUP = (SDL_HAT_LEFT | SDL_HAT_UP);
    public static final int SDL_HAT_LEFTDOWN = (SDL_HAT_LEFT | SDL_HAT_DOWN);

    static {
        NativeLoader.loadLibrary(
                SdlJoystick.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlJoystick() {
    }


    public static native void SDL_LockJoysticks();

    public static native void SDL_UnlockJoysticks();

    public static native int SDL_NumJoysticks();

    public static native String SDL_JoystickNameForIndex(
            int deviceIndex);

    public static native SDL_JoystickGUID SDL_JoystickGetDeviceGUID(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceVendor(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceProduct(
            int deviceIndex);

    public static native short SDL_JoystickGetDeviceProductVersion(
            int deviceIndex);

    public static native int SDL_JoystickGetDeviceType(
            int deviceIndex);

    public static native int SDL_JoystickGetDeviceInstanceID(
            int deviceIndex);

    public static native SDL_Joystick SDL_JoystickOpen(
            int deviceIndex);

    public static native SDL_Joystick SDL_JoystickFromInstanceID(
            int joyid);

    public static native String SDL_JoystickName(
            SDL_Joystick joystick);

    public static native SDL_JoystickGUID SDL_JoystickGetGUID(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetVendor(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetProduct(
            SDL_Joystick joystick);

    public static native short SDL_JoystickGetProductVersion(
            SDL_Joystick joystick);

    public static native int SDL_JoystickGetType(
            SDL_Joystick joystick);

    public static native void SDL_JoystickGetGUIDString(
            SDL_JoystickGUID guid,
            String pszGUID,
            int cbGUID);

    public static native SDL_JoystickGUID SDL_JoystickGetGUIDFromString(
            String pchGUID);

    public static native boolean SDL_JoystickGetAttached(
            SDL_Joystick joystick);

    public static native int SDL_JoystickInstanceID(
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

    public static native void SDL_JoystickClose(
            SDL_Joystick joystick);

    public static native int SDL_JoystickCurrentPowerLevel(
            SDL_Joystick joystick);
}
