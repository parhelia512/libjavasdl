package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_Point extends JnaStructure {

    public int x;
    public int y;

    public SDL_Point() {
    }

    public SDL_Point(Pointer p) {
        super(p);
    }
}
