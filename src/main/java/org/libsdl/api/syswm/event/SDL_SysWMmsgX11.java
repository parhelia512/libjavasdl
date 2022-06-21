package org.libsdl.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "event"
})
public class SDL_SysWMmsgX11 extends JnaStructure {

    /** XEvent */
    public Pointer event;
}
