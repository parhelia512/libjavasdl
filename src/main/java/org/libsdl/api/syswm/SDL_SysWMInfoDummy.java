package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;


@Structure.FieldOrder({
        "dummy"
})
public class SDL_SysWMInfoDummy extends Structure {

    public byte[] dummy = new byte[64];

    public SDL_SysWMInfoDummy() {
    }

    public SDL_SysWMInfoDummy(Pointer p) {
        super(p);
    }
}
