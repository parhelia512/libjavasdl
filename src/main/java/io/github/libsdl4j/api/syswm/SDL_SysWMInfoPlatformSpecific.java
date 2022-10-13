package io.github.libsdl4j.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Union;

/**
 * The structure field sizes are converted according to the JNA\contrib\platform project. Hopefully it is correct.
 */
public final class SDL_SysWMInfoPlatformSpecific extends Union {

    public SDL_SysWMInfoWindows win;
    public SDL_SysWMInfoWinRT winrt;
    public SDL_SysWMInfoX11 x11;
    public SDL_SysWMInfoDirectFB dfb;
    public SDL_SysWMInfoCocoa cocoa;
    public SDL_SysWMInfoUIKit uikit;
    public SDL_SysWMInfoWayland wl;
    public SDL_SysWMInfoAndroid android;
    public SDL_SysWMInfoVivante vivante;
    public SDL_SysWMInfoKmsDrm kmsdrm;
    public SDL_SysWMInfoDummy dummy;

    public SDL_SysWMInfoPlatformSpecific() {
    }

    public SDL_SysWMInfoPlatformSpecific(Pointer p) {
        super(p);
    }
}
