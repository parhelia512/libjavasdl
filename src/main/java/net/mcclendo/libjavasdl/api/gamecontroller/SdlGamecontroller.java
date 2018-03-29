package net.mcclendo.libjavasdl.api.gamecontroller;

import net.mcclendo.libjavasdl.api.joystick.SDL_Joystick;
import net.mcclendo.libjavasdl.api.joystick.SDL_JoystickGUID;
import net.mcclendo.libjavasdl.api.rwops.SDL_RWops;
import net.mcclendo.libjavasdl.api.rwops.SdlRWops;
import net.mcclendo.libjavasdl.loader.NativeLoader;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlGamecontroller {

    private static final int SDL_CONTROLLER_BINDTYPE_NONE = 0;
    private static final int SDL_CONTROLLER_BINDTYPE_BUTTON = 1;
    private static final int SDL_CONTROLLER_BINDTYPE_AXIS = 2;
    private static final int SDL_CONTROLLER_BINDTYPE_HAT = 3;

    private static final int SDL_CONTROLLER_AXIS_INVALID = -1;
    private static final int SDL_CONTROLLER_AXIS_LEFTX = 0;
    private static final int SDL_CONTROLLER_AXIS_LEFTY = 1;
    private static final int SDL_CONTROLLER_AXIS_RIGHTX = 2;
    private static final int SDL_CONTROLLER_AXIS_RIGHTY = 3;
    private static final int SDL_CONTROLLER_AXIS_TRIGGERLEFT = 4;
    private static final int SDL_CONTROLLER_AXIS_TRIGGERRIGHT = 5;
    private static final int SDL_CONTROLLER_AXIS_MAX = 6;

    private static final int SDL_CONTROLLER_BUTTON_INVALID = -1;
    private static final int SDL_CONTROLLER_BUTTON_A = 0;
    private static final int SDL_CONTROLLER_BUTTON_B = 1;
    private static final int SDL_CONTROLLER_BUTTON_X = 2;
    private static final int SDL_CONTROLLER_BUTTON_Y = 3;
    private static final int SDL_CONTROLLER_BUTTON_BACK = 4;
    private static final int SDL_CONTROLLER_BUTTON_GUIDE = 5;
    private static final int SDL_CONTROLLER_BUTTON_START = 6;
    private static final int SDL_CONTROLLER_BUTTON_LEFTSTICK = 7;
    private static final int SDL_CONTROLLER_BUTTON_RIGHTSTICK = 8;
    private static final int SDL_CONTROLLER_BUTTON_LEFTSHOULDER = 9;
    private static final int SDL_CONTROLLER_BUTTON_RIGHTSHOULDER = 10;
    private static final int SDL_CONTROLLER_BUTTON_DPAD_UP = 11;
    private static final int SDL_CONTROLLER_BUTTON_DPAD_DOWN = 12;
    private static final int SDL_CONTROLLER_BUTTON_DPAD_LEFT = 13;
    private static final int SDL_CONTROLLER_BUTTON_DPAD_RIGHT = 14;
    private static final int SDL_CONTROLLER_BUTTON_MAX = 15;

    static {
        NativeLoader.loadLibrary(
                SdlGamecontroller.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlGamecontroller() {
    }

    public static int SDL_GameControllerAddMappingsFromFile(
            final String file) {
        return SDL_GameControllerAddMappingsFromRW(SdlRWops.SDL_RWFromFile(file, "rb"), 1);
    }

    public static native int SDL_GameControllerAddMappingsFromRW(
            SDL_RWops rw,
            int freerw);

    public static native int SDL_GameControllerAddMapping(
            String mappingString);

    public static native int SDL_GameControllerNumMappings();

    public static native String SDL_GameControllerMappingForIndex(
            int mappingIndex);

    public static native String SDL_GameControllerMappingForGUID(
            SDL_JoystickGUID guid);

    public static native String SDL_GameControllerMapping(
            SDL_GameController gamecontroller);

    public static native boolean SDL_IsGameController(
            int joystickIndex);

    public static native String SDL_GameControllerNameForIndex(
            int joystickIndex);

    public static native SDL_GameController SDL_GameControllerOpen(
            int joystickIndex);

    public static native SDL_GameController SDL_GameControllerFromInstanceID(
            int joyid);

    public static native String SDL_GameControllerName(
            SDL_GameController gamecontroller);

    public static native short SDL_GameControllerGetVendor(
            SDL_GameController gamecontroller);

    public static native short SDL_GameControllerGetProduct(
            SDL_GameController gamecontroller);

    public static native short SDL_GameControllerGetProductVersion(
            SDL_GameController gamecontroller);

    public static native boolean SDL_GameControllerGetAttached(
            SDL_GameController gamecontroller);

    public static native SDL_Joystick SDL_GameControllerGetJoystick(
            SDL_GameController gamecontroller);

    public static native int SDL_GameControllerEventState(
            int state);

    public static native void SDL_GameControllerUpdate();

    public static native int SDL_GameControllerGetAxisFromString(
            String pchString);

    public static native String SDL_GameControllerGetStringForAxis(
            int axis);

    public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForAxis(
            SDL_GameController gamecontroller,
            int axis);

    public static native short SDL_GameControllerGetAxis(
            SDL_GameController gamecontroller,
            int axis);

    public static native int SDL_GameControllerGetButtonFromString(
            String pchString);

    public static native String SDL_GameControllerGetStringForButton(
            int button);

    public static native SDL_GameControllerButtonBind SDL_GameControllerGetBindForButton(
            SDL_GameController gamecontroller,
            int button);

    public static native byte SDL_GameControllerGetButton(
            SDL_GameController gamecontroller,
            int button);

    public static native void SDL_GameControllerClose(
            SDL_GameController gamecontroller);

}
