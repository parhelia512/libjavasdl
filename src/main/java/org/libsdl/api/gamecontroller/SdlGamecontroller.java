package org.libsdl.api.gamecontroller;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_Joystick;
import org.libsdl.api.joystick.SDL_JoystickGUID;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.api.sensor.SDL_SensorType;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;
import static org.libsdl.jna.JnaUtils.extractStringAndReleaseNativeMemory;

/**
 * <p>Adapted from SDL_gamecontroller.h.</p>
 *
 * <p>Function definitions for SDL game controller event handling.</p>
 *
 * <p>In order to use these functions, SDL_Init() must have been called
 * with the {@link org.libsdl.api.SDL_SubSystem#SDL_INIT_GAMECONTROLLER SDL_INIT_GAMECONTROLLER} flag.
 * This causes SDL to scan the system
 * for game controllers, and load appropriate drivers.</p>
 *
 * <p>If you would like to receive controller updates while the application
 * is in the background, you should set the following hint before calling
 * SDL_Init(): SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS</p>
 */
@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlGamecontroller {

    public static int SDL_GameControllerAddMappingsFromRW(SDL_RWops rw, int freerw) {
        return NativeFunctions.SDL_GameControllerAddMappingsFromRW(rw, freerw);
    }

    public static int SDL_GameControllerAddMappingsFromFile(String file) {
        return NativeFunctions.SDL_GameControllerAddMappingsFromFile(file);
    }

    public static int SDL_GameControllerAddMapping(String mappingString) {
        return NativeFunctions.SDL_GameControllerAddMapping(mappingString);
    }

    public static int SDL_GameControllerNumMappings() {
        return NativeFunctions.SDL_GameControllerNumMappings();
    }

    public static String SDL_GameControllerMappingForIndex(int mappingIndex) {
        Pointer pointer = NativeFunctions.SDL_GameControllerMappingForIndex(mappingIndex);
        return extractStringAndReleaseNativeMemory(pointer);
    }

    public static String SDL_GameControllerMappingForGUID(SDL_JoystickGUID guid) {
        Pointer pointer = NativeFunctions.SDL_GameControllerMappingForGUID(guid);
        return extractStringAndReleaseNativeMemory(pointer);
    }

    public static String SDL_GameControllerMapping(SDL_GameController gamecontroller) {
        Pointer pointer = NativeFunctions.SDL_GameControllerMapping(gamecontroller);
        return extractStringAndReleaseNativeMemory(pointer);
    }

    public static boolean SDL_IsGameController(int joystickIndex) {
        return NativeFunctions.SDL_IsGameController(joystickIndex);
    }

    public static String SDL_GameControllerNameForIndex(int joystickIndex) {
        return NativeFunctions.SDL_GameControllerNameForIndex(joystickIndex);
    }

    @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
    public static int SDL_GameControllerTypeForIndex(int joystickIndex) {
        return NativeFunctions.SDL_GameControllerTypeForIndex(joystickIndex);
    }

    public static String SDL_GameControllerMappingForDeviceIndex(int joystickIndex) {
        Pointer pointer = NativeFunctions.SDL_GameControllerMappingForDeviceIndex(joystickIndex);
        return extractStringAndReleaseNativeMemory(pointer);
    }

    public static SDL_GameController SDL_GameControllerOpen(int joystickIndex) {
        return NativeFunctions.SDL_GameControllerOpen(joystickIndex);
    }

    public static SDL_GameController SDL_GameControllerFromInstanceID(SDL_JoystickID joyid) {
        return NativeFunctions.SDL_GameControllerFromInstanceID(joyid);
    }

    public static SDL_GameController SDL_GameControllerFromPlayerIndex(int playerIndex) {
        return NativeFunctions.SDL_GameControllerFromPlayerIndex(playerIndex);
    }

    public static String SDL_GameControllerName(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerName(gamecontroller);
    }

    @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
    public static int SDL_GameControllerGetType(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetType(gamecontroller);
    }

    public static int SDL_GameControllerGetPlayerIndex(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetPlayerIndex(gamecontroller);
    }

    public static void SDL_GameControllerSetPlayerIndex(SDL_GameController gamecontroller, int playerIndex) {
        NativeFunctions.SDL_GameControllerSetPlayerIndex(gamecontroller, playerIndex);
    }

    public static short SDL_GameControllerGetVendor(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetVendor(gamecontroller);
    }

    public static short SDL_GameControllerGetProduct(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetProduct(gamecontroller);
    }

    public static short SDL_GameControllerGetProductVersion(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetProductVersion(gamecontroller);
    }

    public static String SDL_GameControllerGetSerial(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetSerial(gamecontroller);
    }

    public static boolean SDL_GameControllerGetAttached(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetAttached(gamecontroller);
    }

    public static SDL_Joystick SDL_GameControllerGetJoystick(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetJoystick(gamecontroller);
    }

    public static int SDL_GameControllerEventState(int state) {
        return NativeFunctions.SDL_GameControllerEventState(state);
    }

    public static void SDL_GameControllerUpdate() {
        NativeFunctions.SDL_GameControllerUpdate();
    }

    @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class)
    public static int SDL_GameControllerGetAxisFromString(String str) {
        return NativeFunctions.SDL_GameControllerGetAxisFromString(str);
    }

    public static String SDL_GameControllerGetStringForAxis(int axis) {
        return NativeFunctions.SDL_GameControllerGetStringForAxis(axis);
    }

    public static SDL_GameControllerButtonBind SDL_GameControllerGetBindForAxis(SDL_GameController gamecontroller, int axis) {
        return NativeFunctions.SDL_GameControllerGetBindForAxis(gamecontroller, axis);
    }

    public static boolean SDL_GameControllerHasAxis(SDL_GameController gamecontroller, int axis) {
        return NativeFunctions.SDL_GameControllerHasAxis(gamecontroller, axis);
    }

    public static short SDL_GameControllerGetAxis(SDL_GameController gamecontroller, int axis) {
        return NativeFunctions.SDL_GameControllerGetAxis(gamecontroller, axis);
    }

    @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
    public static int SDL_GameControllerGetButtonFromString(String str) {
        return NativeFunctions.SDL_GameControllerGetButtonFromString(str);
    }

    public static String SDL_GameControllerGetStringForButton(int button) {
        return NativeFunctions.SDL_GameControllerGetStringForButton(button);
    }

    public static SDL_GameControllerButtonBind SDL_GameControllerGetBindForButton(SDL_GameController gamecontroller, int button) {
        return NativeFunctions.SDL_GameControllerGetBindForButton(gamecontroller, button);
    }

    public static boolean SDL_GameControllerHasButton(SDL_GameController gamecontroller, int button) {
        return NativeFunctions.SDL_GameControllerHasButton(gamecontroller, button);
    }

    public static byte SDL_GameControllerGetButton(SDL_GameController gamecontroller, int button) {
        return NativeFunctions.SDL_GameControllerGetButton(gamecontroller, button);
    }

    public static int SDL_GameControllerGetNumTouchpads(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerGetNumTouchpads(gamecontroller);
    }

    public static int SDL_GameControllerGetNumTouchpadFingers(SDL_GameController gamecontroller, int touchpad) {
        return NativeFunctions.SDL_GameControllerGetNumTouchpadFingers(gamecontroller, touchpad);
    }

    public static int SDL_GameControllerGetTouchpadFinger(SDL_GameController gamecontroller, int touchpad, int finger, ByteByReference state, FloatByReference x, FloatByReference y, FloatByReference pressure) {
        return NativeFunctions.SDL_GameControllerGetTouchpadFinger(gamecontroller, touchpad, finger, state, x, y, pressure);
    }

    public static boolean SDL_GameControllerHasSensor(SDL_GameController gamecontroller, int type) {
        return NativeFunctions.SDL_GameControllerHasSensor(gamecontroller, type);
    }

    public static int SDL_GameControllerSetSensorEnabled(SDL_GameController gamecontroller, int type, boolean enabled) {
        return NativeFunctions.SDL_GameControllerSetSensorEnabled(gamecontroller, type, enabled);
    }

    public static boolean SDL_GameControllerIsSensorEnabled(SDL_GameController gamecontroller, int type) {
        return NativeFunctions.SDL_GameControllerIsSensorEnabled(gamecontroller, type);
    }

    public static float SDL_GameControllerGetSensorDataRate(SDL_GameController gamecontroller, int type) {
        return NativeFunctions.SDL_GameControllerGetSensorDataRate(gamecontroller, type);
    }

    public static int SDL_GameControllerGetSensorData(SDL_GameController gamecontroller, int type, Pointer data, int numValues) {
        return NativeFunctions.SDL_GameControllerGetSensorData(gamecontroller, type, data, numValues);
    }

    public static int SDL_GameControllerRumble(SDL_GameController gamecontroller, short lowFrequencyRumble, short highFrequencyRumble, int durationMs) {
        return NativeFunctions.SDL_GameControllerRumble(gamecontroller, lowFrequencyRumble, highFrequencyRumble, durationMs);
    }

    public static int SDL_GameControllerRumbleTriggers(SDL_GameController gamecontroller, short leftRumble, short rightRumble, int durationMs) {
        return NativeFunctions.SDL_GameControllerRumbleTriggers(gamecontroller, leftRumble, rightRumble, durationMs);
    }

    public static boolean SDL_GameControllerHasLED(SDL_GameController gamecontroller) {
        return NativeFunctions.SDL_GameControllerHasLED(gamecontroller);
    }

    public static int SDL_GameControllerSetLED(SDL_GameController gamecontroller, byte red, byte green, byte blue) {
        return NativeFunctions.SDL_GameControllerSetLED(gamecontroller, red, green, blue);
    }

    public static int SDL_GameControllerSendEffect(SDL_GameController gamecontroller, Pointer data, int size) {
        return NativeFunctions.SDL_GameControllerSendEffect(gamecontroller, data, size);
    }

    public static void SDL_GameControllerClose(SDL_GameController gamecontroller) {
        NativeFunctions.SDL_GameControllerClose(gamecontroller);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native int SDL_GameControllerAddMappingsFromRW(
                SDL_RWops rw,
                int freerw);

        public static int SDL_GameControllerAddMappingsFromFile(
                String file) {
            return SDL_GameControllerAddMappingsFromRW(SDL_RWFromFile(file, "rb"), 1);
        }

        public static native int SDL_GameControllerAddMapping(
                String mappingString);

        public static native int SDL_GameControllerNumMappings();

        public static native Pointer SDL_GameControllerMappingForIndex(
                int mappingIndex);

        public static native Pointer SDL_GameControllerMappingForGUID(
                SDL_JoystickGUID guid);

        public static native Pointer SDL_GameControllerMapping(
                SDL_GameController gamecontroller);

        public static native boolean SDL_IsGameController(
                int joystickIndex);

        public static native String SDL_GameControllerNameForIndex(
                int joystickIndex);

        @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
        public static native int SDL_GameControllerTypeForIndex(
                int joystickIndex);

        public static native Pointer SDL_GameControllerMappingForDeviceIndex(
                int joystickIndex);

        public static native SDL_GameController SDL_GameControllerOpen(
                int joystickIndex);

        public static native SDL_GameController SDL_GameControllerFromInstanceID(
                SDL_JoystickID joyId);

        public static native SDL_GameController SDL_GameControllerFromPlayerIndex(
                int playerIndex);

        public static native String SDL_GameControllerName(
                SDL_GameController gamecontroller);

        @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
        public static native int SDL_GameControllerGetType(
                SDL_GameController gamecontroller);

        public static native int SDL_GameControllerGetPlayerIndex(
                SDL_GameController gamecontroller);

        public static native void SDL_GameControllerSetPlayerIndex(
                SDL_GameController gamecontroller,
                int playerIndex);

        public static native short SDL_GameControllerGetVendor(
                SDL_GameController gamecontroller);

        public static native short SDL_GameControllerGetProduct(
                SDL_GameController gamecontroller);

        public static native short SDL_GameControllerGetProductVersion(
                SDL_GameController gamecontroller);

        public static native String SDL_GameControllerGetSerial(
                SDL_GameController gamecontroller);

        public static native boolean SDL_GameControllerGetAttached(
                SDL_GameController gamecontroller);

        public static native SDL_Joystick SDL_GameControllerGetJoystick(
                SDL_GameController gamecontroller);

        public static native int SDL_GameControllerEventState(
                int state);

        public static native void SDL_GameControllerUpdate();

        @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class)
        public static native int SDL_GameControllerGetAxisFromString(
                String str);

        public static native String SDL_GameControllerGetStringForAxis(
                @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

        public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForAxis(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

        public static native boolean SDL_GameControllerHasAxis(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

        public static native short SDL_GameControllerGetAxis(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

        @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
        public static native int SDL_GameControllerGetButtonFromString(
                String str);

        public static native String SDL_GameControllerGetStringForButton(
                @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

        public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForButton(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

        public static native boolean SDL_GameControllerHasButton(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

        public static native byte SDL_GameControllerGetButton(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);


        public static native int SDL_GameControllerGetNumTouchpads(
                SDL_GameController gamecontroller);

        public static native int SDL_GameControllerGetNumTouchpadFingers(
                SDL_GameController gamecontroller,
                int touchpad);

        public static native int SDL_GameControllerGetTouchpadFinger(
                SDL_GameController gamecontroller,
                int touchpad,
                int finger,
                ByteByReference state,
                FloatByReference x,
                FloatByReference y,
                FloatByReference pressure);

        public static native boolean SDL_GameControllerHasSensor(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

        public static native int SDL_GameControllerSetSensorEnabled(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_SensorType.class) int type,
                boolean enabled);

        public static native boolean SDL_GameControllerIsSensorEnabled(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

        public static native float SDL_GameControllerGetSensorDataRate(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

        public static native int SDL_GameControllerGetSensorData(
                SDL_GameController gamecontroller,
                @MagicConstant(valuesFromClass = SDL_SensorType.class) int type,
                Pointer data,
                int numValues);

        public static native int SDL_GameControllerRumble(
                SDL_GameController gamecontroller,
                short lowFrequencyRumble,
                short highFrequencyRumble,
                int durationMs);

        public static native int SDL_GameControllerRumbleTriggers(
                SDL_GameController gamecontroller,
                short leftRumble,
                short rightRumble,
                int durationMs);

        public static native boolean SDL_GameControllerHasLED(
                SDL_GameController gamecontroller);

        public static native int SDL_GameControllerSetLED(
                SDL_GameController gamecontroller,
                byte red,
                byte green,
                byte blue);

        public static native int SDL_GameControllerSendEffect(
                SDL_GameController gamecontroller,
                Pointer data,
                int size);

        public static native void SDL_GameControllerClose(
                SDL_GameController gamecontroller);
    }
}
