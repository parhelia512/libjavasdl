package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_JOYAXISMOTION;

/**
 * Joystick axis motion event structure (event.jaxis.*)
 */
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
public final class SDL_JoyAxisEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_JOYAXISMOTION SDL_JOYAXISMOTION} */
    @MagicConstant(intValues = SDL_JOYAXISMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick axis index */
    public byte axis;

    public byte padding1;
    public byte padding2;
    public byte padding3;

    /** The axis value (range: -32768 to 32767) */
    public short value;

    public short padding4;

    public SDL_JoyAxisEvent() {
    }

    public SDL_JoyAxisEvent(Pointer p) {
        super(p);
    }
}
