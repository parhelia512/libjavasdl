package io.github.libsdl4j.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.haptic.SDL_HapticDirection;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_DAMPER;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_FRICTION;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_INERTIA;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SPRING;
import static io.github.libsdl4j.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

/**
 * A structure containing a template for a Condition effect.
 *
 * <p>The struct handles the following effects:</p>
 * <ul>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SPRING SDL_HAPTIC_SPRING}: Effect based on axes position.</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_DAMPER SDL_HAPTIC_DAMPER}: Effect based on axes velocity.</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_INERTIA SDL_HAPTIC_INERTIA}: Effect based on axes acceleration.</li>
 *     <li>{@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_FRICTION SDL_HAPTIC_FRICTION}: Effect based on axes movement.</li>
 * </ul>
 *
 * <p>Direction is handled by condition internals instead of a direction member.
 * The condition effect specific members have three parameters.  The first
 * refers to the X axis, the second refers to the Y axis and the third
 * refers to the Z axis.  The right terms refer to the positive side of the
 * axis and the left terms refer to the negative side of the axis.  Please
 * refer to the {@link SDL_HapticDirection} diagram for which side is positive and
 * which is negative.</p>
 *
 * @see SDL_HapticDirection
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SPRING
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_DAMPER
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_INERTIA
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_FRICTION
 * @see io.github.libsdl4j.api.haptic.SDL_HapticEffect SDL_HapticEffect
 */
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "rightSat",
        "leftSat",
        "rightCoeff",
        "leftCoeff",
        "deadband",
        "center"
})
public final class SDL_HapticCondition extends Structure {

    /**
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_SPRING SDL_HAPTIC_SPRING},
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_DAMPER SDL_HAPTIC_DAMPER},
     * {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_INERTIA SDL_HAPTIC_INERTIA}
     * or {@link io.github.libsdl4j.api.haptic.SDL_HapticEffectType#SDL_HAPTIC_FRICTION SDL_HAPTIC_FRICTION}
     */
    @MagicConstant(intValues = {
            SDL_HAPTIC_SPRING,
            SDL_HAPTIC_DAMPER,
            SDL_HAPTIC_INERTIA,
            SDL_HAPTIC_FRICTION})
    public short type;

    /** Direction of the effect - Not used ATM. */
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

    /** Level when joystick is to the positive side; max 0xFFFF. */
    public short[] rightSat = new short[3];

    /** Level when joystick is to the negative side; max 0xFFFF. */
    public short[] leftSat = new short[3];

    /** How fast to increase the force towards the positive side. */
    public short[] rightCoeff = new short[3];

    /** How fast to increase the force towards the negative side. */
    public short[] leftCoeff = new short[3];

    /** Size of the dead zone; max 0xFFFF: whole axis-range when 0-centered. */
    public short[] deadband = new short[3];

    /** Position of the dead zone. */
    public short[] center = new short[3];

    public SDL_HapticCondition() {
    }

    public SDL_HapticCondition(Pointer p) {
        super(p);
    }
}
