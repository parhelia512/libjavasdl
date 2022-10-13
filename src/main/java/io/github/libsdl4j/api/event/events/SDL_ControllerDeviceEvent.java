package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_CONTROLLERDEVICEADDED;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMAPPED;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMOVED;

/**
 * Controller device event structure (event.cdevice.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which"
})
public final class SDL_ControllerDeviceEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_CONTROLLERDEVICEADDED SDL_CONTROLLERDEVICEADDED},
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_CONTROLLERDEVICEREMOVED SDL_CONTROLLERDEVICEREMOVED}, or
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_CONTROLLERDEVICEREMAPPED SDL_CONTROLLERDEVICEREMAPPED}
     */
    @MagicConstant(intValues = {SDL_CONTROLLERDEVICEADDED, SDL_CONTROLLERDEVICEREMOVED, SDL_CONTROLLERDEVICEREMAPPED})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    // TODO: Shouldn't it be SDL_JoystickID?
    /** The joystick device index for the ADDED event, instance id for the REMOVED or REMAPPED event */
    public int which;

    public SDL_ControllerDeviceEvent() {
    }

    public SDL_ControllerDeviceEvent(Pointer p) {
        super(p);
    }
}
