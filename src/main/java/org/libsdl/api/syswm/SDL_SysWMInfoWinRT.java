package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "window"
})
public class SDL_SysWMInfoWinRT extends JnaStructure {

    /** The WinRT CoreWindow */
    public Pointer window;

    public SDL_SysWMInfoWinRT() {
    }

    public SDL_SysWMInfoWinRT(Pointer p) {
        super(p);
    }
}
