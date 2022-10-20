package io.github.libsdl4j.api.syswm;

import io.github.libsdl4j.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

/**
 * These are the various supported windowing subsystems
 */
public final class SDL_SYSWM_TYPE implements JnaEnum {

    public static final int SDL_SYSWM_UNKNOWN = 0;
    public static final int SDL_SYSWM_WINDOWS = 1;
    public static final int SDL_SYSWM_X11 = 2;
    public static final int SDL_SYSWM_DIRECTFB = 3;
    public static final int SDL_SYSWM_COCOA = 4;
    public static final int SDL_SYSWM_UIKIT = 5;
    public static final int SDL_SYSWM_WAYLAND = 6;
    /** no longer available, left for API/ABI compatibility. Remove in 2.1! */
    public static final int SDL_SYSWM_MIR = 7;
    public static final int SDL_SYSWM_WINRT = 8;
    public static final int SDL_SYSWM_ANDROID = 9;
    public static final int SDL_SYSWM_VIVANTE = 10;
    public static final int SDL_SYSWM_OS2 = 11;
    public static final int SDL_SYSWM_HAIKU = 12;
    public static final int SDL_SYSWM_KMSDRM = 13;
    public static final int SDL_SYSWM_RISCOS = 14;

    private SDL_SYSWM_TYPE() {
    }

    public static String toString(
            @MagicConstant(valuesFromClass = SDL_SYSWM_TYPE.class) int value) {
        String subsystemName;
        switch (value) {
            case SDL_SYSWM_UNKNOWN:
                subsystemName = "Unknown";
                break;
            case SDL_SYSWM_WINDOWS:
                subsystemName = "Windows";
                break;
            case SDL_SYSWM_X11:
                subsystemName = "X11";
                break;
            case SDL_SYSWM_DIRECTFB:
                subsystemName = "DirectFB";
                break;
            case SDL_SYSWM_COCOA:
                subsystemName = "Cocoa";
                break;
            case SDL_SYSWM_UIKIT:
                subsystemName = "UIKit";
                break;
            case SDL_SYSWM_WAYLAND:
                subsystemName = "Wayland";
                break;
            case SDL_SYSWM_MIR:
                throw new IllegalArgumentException("Mir display server is not supported anymore");
            case SDL_SYSWM_WINRT:
                subsystemName = "WinRT";
                break;
            case SDL_SYSWM_ANDROID:
                subsystemName = "Android";
                break;
            case SDL_SYSWM_VIVANTE:
                subsystemName = "Vivante GPU";
                break;
            case SDL_SYSWM_OS2:
                subsystemName = "OS/2";
                break;
            case SDL_SYSWM_HAIKU:
                subsystemName = "Haiku (BeOS)";
                break;
            case SDL_SYSWM_KMSDRM:
                subsystemName = "Linux KMS/DRM";
                break;
            case SDL_SYSWM_RISCOS:
                subsystemName = "ARM RISC OS";
                break;
            default:
                throw new IllegalArgumentException("Unknown window subsystem");
        }
        return subsystemName;
    }
}
