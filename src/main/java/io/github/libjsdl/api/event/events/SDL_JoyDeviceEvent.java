package io.github.libjsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which"
})
public final class SDL_JoyDeviceEvent extends Structure {

    public int type;
    public int timestamp;
    public int which;
}
