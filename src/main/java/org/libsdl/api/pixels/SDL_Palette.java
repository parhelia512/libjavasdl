package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "ncolors",
        "colors",
        "version",
        "refcount"
})
public class SDL_Palette extends JnaStructure implements Structure.ByReference {

    public int ncolors;
    public Pointer colors;
    public int version;
    public int refcount;

    public SDL_Palette() {
    }

    public SDL_Palette(Pointer p) {
        super(p);
    }
}
