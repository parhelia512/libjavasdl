package io.github.libsdl4j.api.haptic;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

public final class SDL_HapticEffectType implements JnaEnum {

    /**
     * Constant effect supported.
     *
     * <p>Constant haptic effect.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition
     */
    @SuppressWarnings("PointlessBitwiseExpression")
    public static final int SDL_HAPTIC_CONSTANT = 1 << 0;

    /**
     * Sine wave effect supported.
     *
     * <p>Periodic haptic effect that simulates sine waves.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticPeriodic
     */
    public static final int SDL_HAPTIC_SINE = 1 << 1;

    /**
     * Left/Right effect supported.
     *
     * <p>Haptic effect for direct control over high/low frequency motors.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticLeftRight
     *
     * <strong>Warning: This value was SDL_HAPTIC_SQUARE right before 2.0.0 shipped. Sorry,
     * we ran out of bits, and this is important for XInput devices.</strong>
     */
    public static final int SDL_HAPTIC_LEFTRIGHT = 1 << 2;

    /**
     * Triangle wave effect supported.
     *
     * <p>Periodic haptic effect that simulates triangular waves.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticPeriodic
     */
    public static final int SDL_HAPTIC_TRIANGLE = 1 << 3;

    /**
     * Sawtoothup wave effect supported.
     *
     * <p>Periodic haptic effect that simulates saw tooth up waves.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticPeriodic
     */
    public static final int SDL_HAPTIC_SAWTOOTHUP = 1 << 4;

    /**
     * Sawtoothdown wave effect supported.
     *
     * <p>Periodic haptic effect that simulates saw tooth down waves.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticPeriodic
     */
    public static final int SDL_HAPTIC_SAWTOOTHDOWN = 1 << 5;

    /**
     * Ramp effect supported.
     *
     * <p>Ramp haptic effect.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticRamp
     */
    public static final int SDL_HAPTIC_RAMP = 1 << 6;

    /**
     * Spring effect supported - uses axes position.
     *
     * <p>Condition haptic effect that simulates a spring.  Effect is based on the
     * axes position.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition
     */
    public static final int SDL_HAPTIC_SPRING = 1 << 7;

    /**
     * Damper effect supported - uses axes velocity.
     *
     * <p>Condition haptic effect that simulates dampening.  Effect is based on the
     * axes velocity.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition
     */
    public static final int SDL_HAPTIC_DAMPER = 1 << 8;

    /**
     * Inertia effect supported - uses axes acceleration.
     *
     * <p>Condition haptic effect that simulates inertia.  Effect is based on the axes
     * acceleration.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition
     */
    public static final int SDL_HAPTIC_INERTIA = 1 << 9;

    /**
     * Friction effect supported - uses axes movement.
     *
     * <p>Condition haptic effect that simulates friction.  Effect is based on the
     * axes movement.</p>
     *
     * @see io.github.libsdl4j.api.haptic.effect.SDL_HapticCondition
     */
    public static final int SDL_HAPTIC_FRICTION = 1 << 10;

    /**
     * Custom effect is supported.
     *
     * <p>User defined custom haptic effect.</p>
     */
    public static final int SDL_HAPTIC_CUSTOM = 1 << 11;

    /**
     * Device can set global gain.
     *
     * <p>Device supports setting the global gain.</p>
     *
     * @see SdlHaptic#SDL_HapticSetGain(SDL_Haptic, int)
     */
    public static final int SDL_HAPTIC_GAIN = 1 << 12;

    /**
     * Device can set autocenter.
     *
     * <p>Device supports setting autocenter.</p>
     *
     * @see SdlHaptic#SDL_HapticSetAutocenter(SDL_Haptic, int)
     */
    public static final int SDL_HAPTIC_AUTOCENTER = 1 << 13;

    /**
     * Device can be queried for effect status.
     *
     * <p>Device supports querying effect status.</p>
     *
     * @see SdlHaptic#SDL_HapticGetEffectStatus(SDL_Haptic, int)
     */
    public static final int SDL_HAPTIC_STATUS = 1 << 14;

    /**
     * Device can be paused.
     *
     * <p>Devices supports being paused.</p>
     *
     * @see SdlHaptic#SDL_HapticPause(SDL_Haptic)
     * @see SdlHaptic#SDL_HapticUnpause(SDL_Haptic)
     */
    public static final int SDL_HAPTIC_PAUSE = 1 << 15;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(23);
        if ((type & SDL_HAPTIC_CONSTANT) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_CONSTANT");
        }
        if ((type & SDL_HAPTIC_SINE) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_SINE");
        }
        if ((type & SDL_HAPTIC_LEFTRIGHT) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_LEFTRIGHT");
        }
        if ((type & SDL_HAPTIC_TRIANGLE) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_TRIANGLE");
        }
        if ((type & SDL_HAPTIC_SAWTOOTHUP) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_SAWTOOTHUP");
        }
        if ((type & SDL_HAPTIC_SAWTOOTHDOWN) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_SAWTOOTHDOWN");
        }
        if ((type & SDL_HAPTIC_RAMP) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_RAMP");
        }
        if ((type & SDL_HAPTIC_SPRING) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_SPRING");
        }
        if ((type & SDL_HAPTIC_DAMPER) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_DAMPER");
        }
        if ((type & SDL_HAPTIC_INERTIA) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_INERTIA");
        }
        if ((type & SDL_HAPTIC_FRICTION) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_FRICTION");
        }
        if ((type & SDL_HAPTIC_CUSTOM) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_CUSTOM");
        }
        if ((type & SDL_HAPTIC_GAIN) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_GAIN");
        }
        if ((type & SDL_HAPTIC_AUTOCENTER) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_AUTOCENTER");
        }
        if ((type & SDL_HAPTIC_STATUS) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_STATUS");
        }
        if ((type & SDL_HAPTIC_PAUSE) > 0) {
            JnaUtils.append(result, "SDL_HAPTIC_PAUSE");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_HapticEffectType() {
    }
}
