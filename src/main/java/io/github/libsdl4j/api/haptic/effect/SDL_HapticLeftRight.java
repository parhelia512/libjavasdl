package io.github.libsdl4j.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_LEFTRIGHT;
import static io.github.libsdl4j.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * A structure containing a template for a Left/Right effect.
 *
 * <p>This struct is exclusively for the
 * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT SDL_HAPTIC_LEFTRIGHT} effect.</p>
 *
 * <p>The Left/Right effect is used to explicitly control the large and small
 * motors, commonly found in modern game controllers. The small (right) motor
 * is high frequency, and the large (left) motor is low frequency.</p>
 *
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "length",
        "largeMagnitude",
        "smallMagnitude"
})
public final class SDL_HapticLeftRight extends Structure {

    /** {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_LEFTRIGHT SDL_HAPTIC_LEFTRIGHT} */
    @MagicConstant(intValues = SDL_HAPTIC_LEFTRIGHT)
    public short type;

    /** Duration of the effect in milliseconds. */
    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
    public int length;

    /** Control of the large controller motor. */
    public short largeMagnitude;

    /** Control of the small controller motor. */
    public short smallMagnitude;

    public SDL_HapticLeftRight() {
    }

    public SDL_HapticLeftRight(Pointer p) {
        super(p);
    }
}
