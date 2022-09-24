package org.libsdl.api.joystick.virtual;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.gamecontroller.SDL_GameControllerAxis;
import org.libsdl.api.gamecontroller.SDL_GameControllerButton;
import org.libsdl.api.joystick.SDL_JoystickType;

import static org.libsdl.api.joystick.SdlJoystickConst.SDL_VIRTUAL_JOYSTICK_DESC_VERSION;

@Structure.FieldOrder({
        "version",
        "type",
        "naxes",
        "nbuttons",
        "nhats",
        "vendorId",
        "productId",
        "padding",
        "buttonMask",
        "axisMask",
        "name",
        "userdata",
        "Update",
        "SetPlayerIndex",
        "Rumble",
        "RumbleTriggers",
        "SetLED",
        "SendEffect"
})
public final class SDL_VirtualJoystickDesc extends Structure {

    @MagicConstant(intValues = SDL_VIRTUAL_JOYSTICK_DESC_VERSION)
    public short version;
    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public short type;
    public short naxes;
    public short nbuttons;
    public short nhats;
    public short vendorId;
    public short productId;
    public short padding;
    @MagicConstant(flagsFromClass = SDL_GameControllerButton.class)
    public int buttonMask;
    @MagicConstant(flagsFromClass = SDL_GameControllerAxis.class)
    public int axisMask;
    public String name;
    public Pointer userdata;

    public SDL_UpdateCallback Update;
    public SDL_SetPlayerIndexCallback SetPlayerIndex;
    public SDL_RumbleCallback Rumble;
    public SDL_RumbleTriggersCallback RumbleTriggers;
    public SDL_SetLEDCallback SetLED;
    public SDL_SendEffectCallback SendEffect;

    public SDL_VirtualJoystickDesc() {
    }

    public SDL_VirtualJoystickDesc(Pointer p) {
        super(p);
    }
}
