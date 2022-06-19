package org.libsdl.api.rwops;

import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "base",
        "here",
        "stop"
})
public final class SDL_RWopsMemoryIO extends JnaStructure {

    public ByteByReference base;
    public ByteByReference here;
    public ByteByReference stop;
}
