package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.gamecontroller.SDL_GameControllerButton;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_CONTROLLERBUTTONDOWN;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_CONTROLLERBUTTONUP;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_PRESSED;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_RELEASED;

/**
 * Game controller button event structure (event.cbutton.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "button",
        "state",
        "padding1",
        "padding2"
})
public final class SDL_ControllerButtonEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_CONTROLLERBUTTONDOWN SDL_CONTROLLERBUTTONDOWN}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_CONTROLLERBUTTONUP SDL_CONTROLLERBUTTONUP}
     */
    @MagicConstant(intValues = {SDL_CONTROLLERBUTTONDOWN, SDL_CONTROLLERBUTTONUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The controller button (SDL_GameControllerButton) */
    @MagicConstant(valuesFromClass = SDL_GameControllerButton.class)
    public byte button;

    /**
     * {@link io.github.libsdl4j.api.event.SdlEventsConst#SDL_PRESSED SDL_PRESSED}
     * or {@link io.github.libsdl4j.api.event.SdlEventsConst#SDL_RELEASED SDL_RELEASED}
     */
    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;

    public byte padding1;
    public byte padding2;

    public SDL_ControllerButtonEvent() {
    }

    public SDL_ControllerButtonEvent(Pointer p) {
        super(p);
    }
}
