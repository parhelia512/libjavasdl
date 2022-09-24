package org.libsdl.api.keyboard;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.keycode.SDL_Keycode;
import org.libsdl.api.keycode.SDL_Keymod;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.scancode.SDL_Scancode;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:ConstantName",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlKeyboard {

    static {
        NativeLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    public static native SDL_Window SDL_GetKeyboardFocus();

    // TODO: Test and make more Java friendly. i.e. introduce a new Java class encapsulating the returned byte array
    public static native Pointer SDL_GetKeyboardState(
            IntByReference numkeys);

    @MagicConstant(valuesFromClass = SDL_Keymod.class)
    public static native int SDL_GetModState();

    public static native void SDL_SetModState(
            @MagicConstant(valuesFromClass = SDL_Keymod.class) int modstate);

    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public static native int SDL_GetKeyFromScancode(
            @MagicConstant(valuesFromClass = SDL_Scancode.class) int scancode);

    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public static native int SDL_GetScancodeFromKey(
            @MagicConstant(valuesFromClass = SDL_Keycode.class) int key);

    public static native String SDL_GetScancodeName(
            @MagicConstant(valuesFromClass = SDL_Scancode.class) int scancode);

    @MagicConstant(valuesFromClass = SDL_Scancode.class)
    public static native int SDL_GetScancodeFromName(
            String name);

    public static native String SDL_GetKeyName(
            @MagicConstant(valuesFromClass = SDL_Keycode.class) int key);

    @MagicConstant(valuesFromClass = SDL_Keycode.class)
    public static native int SDL_GetKeyFromName(
            String name);

    public static native void SDL_StartTextInput();

    public static native boolean SDL_IsTextInputActive();

    public static native void SDL_StopTextInput();

    public static native void SDL_SetTextInputRect(
            SDL_Rect rect);

    public static native boolean SDL_HasScreenKeyboardSupport();

    public static native boolean SDL_IsScreenKeyboardShown(
            SDL_Window window);
}
