package io.github.libjsdl.api.clipboard;

import io.github.libjsdl.loader.NativeLoader;

public final class SdlClipboard {

    static {
        NativeLoader.registerNativeMethods(SdlClipboard.class);
    }

    private SdlClipboard() {
    }

    public static native int SDL_SetClipboardText(
            String text);

    public static native String SDL_GetClipboardText();

    public static native boolean SDL_HasClipboardText();
}
