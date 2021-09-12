package org.libsdl.api.gesture;

import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.api.touch.SDL_TouchID;
import org.libsdl.jna.NativeLoader;

public class SdlGesture {

    public static int SDL_RecordGesture(SDL_TouchID touchId) {
        return NativeFunctions.SDL_RecordGesture(touchId);
    }

    public static int SDL_SaveAllDollarTemplates(SDL_RWops dst) {
        return NativeFunctions.SDL_SaveAllDollarTemplates(dst);
    }

    public static int SDL_SaveDollarTemplate(SDL_GestureID gestureId, SDL_RWops dst) {
        return NativeFunctions.SDL_SaveDollarTemplate(gestureId, dst);
    }

    public static int SDL_LoadDollarTemplates(SDL_TouchID touchId, SDL_RWops src) {
        return NativeFunctions.SDL_LoadDollarTemplates(touchId, src);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native int SDL_RecordGesture(
                SDL_TouchID touchId);

        public static native int SDL_SaveAllDollarTemplates(
                SDL_RWops dst);

        public static native int SDL_SaveDollarTemplate(
                SDL_GestureID gestureId,
                SDL_RWops dst);

        public static native int SDL_LoadDollarTemplates(
                SDL_TouchID touchId,
                SDL_RWops src);
    }
}
