package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_WindowEventID implements JnaEnum {

    public static final int SDL_WINDOWEVENT_NONE = 0;
    public static final int SDL_WINDOWEVENT_SHOWN = 1;
    public static final int SDL_WINDOWEVENT_HIDDEN = 2;
    public static final int SDL_WINDOWEVENT_EXPOSED = 3;
    public static final int SDL_WINDOWEVENT_MOVED = 4;
    public static final int SDL_WINDOWEVENT_RESIZED = 5;
    public static final int SDL_WINDOWEVENT_SIZE_CHANGED = 6;
    public static final int SDL_WINDOWEVENT_MINIMIZED = 7;
    public static final int SDL_WINDOWEVENT_MAXIMIZED = 8;
    public static final int SDL_WINDOWEVENT_RESTORED = 9;
    public static final int SDL_WINDOWEVENT_ENTER = 10;
    public static final int SDL_WINDOWEVENT_LEAVE = 11;
    public static final int SDL_WINDOWEVENT_FOCUS_GAINED = 12;
    public static final int SDL_WINDOWEVENT_FOCUS_LOST = 13;
    public static final int SDL_WINDOWEVENT_CLOSE = 14;
    public static final int SDL_WINDOWEVENT_TAKE_FOCUS = 15;
    public static final int SDL_WINDOWEVENT_HIT_TEST = 16;

    // TODO: Generate public static String toString(int value)

    private SDL_WindowEventID() {
    }
}
