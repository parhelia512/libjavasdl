package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_WindowEventID implements JnaEnum {

    // TODO: Shouldn't it start with 0?
    public static final int SDL_WINDOWEVENT_NONE = 1;
    public static final int SDL_WINDOWEVENT_SHOWN = 2;
    public static final int SDL_WINDOWEVENT_HIDDEN = 3;
    public static final int SDL_WINDOWEVENT_EXPOSED = 4;
    public static final int SDL_WINDOWEVENT_MOVED = 5;
    public static final int SDL_WINDOWEVENT_RESIZED = 6;
    public static final int SDL_WINDOWEVENT_SIZE_CHANGED = 7;
    public static final int SDL_WINDOWEVENT_MINIMIZED = 8;
    public static final int SDL_WINDOWEVENT_MAXIMIZED = 9;
    public static final int SDL_WINDOWEVENT_RESTORED = 10;
    public static final int SDL_WINDOWEVENT_ENTER = 11;
    public static final int SDL_WINDOWEVENT_LEAVE = 12;
    public static final int SDL_WINDOWEVENT_FOCUS_GAINED = 13;
    public static final int SDL_WINDOWEVENT_FOCUS_LOST = 14;
    public static final int SDL_WINDOWEVENT_CLOSE = 15;
    public static final int SDL_WINDOWEVENT_TAKE_FOCUS = 16;
    public static final int SDL_WINDOWEVENT_HIT_TEST = 17;

    private SDL_WindowEventID() {
    }
}
