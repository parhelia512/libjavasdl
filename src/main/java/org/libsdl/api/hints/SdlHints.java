package org.libsdl.api.hints;

import com.sun.jna.Pointer;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlHints {

    static {
        NativeLoader.registerNativeMethods(SdlHints.class);
    }

    private SdlHints() {
    }

    public static native boolean SDL_SetHintWithPriority(
            String name,
            String value,
            @MagicConstant(valuesFromClass = SDL_HintPriority.class) int priority);

    public static native boolean SDL_SetHint(
            String name,
            String value);

    public static native String SDL_GetHint(
            String name);

    public static native boolean SDL_GetHintBoolean(
            String name,
            boolean defaultValue);

    public static native void SDL_AddHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    public static native void SDL_DelHintCallback(
            String name,
            SDL_HintCallback callback,
            Pointer userdata);

    public static native void SDL_ClearHints();
}
