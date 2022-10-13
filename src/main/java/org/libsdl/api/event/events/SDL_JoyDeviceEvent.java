package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYDEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_JOYDEVICEREMOVED;

/**
 * Joystick device event structure (event.jdevice.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which"
})
public final class SDL_JoyDeviceEvent extends Structure {

    /**
     * {@link org.libsdl.api.event.SDL_EventType#SDL_JOYDEVICEADDED SDL_JOYDEVICEADDED}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_JOYDEVICEREMOVED SDL_JOYDEVICEREMOVED}
     */
    @MagicConstant(intValues = {SDL_JOYDEVICEADDED, SDL_JOYDEVICEREMOVED})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    // TODO: Shouldn't it be SDL_JoystickID?
    /** The joystick device index for the ADDED event, instance id for the REMOVED event */
    public int which;

    public SDL_JoyDeviceEvent() {
    }

    public SDL_JoyDeviceEvent(Pointer p) {
        super(p);
    }
}
