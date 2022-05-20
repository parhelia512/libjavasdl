package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;


@Structure.FieldOrder({
        "dummy"
})
public class SDL_SysWMmsgDummy extends JnaStructure {

    public Pointer dummy;
}
