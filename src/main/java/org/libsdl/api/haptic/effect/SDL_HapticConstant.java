package org.libsdl.api.haptic.effect;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.haptic.SDL_HapticEffectType;
import org.libsdl.api.haptic.SDL_HapticDirection;
import org.libsdl.api.haptic.SDL_HapticEffect;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CONSTANT;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * <p>A structure containing a template for a Constant effect.</p>
 *
 * <p>This struct is exclusively for the {@code SDL_HAPTIC_CONSTANT} effect.</p>
 *
 * <p>A constant effect applies a constant force in the specified direction
 * to the joystick.</p>
 *
 * @see SDL_HapticEffectType#SDL_HAPTIC_CONSTANT
 * @see SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "level",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticConstant extends JnaStructure {

    @MagicConstant(intValues = SDL_HAPTIC_CONSTANT)
    public short type;

    /** Direction of the effect. */
    public SDL_HapticDirection direction;

    /* Replay */
    /** Duration of the effect. */
    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
    public int length;

    /** Delay before starting the effect. */
    public short delay;

    /* Trigger */
    /** Button that triggers the effect. */
    public short button;

    /** How soon it can be triggered again after button. */
    public short interval;

    /* Constant */
    /** Strength of the constant effect. */
    public short level;

    /* Envelope */
    /** Duration of the attack. */
    public short attackLength;

    /** Level at the start of the attack. */
    public short attackLevel;

    /** Duration of the fade. */
    public short fadeLength;

    /** Level at the end of the fade. */
    public short fadeLevel;
}
