package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.PointerByReference;

/**
 * A structure representing rendering state
 */
public final class SDL_Renderer extends PointerType {

    public SDL_Renderer() {
    }

    public SDL_Renderer(Pointer p) {
        super(p);
    }

    public static final class Ref extends PointerByReference {

        public Ref() {
        }

        public Ref(Pointer value) {
            super(value);
        }

        public SDL_Renderer getRenderer() {
            return new SDL_Renderer(getValue());
        }
    }
}
