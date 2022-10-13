package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_JoystickID;

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

/**
 * Joystick hat position change event structure (event.jhat.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "hat",
        "value",
        "padding1",
        "padding2"
})
public final class SDL_JoyHatEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_JOYHATMOTION SDL_JOYHATMOTION} */
    @MagicConstant(intValues = SDL_JOYHATMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The joystick instance id */
    public SDL_JoystickID which;

    /** The joystick hat index */
    public byte hat;

    /**
     * The hat position value.
     *
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFTUP
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_UP
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTUP
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFT
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_CENTERED
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHT
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_LEFTDOWN
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_DOWN
     * @see org.libsdl.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTDOWN
     *
     * <p>Note that zero means the POV is centered.</p>
     */
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

    public SDL_JoyHatEvent() {
    }

    public SDL_JoyHatEvent(Pointer p) {
        super(p);
    }
}
