package org.libsdl.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;


@Structure.FieldOrder({
        "dummy"
})
public class SDL_SysWMmsgDummy extends JnaStructure {

    public int dummy;

    public SDL_SysWMmsgDummy() {
    }

    public SDL_SysWMmsgDummy(Pointer p) {
        super(p);
    }
}
