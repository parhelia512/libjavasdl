package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.gamecontroller.SDL_GameControllerButton;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERBUTTONUP;
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
public final class SDL_ControllerButtonEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_CONTROLLERBUTTONDOWN, SDL_CONTROLLERBUTTONUP})
    public int type;
    public int timestamp;
    public SDL_JoystickID which;

    @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
    public byte button;

    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;
    public byte padding1;
    public byte padding2;
}
