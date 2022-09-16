package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "window"
})
public class SDL_SysWMInfoVivante extends Structure {

    public Pointer display;
    public Pointer window;

    public SDL_SysWMInfoVivante() {
    }

    public SDL_SysWMInfoVivante(Pointer p) {
        super(p);
    }
}
