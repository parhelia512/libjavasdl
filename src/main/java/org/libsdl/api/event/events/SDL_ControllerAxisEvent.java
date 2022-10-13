package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.gamecontroller.SDL_GameControllerAxis;
import org.libsdl.api.joystick.SDL_JoystickID;

import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERAXISMOTION;

/**
 * Game controller axis motion event structure (event.caxis.*)
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
public final class SDL_ControllerAxisEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_CONTROLLERAXISMOTION SDL_CONTROLLERAXISMOTION} */
    @MagicConstant(intValues = SDL_CONTROLLERAXISMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The controller axis (SDL_GameControllerAxis) */
    @MagicConstant(valuesFromClass = SDL_GameControllerAxis.class)
    public byte axis;

    public byte padding1;
    public byte padding2;
    public byte padding3;

    /** The axis value (range: -32768 to 32767) */
    public short value;
    public short padding4;

    public SDL_ControllerAxisEvent() {
    }

    public SDL_ControllerAxisEvent(Pointer p) {
        super(p);
    }
}
