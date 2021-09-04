package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1",
        "data2"
})
public final class SDL_WindowEvent extends Structure {

    public int type;
    public int timestamp;
    public int windowID;
    public byte event;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public int data1;
    public int data2;
}
