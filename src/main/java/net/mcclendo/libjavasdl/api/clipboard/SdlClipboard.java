package net.mcclendo.libjavasdl.api.clipboard;

import net.mcclendo.libjavasdl.loader.NativeLoader;

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
