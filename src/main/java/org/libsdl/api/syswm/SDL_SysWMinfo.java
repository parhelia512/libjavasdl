package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.version.SDL_version;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_ANDROID;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_COCOA;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_DIRECTFB;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_KMSDRM;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_UIKIT;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_VIVANTE;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WAYLAND;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WINDOWS;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WINRT;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_X11;

@Structure.FieldOrder({
        "version",
        "subsystem",
        "info"
})
public class SDL_SysWMinfo extends JnaStructure {

    public SDL_version version;
    @MagicConstant(valuesFromClass = SDL_SYSWM_TYPE.class)
    public int subsystem;
    public SDL_SysWMInfoPlatformSpecific info;

    public SDL_SysWMinfo(SDL_version version) {
        this.version = version;
    }

    public SDL_SysWMinfo(Pointer p, SDL_version version) {
        super(p);
        this.version = version;
    }

    @Override
    public void read() {
        super.readField("subsystem");
        switch (subsystem) {
            case SDL_SYSWM_WINDOWS:
                info.setType(SDL_SysWMInfoWindows.class);
                break;
            case SDL_SYSWM_WINRT:
                info.setType(SDL_SysWMInfoWinRT.class);
                break;
            case SDL_SYSWM_X11:
                info.setType(SDL_SysWMInfoX11.class);
                break;
            case SDL_SYSWM_DIRECTFB:
                info.setType(SDL_SysWMInfoDirectFB.class);
                break;
            case SDL_SYSWM_COCOA:
                info.setType(SDL_SysWMInfoCocoa.class);
                break;
            case SDL_SYSWM_UIKIT:
                info.setType(SDL_SysWMInfoUIKit.class);
                break;
            case SDL_SYSWM_WAYLAND:
                info.setType(SDL_SysWMInfoWayland.class);
                break;
            case SDL_SYSWM_ANDROID:
                info.setType(SDL_SysWMInfoAndroid.class);
                break;
            case SDL_SYSWM_VIVANTE:
                info.setType(SDL_SysWMInfoVivante.class);
                break;
            case SDL_SYSWM_KMSDRM:
                info.setType(SDL_SysWMInfoKmsDrm.class);
                break;
            default:
                info.setType(SDL_SysWMInfoDummy.class);
                break;
        }
        super.read();
    }
}
