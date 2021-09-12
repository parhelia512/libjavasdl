package org.libsdl.api.mouse;

import org.libsdl.jna.JnaEnum;

public final class SDL_SystemCursor implements JnaEnum {

    public static final int SDL_SYSTEM_CURSOR_ARROW = 0;
    public static final int SDL_SYSTEM_CURSOR_IBEAM = 1;
    public static final int SDL_SYSTEM_CURSOR_WAIT = 2;
    public static final int SDL_SYSTEM_CURSOR_CROSSHAIR = 3;
    public static final int SDL_SYSTEM_CURSOR_WAITARROW = 4;
    public static final int SDL_SYSTEM_CURSOR_SIZENWSE = 5;
    public static final int SDL_SYSTEM_CURSOR_SIZENESW = 6;
    public static final int SDL_SYSTEM_CURSOR_SIZEWE = 7;
    public static final int SDL_SYSTEM_CURSOR_SIZENS = 8;
    public static final int SDL_SYSTEM_CURSOR_SIZEALL = 9;
    public static final int SDL_SYSTEM_CURSOR_NO = 10;
    public static final int SDL_SYSTEM_CURSOR_HAND = 11;
    public static final int SDL_NUM_SYSTEM_CURSORS = 12;

    private SDL_SystemCursor() {
    }
}
