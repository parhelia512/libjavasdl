package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
public final class SDL_FRect extends Structure {

    public float x;
    public float y;
    public float w;
    public float h;

    public SDL_FRect() {
    }

    public SDL_FRect(Pointer p) {
        super(p);
    }
}
