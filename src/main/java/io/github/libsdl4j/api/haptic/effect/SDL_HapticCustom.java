package io.github.libsdl4j.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.haptic.SDL_HapticDirection;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CUSTOM;
import static io.github.libsdl4j.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * A structure containing a template for the
 * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_CUSTOM SDL_HAPTIC_CUSTOM} effect.
 *
 * <p>This struct is exclusively for the
 * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_CUSTOM SDL_HAPTIC_CUSTOM} effect.</p>
 *
 * <p>A custom force feedback effect is much like a periodic effect, where the
 * application can define its exact shape.  You will have to allocate the
 * data yourself.  Data should consist of channels * samples Uint16 samples.</p>
 *
 * <p>If channels is one, the effect is rotated using the defined direction.
 * Otherwise it uses the samples in data for the different axes.</p>
 *
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_CUSTOM
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "channels",
        "period",
        "samples",
        "data",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticCustom extends Structure {

    /** {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_CUSTOM SDL_HAPTIC_CUSTOM} */
    @MagicConstant(intValues = SDL_HAPTIC_CUSTOM)
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

    /** Axes to use, minimum of one. */
    public byte channels;

    /** Sample periods. */
    public short period;

    /** Amount of samples. */
    public short samples;

    /** Should contain channels*samples items. */
    public Pointer data;

    /** Duration of the attack. */
    public short attackLength;

    /** Level at the start of the attack. */
    public short attackLevel;

    /** Duration of the fade. */
    public short fadeLength;

    /** Level at the end of the fade. */
    public short fadeLevel;

    public SDL_HapticCustom() {
    }

    public SDL_HapticCustom(Pointer p) {
        super(p);
    }
}
