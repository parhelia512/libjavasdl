package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "gestureId",
        "numFingers",
        "error",
        "x",
        "y"
})
public final class SDL_DollarGestureEvent extends Structure {

    public int type;
    public int timestamp;
    public NativeLong touchId;
    public NativeLong gestureId;
    public int numFingers;
    public float error;
    public float x;
    public float y;
}
