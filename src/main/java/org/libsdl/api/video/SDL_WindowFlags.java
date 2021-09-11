package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

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

    private SDL_WindowFlags() {
    }
}
