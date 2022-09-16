package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_FPoint extends Structure {

    public float x;
    public float y;

    public SDL_FPoint() {
    }

    public SDL_FPoint(Pointer p) {
        super(p);
    }
}
