package org.libsdl.api.syswm;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "display",
        "window"
})
public class SDL_SysWMInfoX11 extends JnaStructure {

    /** The X11 display */
    public Pointer display;

    /** The X11 window */
    public NativeLong window;

    public SDL_SysWMInfoX11() {
    }

    public SDL_SysWMInfoX11(Pointer p) {
        super(p);
    }
}
