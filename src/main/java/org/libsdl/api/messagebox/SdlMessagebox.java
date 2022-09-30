package org.libsdl.api.messagebox;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_ERROR;
import static org.libsdl.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_INFORMATION;
import static org.libsdl.api.messagebox.SDL_MessageBoxFlags.SDL_MESSAGEBOX_WARNING;

public final class SdlMessagebox {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlMessagebox.class);
    }

    private SdlMessagebox() {
    }

    public static native int SDL_ShowMessageBox(
            SDL_MessageBoxData messageboxdata,
            IntByReference buttonid);

    public static native int SDL_ShowSimpleMessageBox(
            @MagicConstant(flags = {SDL_MESSAGEBOX_INFORMATION, SDL_MESSAGEBOX_WARNING, SDL_MESSAGEBOX_ERROR}) int flags,
            String title,
            String message,
            SDL_Window window);
}
