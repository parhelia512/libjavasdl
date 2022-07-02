package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYAXISMOTION;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "axis",
        "padding1",
        "padding2",
        "padding3",
        "value",
        "padding4"
})
public final class SDL_JoyAxisEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_JOYAXISMOTION)
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    public byte axis;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public short value;
    public short padding4;
}
