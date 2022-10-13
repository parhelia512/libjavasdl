package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * The flags on a window
 *
 * @see SdlVideo#SDL_GetWindowFlags(SDL_Window)
 */
public final class SDL_WindowFlags implements JnaEnum {

    /** fullscreen window */
    public static final int SDL_WINDOW_FULLSCREEN = 0x00000001;

    /** window usable with OpenGL context */
    public static final int SDL_WINDOW_OPENGL = 0x00000002;

    /** window is visible */
    public static final int SDL_WINDOW_SHOWN = 0x00000004;

    /** window is not visible */
    public static final int SDL_WINDOW_HIDDEN = 0x00000008;

    /** no window decoration */
    public static final int SDL_WINDOW_BORDERLESS = 0x00000010;

    /** window can be resized */
    public static final int SDL_WINDOW_RESIZABLE = 0x00000020;

    /** window is minimized */
    public static final int SDL_WINDOW_MINIMIZED = 0x00000040;

    /** window is maximized */
    public static final int SDL_WINDOW_MAXIMIZED = 0x00000080;

    /** window has grabbed mouse input */
    public static final int SDL_WINDOW_MOUSE_GRABBED = 0x00000100;

    /** equivalent to SDL_WINDOW_MOUSE_GRABBED for compatibility */
    public static final int SDL_WINDOW_INPUT_GRABBED = SDL_WINDOW_MOUSE_GRABBED;

    /** window has input focus */
    public static final int SDL_WINDOW_INPUT_FOCUS = 0x00000200;

    /** window has mouse focus */
    public static final int SDL_WINDOW_MOUSE_FOCUS = 0x00000400;

    public static final int SDL_WINDOW_FULLSCREEN_DESKTOP = SDL_WINDOW_FULLSCREEN | 0x00001000;

    /** window not created by SDL */
    public static final int SDL_WINDOW_FOREIGN = 0x00000800;

    /**
     * window should be created in high-DPI mode if supported.
     * On macOS NSHighResolutionCapable must be set true in the
     * application's Info.plist for this to have any effect.
     */
    public static final int SDL_WINDOW_ALLOW_HIGHDPI = 0x00002000;

    /** window has mouse captured (unrelated to MOUSE_GRABBED) */
    public static final int SDL_WINDOW_MOUSE_CAPTURE = 0x00004000;

    /** window should always be above others */
    public static final int SDL_WINDOW_ALWAYS_ON_TOP = 0x00008000;

    /** window should not be added to the taskbar */
    public static final int SDL_WINDOW_SKIP_TASKBAR = 0x00010000;

    /** window should be treated as a utility window */
    public static final int SDL_WINDOW_UTILITY = 0x00020000;

    /** window should be treated as a tooltip */
    public static final int SDL_WINDOW_TOOLTIP = 0x00040000;

    /** window should be treated as a popup menu */
    public static final int SDL_WINDOW_POPUP_MENU = 0x00080000;

    /** window has grabbed keyboard input */
    public static final int SDL_WINDOW_KEYBOARD_GRABBED = 0x00100000;

    /** window usable for Vulkan surface */
    public static final int SDL_WINDOW_VULKAN = 0x10000000;

    /** window usable for Metal view */
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
