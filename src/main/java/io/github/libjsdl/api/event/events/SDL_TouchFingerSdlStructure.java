package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "fingerId",
        "x",
        "y",
        "dx",
        "dy",
        "pressure"
})
public final class SDL_TouchFingerSdlStructure extends Structure {

    public int type;
    public int timestamp;
    public NativeLong touchId;
    public NativeLong fingerId;
    public float x;
    public float y;
    public float dx;
    public float dy;
    public float pressure;
}
