package org.libsdl.api.syswm;

import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;


@Structure.FieldOrder({
        "dummy"
})
public class SDL_SysWMInfoDummy extends JnaStructure {

    public byte[] dummy = new byte[64];
}
