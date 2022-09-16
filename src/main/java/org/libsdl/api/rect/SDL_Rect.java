package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y",
        "w",
        "h"
})
public final class SDL_Rect extends Structure {

    public int x;
    public int y;
    public int w;
    public int h;

    public SDL_Rect() {
    }

    public SDL_Rect(Pointer p) {
        super(p);
    }
}
