package io.github.libsdl4j.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.haptic.SDL_HapticDirection;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHDOWN;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHUP;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SINE;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_TRIANGLE;
import static io.github.libsdl4j.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * A structure containing a template for a Periodic effect.
 *
 * <p>The struct handles the following effects:</p>
 *
 * <ul>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SINE SDL_HAPTIC_SINE}</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT SDL_HAPTIC_LEFTRIGHT}</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_TRIANGLE SDL_HAPTIC_TRIANGLE}</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHUP SDL_HAPTIC_SAWTOOTHUP}</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHDOWN SDL_HAPTIC_SAWTOOTHDOWN}</li>
 * </ul>
 *
 * <p>A periodic effect consists in a wave-shaped effect that repeats itself
 * over time.  The type determines the shape of the wave and the parameters
 * determine the dimensions of the wave.</p>
 *
 * <p>Phase is given by hundredth of a degree meaning that giving the phase a value
 * of 9000 will displace it 25% of its period.</p>
 *
 * <p>Here are sample values:</p>
 * <pre>
 *     0: No phase displacement.
 *  9000: Displaced 25% of its period.
 * 18000: Displaced 50% of its period.
 * 27000: Displaced 75% of its period.
 * 36000: Displaced 100% of its period, same as 0, but 0 is preferred.
 * </pre>
 *
 * <h2>Examples:</h2>
 * <pre>
 * SDL_HAPTIC_SINE
 *   __      __      __      __
 *  /  \    /  \    /  \    /
 * /    \__/    \__/    \__/
 *
 * SDL_HAPTIC_SQUARE
 *  __    __    __    __    __
 * |  |  |  |  |  |  |  |  |  |
 * |  |__|  |__|  |__|  |__|  |
 *
 * SDL_HAPTIC_TRIANGLE
 *   /\    /\    /\    /\    /\
 *  /  \  /  \  /  \  /  \  /
 * /    \/    \/    \/    \/
 *
 * SDL_HAPTIC_SAWTOOTHUP
 *   /|  /|  /|  /|  /|  /|  /|
 *  / | / | / | / | / | / | / |
 * /  |/  |/  |/  |/  |/  |/  |
 *
 * SDL_HAPTIC_SAWTOOTHDOWN
 * \  |\  |\  |\  |\  |\  |\  |
 *  \ | \ | \ | \ | \ | \ | \ |
 *   \|  \|  \|  \|  \|  \|  \|
 * </pre>
 *
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SINE
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_TRIANGLE
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHUP
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHDOWN
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "period",
        "magnitude",
        "offset",
        "phase",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticPeriodic extends Structure {

    /**
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SINE SDL_HAPTIC_SINE},
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT SDL_HAPTIC_LEFTRIGHT},
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_TRIANGLE SDL_HAPTIC_TRIANGLE},
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHUP SDL_HAPTIC_SAWTOOTHUP}
     * or {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SAWTOOTHDOWN SDL_HAPTIC_SAWTOOTHDOWN}
     */
    @MagicConstant(intValues = {
            SDL_HAPTIC_SINE,
            SDL_HAPTIC_TRIANGLE,
            SDL_HAPTIC_SAWTOOTHUP,
            SDL_HAPTIC_SAWTOOTHDOWN
    })
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

    /** Period of the wave. */
    public short period;

    /** Peak value; if negative, equivalent to 180 degrees extra phase shift. */
    public short magnitude;

    /** Mean value of the wave. */
    public short offset;

    /** Positive phase shift given by hundredth of a degree. */
    public short phase;

    /** Duration of the attack. */
    public short attackLength;

    /** Level at the start of the attack. */
    public short attackLevel;

    /** Duration of the fade. */
    public short fadeLength;

    /** Level at the end of the fade. */
    public short fadeLevel;

    public SDL_HapticPeriodic() {
    }

    public SDL_HapticPeriodic(Pointer p) {
        super(p);
    }
}
