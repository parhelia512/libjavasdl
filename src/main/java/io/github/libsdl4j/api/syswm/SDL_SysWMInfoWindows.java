package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window",
        "hdc",
        "hinstance"
})
public final class SDL_SysWMInfoWindows extends Structure {

    /** The window handle ({@code HWND}) */
    public Pointer window;

    /** The window device context ({@code HDC}) */
    public Pointer hdc;

    /** The instance handle ({@code HINSTANCE}) */
    public Pointer hinstance;

    public SDL_SysWMInfoWindows() {
    }

    public SDL_SysWMInfoWindows(Pointer p) {
        super(p);
    }
}
