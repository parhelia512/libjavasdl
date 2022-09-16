package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "h",
        "buffer"
})
public final class SDL_RWopsVitaIO extends Structure {

    public Pointer h;
    public SDL_RWopsIOBuffer buffer;

    public SDL_RWopsVitaIO() {
    }

    public SDL_RWopsVitaIO(Pointer p) {
        super(p);
    }
}
