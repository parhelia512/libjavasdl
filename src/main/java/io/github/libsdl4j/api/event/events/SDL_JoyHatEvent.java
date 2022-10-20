package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_JOYHATMOTION;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_CENTERED;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_DOWN;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_LEFT;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_LEFTDOWN;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_LEFTUP;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_RIGHT;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTDOWN;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_RIGHTUP;
import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_HAT_UP;

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

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_JOYHATMOTION SDL_JOYHATMOTION} */
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
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_LEFTUP
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_UP
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTUP
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_LEFT
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_CENTERED
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_RIGHT
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_LEFTDOWN
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_DOWN
     * @see io.github.libsdl4j.api.joystick.SdlJoystickConst#SDL_HAT_RIGHTDOWN
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
