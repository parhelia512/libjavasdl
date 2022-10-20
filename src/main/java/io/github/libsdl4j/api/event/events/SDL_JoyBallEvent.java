package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_JOYBALLMOTION;

/**
 * Joystick trackball motion event structure (event.jball.*)
 */
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
public final class SDL_JoyBallEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_JOYBALLMOTION SDL_JOYBALLMOTION} */
    @MagicConstant(intValues = SDL_JOYBALLMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick trackball index */
    public byte ball;

    public byte padding1;
    public byte padding2;
    public byte padding3;

    /** The relative motion in the X direction */
    public short xrel;

    /** The relative motion in the Y direction */
    public short yrel;

    public SDL_JoyBallEvent() {
    }

    public SDL_JoyBallEvent(Pointer p) {
        super(p);
    }
}
