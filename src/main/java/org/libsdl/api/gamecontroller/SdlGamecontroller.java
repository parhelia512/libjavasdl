package org.libsdl.api.gamecontroller;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.SdlSubSystemConst;
import org.libsdl.api.joystick.SDL_Joystick;
import org.libsdl.api.joystick.SDL_JoystickGUID;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.api.sensor.SDL_SensorType;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;

/**
 * <p>Adapted from SDL_gamecontroller.h.</p>
 *
 * <p>Function definitions for SDL game controller event handling.</p>
 *
 * <p>In order to use these functions, SDL_Init() must have been called
 * with the {@link SdlSubSystemConst#SDL_INIT_GAMECONTROLLER SDL_INIT_GAMECONTROLLER} flag.
 * This causes SDL to scan the system
 * for game controllers, and load appropriate drivers.</p>
 *
 * <p>If you would like to receive controller updates while the application
 * is in the background, you should set the following hint before calling
 * SDL_Init(): SDL_HINT_JOYSTICK_ALLOW_BACKGROUND_EVENTS</p>
 */
public final class SdlGamecontroller {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlGamecontroller.class);
    }

    private SdlGamecontroller() {
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

    public static String SDL_GameControllerMappingForIndex(
            int mappingIndex) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForIndex(mappingIndex);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    public static String SDL_GameControllerMappingForGUID(
            SDL_JoystickGUID guid) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForGUID(guid);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    public static String SDL_GameControllerMapping(
            SDL_GameController gamecontroller) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMapping(gamecontroller);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    public static native boolean SDL_IsGameController(
            int joystickIndex);

    public static native String SDL_GameControllerNameForIndex(
            int joystickIndex);

    public static native String SDL_GameControllerPathForIndex(
            int joystickIndex);

    @MagicConstant(valuesFromClass = SDL_GameControllerType.class)
    public static native int SDL_GameControllerTypeForIndex(
            int joystickIndex);

    public static String SDL_GameControllerMappingForDeviceIndex(
            int joystickIndex) {
        Pointer pointer = InternalNativeFunctions.SDL_GameControllerMappingForDeviceIndex(joystickIndex);
        return JnaUtils.extractStringAndReleaseNativeSdlMemory(pointer);
    }

    public static native SDL_GameController SDL_GameControllerOpen(
            int joystickIndex);

    public static native SDL_GameController SDL_GameControllerFromInstanceID(
            SDL_JoystickID joyId);

    public static native SDL_GameController SDL_GameControllerFromPlayerIndex(
            int playerIndex);

    public static native String SDL_GameControllerName(
            SDL_GameController gamecontroller);

    public static native String SDL_GameControllerPath(
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

    public static native short SDL_GameControllerGetFirmwareVersion(
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

    public static native boolean SDL_GameControllerHasRumble(
            SDL_GameController gamecontroller);

    public static native boolean SDL_GameControllerHasRumbleTriggers(
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

    public static native String SDL_GameControllerGetAppleSFSymbolsNameForButton(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerButton.class) int button);

    public static native String SDL_GameControllerGetAppleSFSymbolsNameForAxis(
            SDL_GameController gamecontroller,
            @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class) int axis);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GameControllerMappingForIndex(
                int mappingIndex);

        public static native Pointer SDL_GameControllerMappingForGUID(
                SDL_JoystickGUID guid);

        public static native Pointer SDL_GameControllerMapping(
                SDL_GameController gamecontroller);

        public static native Pointer SDL_GameControllerMappingForDeviceIndex(
                int joystickIndex);
    }
}
