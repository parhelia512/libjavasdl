package org.libsdl.api.pixels;

import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "ncolors",
        "colors",
        "version",
        "refcount"
})
public class SDL_Palette extends JnaStructure {

    public int ncolors;
    public SDL_Color.ByReference colors;
    public int version;
    public int refcount;

    public static class ByReference extends SDL_Palette implements Structure.ByReference {
    }
}
