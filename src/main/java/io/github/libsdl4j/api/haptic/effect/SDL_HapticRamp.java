package io.github.libsdl4j.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.haptic.SDL_HapticDirection;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_RAMP;
import static io.github.libsdl4j.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * A structure containing a template for a Ramp effect.
 *
 * <p>This struct is exclusively for the {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_RAMP SDL_HAPTIC_RAMP} effect.</p>
 *
 * <p>The ramp effect starts at start strength and ends at end strength.
 * It augments in linear fashion.  If you use attack and fade with a ramp
 * the effects get added to the ramp effect making the effect become
 * quadratic instead of linear.</p>
 *
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_RAMP
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "start",
        "end",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticRamp extends Structure {

    /** {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_RAMP} */
    @MagicConstant(intValues = SDL_HAPTIC_RAMP)
    public short type;

    /** Direction of the effect. */
    public SDL_HapticDirection direction;

    /** Duration of the effect. */
    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
    public int length;

    /** Delay before starting the effect. */
    public short delay;

    /** Button that triggers the effect. */
    public short button;

    /** How soon it can be triggered again after button. */
    public short interval;

    /** Beginning strength level. */
    public short start;

    /** Ending strength level. */
    public short end;

    /** Duration of the attack. */
    public short attackLength;

    /** Level at the start of the attack. */
    public short attackLevel;

    /** Duration of the fade. */
    public short fadeLength;

    /** Level at the end of the fade. */
    public short fadeLevel;

    public SDL_HapticRamp() {
    }

    public SDL_HapticRamp(Pointer p) {
        super(p);
    }
}
