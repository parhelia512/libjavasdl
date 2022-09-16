package org.libsdl.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "hwnd",
        "msg",
        "wParam",
        "lParam"
})
public class SDL_SysWMmsgWindows extends Structure {

    /** The window for the message */
    public Pointer hwnd;

    /** The type of message */
    public int msg;

    /** WORD message parameter */
    public Pointer wParam;

    /** LONG message parameter */
    public Pointer lParam;

    public SDL_SysWMmsgWindows() {
    }

    public SDL_SysWMmsgWindows(Pointer p) {
        super(p);
    }
}
