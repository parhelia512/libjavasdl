package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYBALLMOTION;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "ball",
        "padding1",
        "padding2",
        "padding3",
        "xrel",
        "yrel"
})
public final class SDL_JoyBallEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_JOYBALLMOTION)
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    public byte ball;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public short xrel;
    public short yrel;

    public SDL_JoyBallEvent() {
    }

    public SDL_JoyBallEvent(Pointer p) {
        super(p);
    }
}
