package org.libsdl.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "event"
})
public class SDL_SysWMmsgDirectFB extends Structure {

    /** DFBEvent */
    public Pointer event;

    public SDL_SysWMmsgDirectFB() {
    }

    public SDL_SysWMmsgDirectFB(Pointer p) {
        super(p);
    }
}
