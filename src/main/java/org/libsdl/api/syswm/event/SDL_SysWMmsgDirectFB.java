package org.libsdl.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "event"
})
public class SDL_SysWMmsgDirectFB extends JnaStructure {

    /** DFBEvent */
    public Pointer event;

    public SDL_SysWMmsgDirectFB() {
    }

    public SDL_SysWMmsgDirectFB(Pointer p) {
        super(p);
    }
}
