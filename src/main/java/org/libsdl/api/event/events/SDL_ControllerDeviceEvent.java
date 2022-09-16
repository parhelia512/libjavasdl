package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMAPPED;
import static org.libsdl.api.event.SDL_EventType.SDL_CONTROLLERDEVICEREMOVED;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which"
})
public final class SDL_ControllerDeviceEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_CONTROLLERDEVICEADDED, SDL_CONTROLLERDEVICEREMOVED, SDL_CONTROLLERDEVICEREMAPPED})
    public int type;
    public int timestamp;
    public int which;           // TODO: Shouldn't it be SDL_JoystickID?

    public SDL_ControllerDeviceEvent() {
    }

    public SDL_ControllerDeviceEvent(Pointer p) {
        super(p);
    }
}
