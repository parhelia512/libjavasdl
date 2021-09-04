package org.libsdl.api.keyboard;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "scancode",
        "sym",
        "mod",
        "unused"
})
public final class SDL_Keysym extends Structure {

    public int scancode;
    public int sym;
    public short mod;
    public int unused;
}
