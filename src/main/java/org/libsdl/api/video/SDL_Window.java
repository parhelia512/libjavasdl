package org.libsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public final class SDL_Window extends PointerType {

    public SDL_Window() {
    }

    public SDL_Window(Pointer p) {
        super(p);
    }
}
