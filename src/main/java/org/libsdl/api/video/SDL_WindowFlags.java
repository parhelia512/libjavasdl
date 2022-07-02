package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public final class SDL_WindowFlags implements JnaEnum {

    public static final int SDL_WINDOW_FULLSCREEN = 0x00000001;
    public static final int SDL_WINDOW_OPENGL = 0x00000002;
    public static final int SDL_WINDOW_SHOWN = 0x00000004;
    public static final int SDL_WINDOW_HIDDEN = 0x00000008;
    public static final int SDL_WINDOW_BORDERLESS = 0x00000010;
    public static final int SDL_WINDOW_RESIZABLE = 0x00000020;
    public static final int SDL_WINDOW_MINIMIZED = 0x00000040;
    public static final int SDL_WINDOW_MAXIMIZED = 0x00000080;
    public static final int SDL_WINDOW_MOUSE_GRABBED = 0x00000100;
    public static final int SDL_WINDOW_INPUT_GRABBED = SDL_WINDOW_MOUSE_GRABBED;
    public static final int SDL_WINDOW_INPUT_FOCUS = 0x00000200;
    public static final int SDL_WINDOW_MOUSE_FOCUS = 0x00000400;
    public static final int SDL_WINDOW_FULLSCREEN_DESKTOP = SDL_WINDOW_FULLSCREEN | 0x00001000;
    public static final int SDL_WINDOW_FOREIGN = 0x00000800;
    public static final int SDL_WINDOW_ALLOW_HIGHDPI = 0x00002000;
    public static final int SDL_WINDOW_MOUSE_CAPTURE = 0x00004000;
    public static final int SDL_WINDOW_ALWAYS_ON_TOP = 0x00008000;
    public static final int SDL_WINDOW_SKIP_TASKBAR = 0x00010000;
    public static final int SDL_WINDOW_UTILITY = 0x00020000;
    public static final int SDL_WINDOW_TOOLTIP = 0x00040000;
    public static final int SDL_WINDOW_POPUP_MENU = 0x00080000;
    public static final int SDL_WINDOW_KEYBOARD_GRABBED = 0x00100000;
    public static final int SDL_WINDOW_VULKAN = 0x10000000;
    public static final int SDL_WINDOW_METAL = 0x20000000;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_WINDOW_FULLSCREEN_DESKTOP) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_FULLSCREEN_DESKTOP");
        } else if ((type & SDL_WINDOW_FULLSCREEN) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_FULLSCREEN");
        }
        if ((type & SDL_WINDOW_OPENGL) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_OPENGL");
        }
        if ((type & SDL_WINDOW_SHOWN) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_SHOWN");
        }
        if ((type & SDL_WINDOW_HIDDEN) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_HIDDEN");
        }
        if ((type & SDL_WINDOW_BORDERLESS) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_BORDERLESS");
        }
        if ((type & SDL_WINDOW_RESIZABLE) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_RESIZABLE");
        }
        if ((type & SDL_WINDOW_MINIMIZED) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_MINIMIZED");
        }
        if ((type & SDL_WINDOW_MAXIMIZED) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_MAXIMIZED");
        }
        if ((type & SDL_WINDOW_MOUSE_GRABBED) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_MOUSE_GRABBED");
        }
        if ((type & SDL_WINDOW_INPUT_FOCUS) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_INPUT_FOCUS");
        }
        if ((type & SDL_WINDOW_MOUSE_FOCUS) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_MOUSE_FOCUS");
        }
        if ((type & SDL_WINDOW_FOREIGN) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_FOREIGN");
        }
        if ((type & SDL_WINDOW_ALLOW_HIGHDPI) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_ALLOW_HIGHDPI");
        }
        if ((type & SDL_WINDOW_MOUSE_CAPTURE) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_MOUSE_CAPTURE");
        }
        if ((type & SDL_WINDOW_ALWAYS_ON_TOP) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_ALWAYS_ON_TOP");
        }
        if ((type & SDL_WINDOW_SKIP_TASKBAR) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_SKIP_TASKBAR");
        }
        if ((type & SDL_WINDOW_UTILITY) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_UTILITY");
        }
        if ((type & SDL_WINDOW_TOOLTIP) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_TOOLTIP");
        }
        if ((type & SDL_WINDOW_POPUP_MENU) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_POPUP_MENU");
        }
        if ((type & SDL_WINDOW_KEYBOARD_GRABBED) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_KEYBOARD_GRABBED");
        }
        if ((type & SDL_WINDOW_VULKAN) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_VULKAN");
        }
        if ((type & SDL_WINDOW_METAL) > 0) {
            JnaUtils.append(result, "SDL_WINDOW_METAL");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_WindowFlags() {
    }
}
