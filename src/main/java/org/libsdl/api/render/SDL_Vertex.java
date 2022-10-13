package org.libsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.api.pixels.SDL_Color;
import org.libsdl.api.rect.SDL_FPoint;

/**
 * Vertex structure
 */
@Structure.FieldOrder({
        "position",
        "color",
        "texCoord"
})
public final class SDL_Vertex extends Structure {

    /** Vertex position, in SDL_Renderer coordinates */
    public SDL_FPoint position;

    /** Vertex color */
    public SDL_Color color;

    /** Normalized texture coordinates, if needed */
    public SDL_FPoint texCoord;

    public SDL_Vertex() {
    }

    public SDL_Vertex(Pointer p) {
        super(p);
    }
}
