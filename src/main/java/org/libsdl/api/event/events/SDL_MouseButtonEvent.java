package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "button",
        "state",
        "clicks",
        "padding1",
        "x",
        "y"
})
public final class SDL_MouseButtonEvent extends Structure {

    public int type;
    public int timestamp;
    public int windowID;
    public int which;
    public byte button;
    public byte state;
    public byte clicks;
    public byte padding1;
    public int x;
    public int y;
}
