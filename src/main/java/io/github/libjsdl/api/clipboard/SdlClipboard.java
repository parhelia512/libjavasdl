package io.github.libjsdl.api.clipboard;

import io.github.libjsdl.loader.NativeLoader;

public final class SdlClipboard {

    static {
        NativeLoader.loadLibrary(
                SdlClipboard.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlClipboard() {
    }

    public static native int SDL_SetClipboardText(
            String text);

    public static native String SDL_GetClipboardText();

    public static native boolean SDL_HasClipboardText();
}
