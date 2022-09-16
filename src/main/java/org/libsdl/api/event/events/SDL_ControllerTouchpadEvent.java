package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADMOTION;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERTOUCHPADUP;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "touchpad",
        "finger",
        "x",
        "y",
        "pressure"
})
public final class SDL_ControllerTouchpadEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_CONTROLLERTOUCHPADDOWN, SDL_CONTROLLERTOUCHPADMOTION, SDL_CONTROLLERTOUCHPADUP})
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    public int touchpad;
    public int finger;
    public float x;
    public float y;
    public float pressure;

    public SDL_ControllerTouchpadEvent() {
    }

    public SDL_ControllerTouchpadEvent(Pointer p) {
        super(p);
    }
}
