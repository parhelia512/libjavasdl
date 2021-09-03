package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "hat",
        "value",
        "padding1",
        "padding2"
})
public final class SDL_JoyHatEvent extends Structure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte hat;
    public byte value;
    public byte padding1;
    public byte padding2;
}
