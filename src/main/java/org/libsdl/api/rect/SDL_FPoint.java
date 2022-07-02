package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_FPoint extends JnaStructure {

    public float x;
    public float y;

    public SDL_FPoint() {
    }

    public SDL_FPoint(Pointer p) {
        super(p);
    }
}
