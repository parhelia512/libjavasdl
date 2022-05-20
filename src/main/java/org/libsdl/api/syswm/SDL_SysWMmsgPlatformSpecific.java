package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.TypeMapper;
import com.sun.jna.Union;

public class SDL_SysWMmsgPlatformSpecific extends Union {

    public SDL_SysWMmsgWindows win;
    public SDL_SysWMmsgX11 x11;
    public SDL_SysWMmsgDummy dummy;
}
