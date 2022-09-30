package org.libsdl.api.mouse;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.event.SdlEventsConst.SDL_DISABLE;
import static org.libsdl.api.event.SdlEventsConst.SDL_ENABLE;
import static org.libsdl.api.event.SdlEventsConst.SDL_QUERY;

public final class SdlMouse {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMouse.class);
    }

    private SdlMouse() {
    }

    public static native SDL_Window SDL_GetMouseFocus();

    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
    public static native int SDL_GetMouseState(
            IntByReference x,
            IntByReference y);

    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
    public static native int SDL_GetGlobalMouseState(
            IntByReference x,
            IntByReference y);

    @MagicConstant(flagsFromClass = SDL_ButtonMask.class)
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

    public static native int SDL_CaptureMouse(
            boolean enabled);

    public static native boolean SDL_GetRelativeMouseMode();

    public static native SDL_Cursor SDL_CreateCursor(
            Pointer data,
            Pointer mask,
            int w,
            int h,
            int hotX,
            int hotY);

    public static native SDL_Cursor SDL_CreateColorCursor(
            SDL_Surface surface,
            int hotX,
            int hotY);

    public static native SDL_Cursor SDL_CreateSystemCursor(
            @MagicConstant(valuesFromClass = SDL_SystemCursor.class) int id);

    public static native void SDL_SetCursor(
            SDL_Cursor cursor);

    public static native SDL_Cursor SDL_GetCursor();

    public static native SDL_Cursor SDL_GetDefaultCursor();

    public static native void SDL_FreeCursor(
            SDL_Cursor cursor);

    @MagicConstant(intValues = {SDL_ENABLE, SDL_DISABLE})
    public static native int SDL_ShowCursor(
            @MagicConstant(intValues = {SDL_ENABLE, SDL_DISABLE, SDL_QUERY}) int toggle);
}
