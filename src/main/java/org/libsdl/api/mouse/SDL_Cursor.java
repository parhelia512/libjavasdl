package org.libsdl.api.mouse;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public final class SDL_Cursor extends PointerType {

    public SDL_Cursor() {
    }

    public SDL_Cursor(Pointer p) {
        super(p);
    }
}
