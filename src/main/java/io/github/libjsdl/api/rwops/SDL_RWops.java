package io.github.libjsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "size",
        "seek",
        "read",
        "write",
        "close",
        "type"
})
public final class SDL_RWops extends Structure {

    public Pointer size;
    public Pointer seek;
    public Pointer read;
    public Pointer write;
    public Pointer close;
    public int type;
}
