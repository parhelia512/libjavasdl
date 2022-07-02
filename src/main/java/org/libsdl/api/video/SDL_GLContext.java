package org.libsdl.api.video;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public final class SDL_GLContext extends PointerType {

    public SDL_GLContext() {
    }

    public SDL_GLContext(Pointer p) {
        super(p);
    }
}
