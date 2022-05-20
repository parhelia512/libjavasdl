package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "hwnd",
        "msg",
        "wParam",
        "lParam"
})
public class SDL_SysWMmsgWindows extends JnaStructure {

    /** The window for the message */
    public Pointer hwnd;

    /** The type of message */
    public int msg;

    /** WORD message parameter */
    public Pointer wParam;

    /** LONG message parameter */
    public Pointer lParam;
}
