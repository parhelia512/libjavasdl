package org.libsdl.api.messagebox;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.jna.NativeLoader;

public class SdlMessagebox {

    public static int SDL_ShowMessageBox(
            SDL_MessageBoxData messageboxdata,
            IntByReference buttonid) {
        return NativeFunctions.SDL_ShowMessageBox(messageboxdata, buttonid);
    }

    public static int SDL_ShowSimpleMessageBox(
            @MagicConstant(flagsFromClass = SDL_MessageBoxFlags.class) int flags,
            String title,
            String message,
            SDL_Window window) {
        return NativeFunctions.SDL_ShowSimpleMessageBox(flags, title, message, window);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native int SDL_ShowMessageBox(
                SDL_MessageBoxData messageboxdata,
                IntByReference buttonid);

        public static native int SDL_ShowSimpleMessageBox(
                @MagicConstant(flagsFromClass = SDL_MessageBoxFlags.class) int flags,
                String title,
                String message,
                SDL_Window window);
    }
}
