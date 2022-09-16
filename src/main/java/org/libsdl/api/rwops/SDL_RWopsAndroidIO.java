package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "asset"
})
public final class SDL_RWopsAndroidIO extends JnaStructure {

    public Pointer asset;

    public SDL_RWopsAndroidIO() {
    }

    public SDL_RWopsAndroidIO(Pointer p) {
        super(p);
    }
}
