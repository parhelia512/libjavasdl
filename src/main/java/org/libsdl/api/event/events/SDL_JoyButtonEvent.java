package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYBUTTONUP;
import static org.libsdl.api.event.SdlEventsConst.SDL_PRESSED;
import static org.libsdl.api.event.SdlEventsConst.SDL_RELEASED;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "button",
        "state",
        "padding1",
        "padding2"
})
public final class SDL_JoyButtonEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_JOYBUTTONDOWN, SDL_JOYBUTTONUP})
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    public byte button;

    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;
    public byte padding1;
    public byte padding2;

    public SDL_JoyButtonEvent() {
    }

    public SDL_JoyButtonEvent(Pointer p) {
        super(p);
    }
}
