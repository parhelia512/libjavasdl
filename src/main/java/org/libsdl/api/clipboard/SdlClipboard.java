package org.libsdl.api.clipboard;

import org.libsdl.jna.NativeLoader;

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
