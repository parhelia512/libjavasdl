package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window",
        "hdc",
        "hinstance"
})
public final class SDL_SysWMInfoWindows extends Structure {

    /** The window handle (HWND) */
    public Pointer window;

    /** The window device context */
    public Pointer hdc;

    /** The instance handle */
    public Pointer hinstance;
}
