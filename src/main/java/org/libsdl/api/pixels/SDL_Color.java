package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * The bits of this structure can be directly reinterpreted as an integer-packed
 * color which uses the SDL_PIXELFORMAT_RGBA32 format (SDL_PIXELFORMAT_ABGR8888
 * on little-endian systems and SDL_PIXELFORMAT_RGBA8888 on big-endian systems).
 */
@Structure.FieldOrder({
        "r",
        "g",
        "b",
        "a"
})
public final class SDL_Color extends Structure {

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public SDL_Color() {
    }

    public SDL_Color(Pointer p) {
        super(p);
    }
}
