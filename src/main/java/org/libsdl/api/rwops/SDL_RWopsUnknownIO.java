package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "data1",
        "data2"
})
public final class SDL_RWopsUnknownIO extends JnaStructure {

    public Pointer data1;
    public Pointer data2;

    public SDL_RWopsUnknownIO() {
    }

    public SDL_RWopsUnknownIO(Pointer p) {
        super(p);
    }
}
