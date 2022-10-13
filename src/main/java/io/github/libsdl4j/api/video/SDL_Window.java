package io.github.libsdl4j.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.surface.SDL_Surface;

/**
 * The type used to identify a window
 *
 * @see SdlVideo#SDL_CreateWindow(String, int, int, int, int, int)
 * @see SdlVideo#SDL_CreateWindowFrom(Pointer)
 * @see SdlVideo#SDL_DestroyWindow(SDL_Window)
 * @see SdlVideo#SDL_FlashWindow(SDL_Window, int)
 * @see SdlVideo#SDL_GetWindowData(SDL_Window, String)
 * @see SdlVideo#SDL_GetWindowFlags(SDL_Window)
 * @see SdlVideo#SDL_GetWindowGrab(SDL_Window)
 * @see SdlVideo#SDL_GetWindowKeyboardGrab(SDL_Window)
 * @see SdlVideo#SDL_GetWindowMouseGrab(SDL_Window)
 * @see SdlVideo#SDL_GetWindowPosition(SDL_Window, IntByReference, IntByReference)
 * @see SdlVideo#SDL_GetWindowSize(SDL_Window, IntByReference, IntByReference)
 * @see SdlVideo#SDL_GetWindowTitle(SDL_Window)
 * @see SdlVideo#SDL_HideWindow(SDL_Window)
 * @see SdlVideo#SDL_MaximizeWindow(SDL_Window)
 * @see SdlVideo#SDL_MinimizeWindow(SDL_Window)
 * @see SdlVideo#SDL_RaiseWindow(SDL_Window)
 * @see SdlVideo#SDL_RestoreWindow(SDL_Window)
 * @see SdlVideo#SDL_SetWindowData(SDL_Window, String, Pointer)
 * @see SdlVideo#SDL_SetWindowFullscreen(SDL_Window, int)
 * @see SdlVideo#SDL_SetWindowGrab(SDL_Window, boolean)
 * @see SdlVideo#SDL_SetWindowKeyboardGrab(SDL_Window, boolean)
 * @see SdlVideo#SDL_SetWindowMouseGrab(SDL_Window, boolean)
 * @see SdlVideo#SDL_SetWindowIcon(SDL_Window, SDL_Surface)
 * @see SdlVideo#SDL_SetWindowPosition(SDL_Window, int, int)
 * @see SdlVideo#SDL_SetWindowSize(SDL_Window, int, int)
 * @see SdlVideo#SDL_SetWindowBordered(SDL_Window, boolean)
 * @see SdlVideo#SDL_SetWindowResizable(SDL_Window, boolean)
 * @see SdlVideo#SDL_SetWindowTitle(SDL_Window, String)
 * @see SdlVideo#SDL_ShowWindow(SDL_Window)
 */
public final class SDL_Window extends PointerType {

    public SDL_Window() {
    }

    public SDL_Window(Pointer p) {
        super(p);
    }

    public static final class Ref extends PointerByReference {

        public Ref() {
        }

        public Ref(Pointer value) {
            super(value);
        }

        public SDL_Window getWindow() {
            return new SDL_Window(getValue());
        }
    }
}
