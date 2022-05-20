package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.libsdl.api.syswm.SDL_SysWMmsg;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "msg"
})
public final class SDL_SysWMEvent extends Structure {

    public int type;
    public int timestamp;
    public SDL_SysWMmsg msg;
}
