package io.github.libsdl4j.api.haptic;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticConstant;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticCustom;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticLeftRight;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticPeriodic;
import io.github.libsdl4j.api.haptic.effect.SDL_HapticRamp;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CONSTANT;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CUSTOM;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_DAMPER;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_FRICTION;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_INERTIA;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_LEFTRIGHT;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_RAMP;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHDOWN;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHUP;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SINE;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SPRING;
import static io.github.libsdl4j.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_TRIANGLE;

/**
 * The generic template for any haptic effect.
 *
 * <p>All values max at 32767 (0x7FFF).  Signed values also can be negative.
 * Time values unless specified otherwise are in milliseconds.</p>
 *
 * <p>You can also pass {@link SdlHapticConst#SDL_HAPTIC_INFINITY SDL_HAPTIC_INFINITY} to length instead of a 0-32767
 * value.  Neither delay, interval, attackLength nor fadeLength support
 * {@link SdlHapticConst#SDL_HAPTIC_INFINITY SDL_HAPTIC_INFINITY}.  Fade will also not be used since effect never ends.</p>
 *
 * <p>Additionally, the {@link SDL_HapticEffectType#SDL_HAPTIC_RAMP SDL_HAPTIC_RAMP} effect does not support a duration of
 * {@link SdlHapticConst#SDL_HAPTIC_INFINITY SDL_HAPTIC_INFINITY}.</p>
 *
 * <p>Button triggers may not be supported on all devices, it is advised to not
 * use them if possible.  Buttons start at index 1 instead of index 0 like
 * the joystick.</p>
 *
 * <p>If both attackLength and fadeLevel are 0, the envelope is not used,
 * otherwise both values are used.</p>
 *
 * <h2>Common parts:</h2>
 *
 * <pre>
 * // Replay - All effects have this
 * int length;           // Duration of effect (ms).
 * short delay;          // Delay before starting effect.
 *
 * // Trigger - All effects have this
 * short button;         // Button that triggers effect.
 * short interval;       // How soon before effect can be triggered again.
 *
 * // Envelope - All effects except condition effects have this
 * short attackLength;   // Duration of the attack (ms).
 * short attackLevel;    // Level at the start of the attack.
 * short fadeLength;     // Duration of the fade out (ms).
 * short fadeLevel;      // Level at the end of the fade.
 * </pre>
 *
 * Here we have an example of a constant effect evolution in time:
 * <pre>
 * Strength
 * ^
 * |
 * |    effect level --&gt;  _________________
 * |                     /                 \
 * |                    /                   \
 * |                   /                     \
 * |                  /                       \
 * |  attackLevel --&gt; |                        \
 * |                  |                        |  &lt;---  fadeLevel
 * |
 * +--------------------------------------------------&gt; Time
 *                    [--]                 [---]
 *                    attackLength         fadeLength
 *
 * [------------------][-----------------------]
 * delay               length
 * </pre>
 *
 * <p>Note either the attackLevel or the fadeLevel may be above the actual
 * effect level.</p>
 *
 * @see SDL_HapticConstant
 * @see SDL_HapticPeriodic
 * @see SDL_HapticCondition
 * @see SDL_HapticRamp
 * @see SDL_HapticLeftRight
 * @see SDL_HapticCustom
 */
public final class SDL_HapticEffect extends Union {

    /** Effect type. */
    @MagicConstant(valuesFromClass = SDL_HapticEffectType.class)
    public short type;

    /** Constant effect. */
    public SDL_HapticConstant constant;

    /** Periodic effect. */
    public SDL_HapticPeriodic periodic;

    /** Condition effect. */
    public SDL_HapticCondition condition;

    /** Ramp effect. */
    public SDL_HapticRamp ramp;

    /** Left/Right effect. */
    public SDL_HapticLeftRight leftright;

    /** Custom effect. */
    public SDL_HapticCustom custom;

    public SDL_HapticEffect() {
    }

    public SDL_HapticEffect(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("type");
        setType(type);
        super.read();
    }

    public void setType(
            @MagicConstant(valuesFromClass = SDL_HapticEffectType.class) int hapticEffectType) {
        switch (hapticEffectType & 0xFFFF) {
            case SDL_HAPTIC_CONSTANT:
                setType(SDL_HapticConstant.class);
                break;
            case SDL_HAPTIC_SINE:
            case SDL_HAPTIC_TRIANGLE:
            case SDL_HAPTIC_SAWTOOTHUP:
            case SDL_HAPTIC_SAWTOOTHDOWN:
                setType(SDL_HapticPeriodic.class);
                break;
            case SDL_HAPTIC_SPRING:
            case SDL_HAPTIC_DAMPER:
            case SDL_HAPTIC_INERTIA:
            case SDL_HAPTIC_FRICTION:
                setType(SDL_HapticCondition.class);
                break;
            case SDL_HAPTIC_RAMP:
                setType(SDL_HapticRamp.class);
                break;
            case SDL_HAPTIC_LEFTRIGHT:
                setType(SDL_HapticLeftRight.class);
                break;
            case SDL_HAPTIC_CUSTOM:
                setType(SDL_HapticCustom.class);
                break;
            default:
                throw new IllegalArgumentException("Invalid haptic effect type: " + SDL_HapticEffectType.toString(type));
        }
        type = (short) hapticEffectType;
    }
}
