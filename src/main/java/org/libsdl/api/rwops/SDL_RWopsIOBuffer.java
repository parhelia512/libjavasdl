package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.api.stdinc.size_t;

@Structure.FieldOrder({
        "data",
        "size",
        "left"
})
public final class SDL_RWopsIOBuffer extends Structure {

    public Pointer data;
    public size_t size;
    public size_t left;
}
