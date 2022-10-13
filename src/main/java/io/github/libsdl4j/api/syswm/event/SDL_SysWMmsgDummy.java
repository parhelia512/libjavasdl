package io.github.libsdl4j.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;


@Structure.FieldOrder({
        "dummy"
})
public final class SDL_SysWMmsgDummy extends Structure {

    public int dummy;

    public SDL_SysWMmsgDummy() {
    }

    public SDL_SysWMmsgDummy(Pointer p) {
        super(p);
    }
}
