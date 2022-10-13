package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "window"
})
public final class SDL_SysWMInfoCocoa extends Structure {

    /** The Cocoa window ({@code NSWindow *}) */
    public Pointer window;

    public SDL_SysWMInfoCocoa() {
    }

    public SDL_SysWMInfoCocoa(Pointer p) {
        super(p);
    }
}
