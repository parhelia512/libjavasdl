package io.github.libjsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "iscapture",
        "padding1",
        "padding2",
        "padding3"
})
public final class SDL_AudioDeviceEvent extends Structure {

    public int type;
    public int timestamp;
    public int which;
    public byte iscapture;
    public byte padding1;
    public byte padding2;
    public byte padding3;
}
