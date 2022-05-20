package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.version.SDL_version;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_WINDOWS;
import static org.libsdl.api.syswm.SDL_SYSWM_TYPE.SDL_SYSWM_X11;

/**
 *  The custom window manager information structure.
 *
 *  When this structure is returned, it holds information about which
 *  low level system it is using, and will be one of SDL_SYSWM_TYPE.
 */
@Structure.FieldOrder({
        "version",
        "subsystem",
        "msg"
})
public class SDL_SysWMmsg extends JnaStructure {

    public SDL_version version;
    @MagicConstant(valuesFromClass = SDL_SYSWM_TYPE.class)
    public int subsystem;
    public SDL_SysWMmsgPlatformSpecific msg;

    public SDL_SysWMmsg() {
    }

    public SDL_SysWMmsg(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        super.readField("subsystem");
        switch (subsystem) {
            case SDL_SYSWM_WINDOWS:
                msg.setType(SDL_SysWMmsgWindows.class);
                break;
            case SDL_SYSWM_X11:
                msg.setType(SDL_SysWMmsgX11.class);
                break;
            default:
                msg.setType(SDL_SysWMmsgDummy.class);
                break;
        }
        super.read();
    }
}
