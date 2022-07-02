package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "window",
        "hdc",
        "hinstance"
})
public class SDL_SysWMInfoWindows extends JnaStructure {

    /** The window handle (HWND) */
    public Pointer window;

    /** The window device context */
    public Pointer hdc;

    /** The instance handle */
    public Pointer hinstance;
}
