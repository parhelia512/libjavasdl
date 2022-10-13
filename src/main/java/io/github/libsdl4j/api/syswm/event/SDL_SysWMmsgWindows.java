package io.github.libsdl4j.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "hwnd",
        "msg",
        "wParam",
        "lParam"
})
public final class SDL_SysWMmsgWindows extends Structure {

    /** The window for the message ({@code HWND}) */
    public Pointer hwnd;

    /** The type of message ({@code UINT}) */
    public int msg;

    /** WORD message parameter ({@code WPARAM}) */
    public Pointer wParam;

    /** LONG message parameter ({@code LPARAM}) */
    public Pointer lParam;

    public SDL_SysWMmsgWindows() {
    }

    public SDL_SysWMmsgWindows(Pointer p) {
        super(p);
    }
}
