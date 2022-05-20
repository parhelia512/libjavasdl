package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "dfb",
        "window",
        "surface"
})
public class SDL_SysWMInfoDirectFB extends JnaStructure {

    /** The directfb main interface */
    public Pointer dfb;

    /** The directfb window handle */
    public Pointer window;

    /** The directfb client surface */
    public Pointer surface;

}
