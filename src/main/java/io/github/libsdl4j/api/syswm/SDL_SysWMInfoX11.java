package io.github.libsdl4j.api.syswm;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "window"
})
public final class SDL_SysWMInfoX11 extends Structure {

    /** The X11 display ({@code Display *}) */
    public Pointer display;

    /** The X11 window ({@code Window}) */
    public NativeLong window;

    public SDL_SysWMInfoX11() {
    }

    public SDL_SysWMInfoX11(Pointer p) {
        super(p);
    }
}
