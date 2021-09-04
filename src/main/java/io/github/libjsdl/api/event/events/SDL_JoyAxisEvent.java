package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "axis",
        "padding1",
        "padding2",
        "padding3",
        "value",
        "padding4"
})
public final class SDL_JoyAxisEvent extends Structure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte axis;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public short value;
    public short padding4;
}
