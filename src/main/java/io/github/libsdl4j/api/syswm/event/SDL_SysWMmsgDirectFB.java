package io.github.libsdl4j.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "event"
})
public final class SDL_SysWMmsgDirectFB extends Structure {

    /** {@code DFBEvent} */
    public Pointer event;

    public SDL_SysWMmsgDirectFB() {
    }

    public SDL_SysWMmsgDirectFB(Pointer p) {
        super(p);
    }
}
