package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "display",
        "window"
})
public class SDL_SysWMInfoVivante extends JnaStructure {

    public Pointer display;
    public Pointer window;
}
