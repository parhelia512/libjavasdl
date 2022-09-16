package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.api.syswm.event.SDL_SysWMmsg;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "msg"
})
public final class SDL_SysWMEvent extends JnaStructure {

    public int type;
    public int timestamp;
    public SDL_SysWMmsg msg;

    public SDL_SysWMEvent() {
    }

    public SDL_SysWMEvent(Pointer p) {
        super(p);
    }
}
