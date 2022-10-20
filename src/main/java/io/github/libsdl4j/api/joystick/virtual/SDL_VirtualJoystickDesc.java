package io.github.libsdl4j.api.joystick.virtual;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.gamecontroller.SDL_GameControllerAxis;
import io.github.libsdl4j.api.gamecontroller.SDL_GameControllerButton;
import io.github.libsdl4j.api.joystick.SDL_JoystickType;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.joystick.SdlJoystickConst.SDL_VIRTUAL_JOYSTICK_DESC_VERSION;

/**
 * The structure that defines an extended virtual joystick description
 *
 * <p>The caller must zero the structure and then initialize the version with {@code SDL_VIRTUAL_JOYSTICK_DESC_VERSION} before passing it to SDL_JoystickAttachVirtualEx()
 * All other elements of this structure are optional and can be left 0.</p>
 *
 * @see io.github.libsdl4j.api.joystick.SdlJoystick#SDL_JoystickAttachVirtualEx(SDL_VirtualJoystickDesc)
 */
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

    /** {@code SDL_VIRTUAL_JOYSTICK_DESC_VERSION} */
    @MagicConstant(intValues = SDL_VIRTUAL_JOYSTICK_DESC_VERSION)
    public short version;

    /** {@code SDL_JoystickType} */
    @MagicConstant(valuesFromClass = SDL_JoystickType.class)
    public short type;

    /** the number of axes on this joystick */
    public short naxes;

    /** the number of buttons on this joystick */
    public short nbuttons;

    /** the number of hats on this joystick */
    public short nhats;

    /** the USB vendor ID of this joystick */
    public short vendorId;

    /** the USB product ID of this joystick */
    public short productId;

    /** unused */
    public short padding;

    /**
     * A mask of which buttons are valid for this controller
     * <p>e.g. {@code (1 << SDL_CONTROLLER_BUTTON_A)}</p>
     */
    @MagicConstant(flagsFromClass = SDL_GameControllerButton.class)
    public int buttonMask;

    /**
     * A mask of which axes are valid for this controller
     * <p>e.g. {@code (1 << SDL_CONTROLLER_AXIS_LEFTX)}</p>
     */
    @MagicConstant(flagsFromClass = SDL_GameControllerAxis.class)
    public int axisMask;

    /** the name of the joystick */
    public String name;

    /** User data pointer passed to callbacks */
    public Pointer userdata;

    /** Called when the joystick state should be updated */
    public SDL_UpdateCallback Update;

    /** Called when the player index is set */
    public SDL_SetPlayerIndexCallback SetPlayerIndex;

    /** Implements SDL_JoystickRumble() */
    public SDL_RumbleCallback Rumble;

    /** Implements SDL_JoystickRumbleTriggers() */
    public SDL_RumbleTriggersCallback RumbleTriggers;

    /** Implements SDL_JoystickSetLED() */
    public SDL_SetLEDCallback SetLED;

    /** Implements SDL_JoystickSendEffect() */
    public SDL_SendEffectCallback SendEffect;

    public SDL_VirtualJoystickDesc() {
    }

    public SDL_VirtualJoystickDesc(Pointer p) {
        super(p);
    }
}
