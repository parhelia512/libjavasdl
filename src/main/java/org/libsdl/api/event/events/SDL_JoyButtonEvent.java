package org.libsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "button",
        "state",
        "padding1",
        "padding2"
})
public final class SDL_JoyButtonEvent extends Structure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte button;
    public byte state;
    public byte padding1;
    public byte padding2;
}
