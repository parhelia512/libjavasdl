package io.github.libjsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "state",
        "x",
        "y",
        "xrel",
        "yrel"
})
public final class SDL_MouseMotionEvent extends Structure {

    public int type;
    public int timestamp;
    public int windowID;
    public int which;
    public int state;
    public int x;
    public int y;
    public int xrel;
    public int yrel;
}
