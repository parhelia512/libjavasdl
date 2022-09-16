package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "window"
})
public class SDL_SysWMInfoCocoa extends JnaStructure {

    /** The Cocoa window */
    public Pointer window;

    public SDL_SysWMInfoCocoa() {
    }

    public SDL_SysWMInfoCocoa(Pointer p) {
        super(p);
    }
}
