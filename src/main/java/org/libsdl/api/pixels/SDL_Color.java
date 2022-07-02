package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "r",
        "g",
        "b",
        "a"
})
public class SDL_Color extends JnaStructure {

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public SDL_Color() {
    }

    public SDL_Color(Pointer p) {
        super(p);
    }

    public static class Ref extends SDL_Color implements Structure.ByReference {

        public Ref() {
        }

        public Ref(Pointer p) {
            super(p);
        }
    }
}
