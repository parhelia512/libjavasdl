package io.github.libsdl4j.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.pixels.SDL_Color;
import io.github.libsdl4j.api.rect.SDL_FPoint;

/**
 * Vertex structure
 */
@Structure.FieldOrder({
        "position",
        "r",
        "g",
        "b",
        "a",
        "texCoord"
})
public final class SDL_Vertex extends Structure {

    /** Vertex position, in SDL_Renderer coordinates */
    public SDL_FPoint position;

    /** Vertex color */
    public byte r;
    public byte g;
    public byte b;
    public byte a;

    /** Normalized texture coordinates, if needed */
    public SDL_FPoint texCoord;

    public SDL_Vertex() {
    }

    public SDL_Vertex(Pointer p) {
        super(p);
    }

    public SDL_Color getColor() {
        return new SDL_Color(r, g, b, a);
    }
}
