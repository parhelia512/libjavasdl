package org.libsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;

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
            return new SDL_Window(getPointer());
        }
    }
}
