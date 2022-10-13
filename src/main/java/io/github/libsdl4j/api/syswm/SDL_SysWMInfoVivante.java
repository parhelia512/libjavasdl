package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "display",
        "window"
})
public final class SDL_SysWMInfoVivante extends Structure {

    /** {@code EGLNativeDisplayType} */
    public Pointer display;

    /** {@code EGLNativeWindowType} */
    public Pointer window;

    public SDL_SysWMInfoVivante() {
    }

    public SDL_SysWMInfoVivante(Pointer p) {
        super(p);
    }
}
