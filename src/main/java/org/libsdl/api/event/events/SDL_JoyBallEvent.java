package org.libsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "ball",
        "padding1",
        "padding2",
        "padding3",
        "xrel",
        "yrel"
})
public final class SDL_JoyBallEvent extends Structure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte ball;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public short xrel;
    public short yrel;
}
