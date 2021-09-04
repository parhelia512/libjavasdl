package org.libsdl.api.mouse;

import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public final class SdlMouse {

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

    public static final int SDL_MOUSEWHEEL_NORMAL = 0;
    public static final int SDL_MOUSEWHEEL_FLIPPED = 1;

    public static final int SDL_BUTTON_LEFT = 1;
    public static final int SDL_BUTTON_MIDDLE = 2;
    public static final int SDL_BUTTON_RIGHT = 3;
    public static final int SDL_BUTTON_X1 = 4;
    public static final int SDL_BUTTON_X2 = 5;
    public static final int SDL_BUTTON_LMASK = SDL_BUTTON(SDL_BUTTON_LEFT);
    public static final int SDL_BUTTON_MMASK = SDL_BUTTON(SDL_BUTTON_MIDDLE);
    public static final int SDL_BUTTON_RMASK = SDL_BUTTON(SDL_BUTTON_RIGHT);
    public static final int SDL_BUTTON_X1MASK = SDL_BUTTON(SDL_BUTTON_X1);
    public static final int SDL_BUTTON_X2MASK = SDL_BUTTON(SDL_BUTTON_X2);

    static {
        NativeLoader.registerNativeMethods(SdlMouse.class);
    }

    private SdlMouse() {
    }

    public static native SDL_Window SDL_GetMouseFocus();

    public static native int SDL_GetMouseState(
            IntByReference x,
            IntByReference y);

    public static native int SDL_GetGlobalMouseState(
            IntByReference x,
            IntByReference y);

    public static native int SDL_GetRelativeMouseState(
            IntByReference x,
            IntByReference y);

    public static native void SDL_WarpMouseInWindow(
            SDL_Window window,
            int x,
            int y);

    public static native int SDL_WarpMouseGlobal(
            int x,
            int y);

    public static native int SDL_SetRelativeMouseMode(
            boolean enabled);

    public static native int SDL_CaptureMouse(boolean enabled);

    public static native boolean SDL_GetRelativeMouseMode();


    public static native SDL_Cursor SDL_CreateCursor(
            ByteByReference data,
            ByteByReference mask,
            int w,
            int h,
            int hotX,
            int hotY);

    public static native SDL_Cursor SDL_CreateColorCursor(
            SDL_Surface surface,
            int hotX,
            int hotY);

    public static native SDL_Cursor SDL_CreateSystemCursor(
            int id);

    public static native void SDL_SetCursor(
            SDL_Cursor cursor);

    public static native SDL_Cursor SDL_GetCursor();

    public static native SDL_Cursor SDL_GetDefaultCursor();

    public static native void SDL_FreeCursor(
            SDL_Cursor cursor);

    public static native int SDL_ShowCursor(
            int toggle);

    public static int SDL_BUTTON(
            int x) {
        return (1 << ((x) - 1));
    }
}
