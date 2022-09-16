package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.touch.SDL_FingerID;
import org.libsdl.api.touch.SDL_TouchID;

import static org.libsdl.api.event.SDL_EventType.SDL_FINGERDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_FINGERMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_FINGERUP;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "fingerId",
        "x",
        "y",
        "dx",
        "dy",
        "pressure",
        "windowID"
})
public final class SDL_TouchFingerEvent extends Structure {

    @MagicConstant(intValues = {SDL_FINGERDOWN, SDL_FINGERUP, SDL_FINGERMOTION})
    public int type;
    public int timestamp;
    public SDL_TouchID touchId;
    public SDL_FingerID fingerId;
    public float x;
    public float y;
    public float dx;
    public float dy;
    public float pressure;
    public int windowID;

    public SDL_TouchFingerEvent() {
    }

    public SDL_TouchFingerEvent(Pointer p) {
        super(p);
    }
}
