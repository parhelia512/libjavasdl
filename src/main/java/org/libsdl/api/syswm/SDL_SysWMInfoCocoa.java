package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window"
})
public class SDL_SysWMInfoCocoa extends Structure {

    /** The Cocoa window */
    public Pointer window;

    public SDL_SysWMInfoCocoa() {
    }

    public SDL_SysWMInfoCocoa(Pointer p) {
        super(p);
    }
}
