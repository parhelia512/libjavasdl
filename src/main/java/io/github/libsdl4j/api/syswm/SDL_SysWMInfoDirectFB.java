package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "dfb",
        "window",
        "surface"
})
public final class SDL_SysWMInfoDirectFB extends Structure {

    /** The directfb main interface ({@code IDirectFB *}) */
    public Pointer dfb;

    /** The directfb window handle ({@code IDirectFBWindow *}) */
    public Pointer window;

    /** The directfb client surface ({@code IDirectFBSurface *}) */
    public Pointer surface;

    public SDL_SysWMInfoDirectFB() {
    }

    public SDL_SysWMInfoDirectFB(Pointer p) {
        super(p);
    }
}
