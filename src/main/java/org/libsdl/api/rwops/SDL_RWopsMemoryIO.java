package org.libsdl.api.rwops;

import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

@Structure.FieldOrder({
        "base",
        "here",
        "stop"
})
public final class SDL_RWopsMemoryIO extends Structure {

    public ByteByReference base;
    public ByteByReference here;
    public ByteByReference stop;
}
