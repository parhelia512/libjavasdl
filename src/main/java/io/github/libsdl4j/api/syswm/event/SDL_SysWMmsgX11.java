package io.github.libsdl4j.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "event"
})
public final class SDL_SysWMmsgX11 extends Structure {

    /** XEvent */
    public Pointer event;

    public SDL_SysWMmsgX11() {
    }

    public SDL_SysWMmsgX11(Pointer p) {
        super(p);
    }
}
