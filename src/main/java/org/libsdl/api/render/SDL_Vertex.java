package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.api.pixels.SDL_Color;
import org.libsdl.api.rect.SDL_FPoint;

@Structure.FieldOrder({
        "position",
        "color",
        "texCoord"
})
public final class SDL_Vertex extends Structure {

    public SDL_FPoint position;
    public SDL_Color color;
    public SDL_FPoint texCoord;

    public SDL_Vertex() {
    }

    public SDL_Vertex(Pointer p) {
        super(p);
    }
}
