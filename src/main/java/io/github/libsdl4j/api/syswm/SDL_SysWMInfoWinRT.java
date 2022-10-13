package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window"
})
public final class SDL_SysWMInfoWinRT extends Structure {

    /** The WinRT CoreWindow ({@code IInspectable *}) */
    public Pointer window;

    public SDL_SysWMInfoWinRT() {
    }

    public SDL_SysWMInfoWinRT(Pointer p) {
        super(p);
    }
}
