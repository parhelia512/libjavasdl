package org.libsdl.api.haptic;

import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.joystick.SDL_Joystick;
import org.libsdl.jna.NativeLoader;

/**
 * <p>Adapted from SDL_haptic.h</p>
 *
 * <p>The SDL haptic subsystem allows you to control haptic (force feedback)
 * devices.</p>
 *
 * <p>The basic usage is as follows:</p>
 * <ol>
 *     <li>Initialize the subsystem (::SDL_INIT_HAPTIC).</li>
 *     <li>Open a haptic device.</li>
 *     <ol>
 *         <li>SDL_HapticOpen() to open from index.</li>
 *         <li>SDL_HapticOpenFromJoystick() to open from an existing joystick.</li>
 *     </ol>
 *     <li>Create an effect (::SDL_HapticEffect).</li>
 *     <li>Upload the effect with SDL_HapticNewEffect().</li>
 *     <li>Run the effect with SDL_HapticRunEffect().</li>
 *     <li>(optional) Free the effect with SDL_HapticDestroyEffect().</li>
 *     <li>Close the haptic device with SDL_HapticClose().</li>
 * </ol>
 *
 * <p>Simple rumble example:</p>
 * <pre>
 * SDL_Haptic *haptic;
 *
 * // Open the device
 * haptic = SDL_HapticOpen( 0 );
 * if (haptic == NULL)
 *    return -1;
 *
 * // Initialize simple rumble
 * if (SDL_HapticRumbleInit( haptic ) != 0)
 *    return -1;
 *
 * // Play effect at 50% strength for 2 seconds
 * if (SDL_HapticRumblePlay( haptic, 0.5, 2000 ) != 0)
 *    return -1;
 * SDL_Delay( 2000 );
 *
 * // Clean up
 * SDL_HapticClose( haptic );
 * </pre>
 *
 * <p>Complete example:</p>
 * <pre>
 * int test_haptic( SDL_Joystick * joystick ) {
 *    SDL_Haptic *haptic;
 *    SDL_HapticEffect effect;
 *    int effect_id;
 *
 *    // Open the device
 *    haptic = SDL_HapticOpenFromJoystick( joystick );
 *    if (haptic == NULL) return -1; // Most likely joystick isn't haptic
 *
 *    // See if it can do sine waves
 *    if ((SDL_HapticQuery(haptic) & SDL_HAPTIC_SINE)==0) {
 *       SDL_HapticClose(haptic); // No sine effect
 *       return -1;
 *    }
 *
 *    // Create the effect
 *    memset( &effect, 0, sizeof(SDL_HapticEffect) ); // 0 is safe default
 *    effect.type = SDL_HAPTIC_SINE;
 *    effect.periodic.direction.type = SDL_HAPTIC_POLAR; // Polar coordinates
 *    effect.periodic.direction.dir[0] = 18000; // Force comes from south
 *    effect.periodic.period = 1000; // 1000 ms
 *    effect.periodic.magnitude = 20000; // 20000/32767 strength
 *    effect.periodic.length = 5000; // 5 seconds long
 *    effect.periodic.attack_length = 1000; // Takes 1 second to get max strength
 *    effect.periodic.fade_length = 1000; // Takes 1 second to fade away
 *
 *    // Upload the effect
 *    effect_id = SDL_HapticNewEffect( haptic, &effect );
 *
 *    // Test the effect
 *    SDL_HapticRunEffect( haptic, effect_id, 1 );
 *    SDL_Delay( 5000); // Wait for the effect to finish
 *
 *    // We destroy the effect, although closing the device also does this
 *    SDL_HapticDestroyEffect( haptic, effect_id );
 *
 *    // Close the device
 *    SDL_HapticClose(haptic);
 *
 *    return 0; // Success
 * }
 * </pre>
 */
public final class SdlHaptic {

    static {
        NativeLoader.registerNativeMethods(SdlHaptic.class);
    }

    private SdlHaptic() {
    }

    public static native int SDL_NumHaptics();

    public static native String SDL_HapticName(
            int deviceIndex);

    public static native SDL_Haptic SDL_HapticOpen(
            int deviceIndex);

    public static native int SDL_HapticOpened(
            int deviceIndex);

    public static native int SDL_HapticIndex(
            SDL_Haptic haptic);

    public static native boolean SDL_MouseIsHaptic();

    public static native SDL_Haptic SDL_HapticOpenFromMouse();

    public static native int SDL_JoystickIsHaptic(
            SDL_Joystick joystick);

    public static native SDL_Haptic SDL_HapticOpenFromJoystick(
            SDL_Joystick joystick);

    public static native void SDL_HapticClose(
            SDL_Haptic haptic);

    public static native int SDL_HapticNumEffects(
            SDL_Haptic haptic);

    public static native int SDL_HapticNumEffectsPlaying(
            SDL_Haptic haptic);

    @MagicConstant(flagsFromClass = SDL_HapticEffectType.class)
    public static native int SDL_HapticQuery(
            SDL_Haptic haptic);

    public static native int SDL_HapticNumAxes(
            SDL_Haptic haptic);

    public static native int SDL_HapticEffectSupported(
            SDL_Haptic haptic,
            SDL_HapticEffect effect);

    public static native int SDL_HapticNewEffect(
            SDL_Haptic haptic,
            SDL_HapticEffect effect);

    public static native int SDL_HapticUpdateEffect(
            SDL_Haptic haptic,
            int effect,
            SDL_HapticEffect data);

    public static native int SDL_HapticRunEffect(
            SDL_Haptic haptic,
            int effect,
            int iterations);

    public static native int SDL_HapticStopEffect(
            SDL_Haptic haptic,
            int effect);

    public static native void SDL_HapticDestroyEffect(
            SDL_Haptic haptic,
            int effect);

    public static native int SDL_HapticGetEffectStatus(
            SDL_Haptic haptic,
            int effect);

    public static native int SDL_HapticSetGain(
            SDL_Haptic haptic,
            int gain);

    public static native int SDL_HapticSetAutocenter(
            SDL_Haptic haptic,
            int autocenter);

    public static native int SDL_HapticPause(
            SDL_Haptic haptic);

    public static native int SDL_HapticUnpause(
            SDL_Haptic haptic);

    public static native int SDL_HapticStopAll(
            SDL_Haptic haptic);

    public static native int SDL_HapticRumbleSupported(
            SDL_Haptic haptic);

    public static native int SDL_HapticRumbleInit(
            SDL_Haptic haptic);

    public static native int SDL_HapticRumblePlay(
            SDL_Haptic haptic,
            float strength,
            int length);

    public static native int SDL_HapticRumbleStop(
            SDL_Haptic haptic);
}
