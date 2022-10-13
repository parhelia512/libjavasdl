package io.github.libsdl4j.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "ncolors",
        "colors",
        "version",
        "refcount"
})
public final class SDL_Palette_internal extends Structure {

    public int ncolors;
    public Pointer colors;
    public int version;
    public int refcount;

    public SDL_Palette_internal(Pointer p) {
        super(p);
    }
}
