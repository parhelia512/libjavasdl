package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "dfb",
        "window",
        "surface"
})
public class SDL_SysWMInfoDirectFB extends Structure {

    /** The directfb main interface */
    public Pointer dfb;

    /** The directfb window handle */
    public Pointer window;

    /** The directfb client surface */
    public Pointer surface;

    public SDL_SysWMInfoDirectFB() {
    }

    public SDL_SysWMInfoDirectFB(Pointer p) {
        super(p);
    }
}
