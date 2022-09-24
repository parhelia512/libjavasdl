package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.api.joystick.SDL_JoystickPowerLevel;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYBATTERYUPDATED;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "level"
})
public final class SDL_JoyBatteryEvent extends Structure {

    @MagicConstant(intValues = SDL_JOYBATTERYUPDATED)
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public int level;

    public SDL_JoyBatteryEvent() {
    }

    public SDL_JoyBatteryEvent(Pointer p) {
        super(p);
    }
}
