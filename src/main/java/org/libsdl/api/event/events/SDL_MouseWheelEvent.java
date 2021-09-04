package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "x",
        "y",
        "direction"
})
public final class SDL_MouseWheelEvent extends Structure {

    public int type;
    public int timestamp;
    public int windowID;
    public int which;
    public int x;
    public int y;
    public int direction;
}
