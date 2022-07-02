package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.gesture.SDL_GestureID;
import org.libsdl.api.touch.SDL_TouchID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_DOLLARGESTURE;
import static org.libsdl.api.event.SDL_EventType.SDL_DOLLARRECORD;

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
public final class SDL_DollarGestureEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_DOLLARGESTURE, SDL_DOLLARRECORD})
    public int type;
    public int timestamp;
    public SDL_TouchID touchId;
    public SDL_GestureID gestureId;
    public int numFingers;
    public float error;
    public float x;
    public float y;
}
