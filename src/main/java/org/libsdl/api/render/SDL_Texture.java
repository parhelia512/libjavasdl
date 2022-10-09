package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * An efficient driver-specific representation of pixel data
 */
public final class SDL_Texture extends PointerType {

    public SDL_Texture() {
    }

    public SDL_Texture(Pointer p) {
        super(p);
    }
}
