package io.github.libsdl4j.api.syswm.event;

import com.sun.jna.Pointer;
import com.sun.jna.Union;

public final class SDL_SysWMmsgPlatformSpecific extends Union {

    public SDL_SysWMmsgWindows win;
    public SDL_SysWMmsgX11 x11;
    public SDL_SysWMmsgDirectFB dfb;
    public SDL_SysWMmsgDummy dummy;

    public SDL_SysWMmsgPlatformSpecific() {
    }

    public SDL_SysWMmsgPlatformSpecific(Pointer p) {
        super(p);
    }
}
