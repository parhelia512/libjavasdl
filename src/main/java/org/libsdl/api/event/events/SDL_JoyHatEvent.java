package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_JOYHATMOTION;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_CENTERED;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_DOWN;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFT;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFTDOWN;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_LEFTUP;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHT;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTDOWN;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTUP;
import static org.libsdl.api.joystick.SdlJoystickConst.SDL_HAT_UP;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "hat",
        "value",
        "padding1",
        "padding2"
})
public final class SDL_JoyHatEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_JOYHATMOTION)
    public int type;
    public int timestamp;
    public SDL_JoystickID which;
    public byte hat;

    @MagicConstant(intValues = {
            SDL_HAT_CENTERED,
            SDL_HAT_UP,
            SDL_HAT_RIGHT,
            SDL_HAT_DOWN,
            SDL_HAT_LEFT,
            SDL_HAT_RIGHTUP,
            SDL_HAT_RIGHTDOWN,
            SDL_HAT_LEFTUP,
            SDL_HAT_LEFTDOWN})
    public byte value;
    public byte padding1;
    public byte padding2;
}
