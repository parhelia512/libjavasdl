package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "autoclose",
        "fp"
})
public final class SDL_RWopsStdIO extends JnaStructure {

    public boolean autoclose;
    public Pointer fp;

    public SDL_RWopsStdIO() {
    }

    public SDL_RWopsStdIO(Pointer p) {
        super(p);
    }
}
