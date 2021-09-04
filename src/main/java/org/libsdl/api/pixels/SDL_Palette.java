package org.libsdl.api.pixels;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "ncolors",
        "colors",
        "version",
        "refcount"
})
public final class SDL_Palette extends Structure {

    public int ncolors;
    public SDL_Color colors;
    public int version;
    public int refcount;
}
