package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "autoclose",
        "fp"
})
public final class SDL_RWopsStdIO extends Structure {

    public boolean autoclose;
    public Pointer fp;
}
