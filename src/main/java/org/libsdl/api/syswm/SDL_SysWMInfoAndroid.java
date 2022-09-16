package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "window",
        "surface"
})
public class SDL_SysWMInfoAndroid extends JnaStructure {

    public Pointer window;
    public Pointer surface;

    public SDL_SysWMInfoAndroid() {
    }

    public SDL_SysWMInfoAndroid(Pointer p) {
        super(p);
    }
}
