package io.github.libsdl4j.api.haptic;

import io.github.libsdl4j.api.joystick.SDL_Joystick;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_haptic.h
 *
 * <p>The SDL haptic subsystem allows you to control haptic (force feedback)
 * devices.</p>
 *
 * <p>The basic usage is as follows:</p>
 * <ol>
 *     <li>Initialize the subsystem ({@link io.github.libsdl4j.api.SdlSubSystemConst#SDL_INIT_HAPTIC SDL_INIT_HAPTIC}).</li>
 *     <li>Open a haptic device.
 *         <ol>
 *             <li>SDL_HapticOpen() to open from index.</li>
 *             <li>SDL_HapticOpenFromJoystick() to open from an existing joystick.</li>
 *         </ol>
 *     </li>
 *     <li>Create an effect ({@link SDL_HapticEffect}).</li>
 *     <li>Upload the effect with SDL_HapticNewEffect().</li>
 *     <li>Run the effect with SDL_HapticRunEffect().</li>
 *     <li>(optional) Free the effect with SDL_HapticDestroyEffect().</li>
 *     <li>Close the haptic device with SDL_HapticClose().</li>
 * </ol>
 *
 *
 * <h2>Simple rumble example:</h2>
 *
 * <pre>
 * // Open the device
 * SDL_Haptic haptic = SDL_HapticOpen(0);
 * if (haptic == null) {
 *     throw new IllegalStateException("The device isn't haptic");
 * }
 * try {
 *     // Initialize simple rumble
 *     if (SDL_HapticRumbleInit(haptic) != 0) {
 *         throw new IllegalStateException("The device doesn't support rumble effects");
 *     }
 *
 *     // Play effect at 50% strength for 2 seconds
 *     if (SDL_HapticRumblePlay(haptic, 0.5F, 2000) != 0) {
 *         throw new IllegalStateException("Unable to play rumble effect");
 *     }
 *     SDL_Delay(2000);
 * } finally {
 *     // Clean up
 *     SDL_HapticClose(haptic);
 * }
 * </pre>
 *
 *
 * <p>Complete example:</p>
 *
 * <pre>
 * public void testHaptic(SDL_Joystick joystick) {
 *     // Open the device
 *     SDL_Haptic haptic = SDL_HapticOpenFromJoystick(joystick);
 *     if (haptic == null) {
 *         throw new IllegalStateException("Most likely joystick isn't haptic");
 *     }
 *
 *     try {
 *         // See if it can do sine waves
 *         if ((SDL_HapticQuery(haptic) &amp; SDL_HAPTIC_SINE) == 0) {
 *             throw new IllegalStateException("No sine effect supported");
 *         }
 *
 *         // Create the effect
 *         SDL_HapticEffect effect = new SDL_HapticEffect();
 *         effect.type = SDL_HAPTIC_SINE;
 *         effect.periodic.direction.type = SDL_HAPTIC_POLAR; // Polar coordinates
 *         effect.periodic.direction.dir[0] = 18000; // Force comes from south
 *         effect.periodic.period = 1000; // 1000 ms
 *         effect.periodic.magnitude = 20000; // 20000/32767 strength
 *         effect.periodic.length = 5000; // 5 seconds long
 *         effect.periodic.attackLength = 1000; // Takes 1 second to get max strength
 *         effect.periodic.fadeLength = 1000; // Takes 1 second to fade away
 *
 *         // Upload the effect
 *         int effectId = SDL_HapticNewEffect(haptic, effect);
 *
 *         // Test the effect
 *         SDL_HapticRunEffect(haptic, effectId, 1);
 *         SDL_Delay(5000); // Wait for the effect to finish
 *
 *         // We destroy the effect, although closing the device also does this
 *         SDL_HapticDestroyEffect(haptic, effectId);
 *
 *     } finally {
 *         // Close the device
 *         SDL_HapticClose(haptic);
 *     }
 * }
 * </pre>
 */
public final class SdlHaptic {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlHaptic.class);
    }

    private SdlHaptic() {
    }

    /**
     * Count the number of haptic devices attached to the system.
     *
     * @return the number of haptic devices detected on the system or a negative
     * error code on failure; call SDL_GetError() for more information.
     * @see #SDL_HapticName(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_NumHaptics();

    /**
     * Get the implementation dependent name of a haptic device.
     *
     * <p>This can be called before any joysticks are opened. If no name can be
     * found, this function returns null.</p>
     *
     * @param deviceIndex index of the device to query.
     * @return the name of the device or null on failure; call SDL_GetError() for
     * more information.
     * @see #SDL_NumHaptics()
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_HapticName(
            int deviceIndex);

    /**
     * Open a haptic device for use.
     *
     * <p>The index passed as an argument refers to the N'th haptic device on this
     * system.</p>
     *
     * <p>When opening a haptic device, its gain will be set to maximum and
     * autocenter will be disabled. To modify these values use SDL_HapticSetGain()
     * and SDL_HapticSetAutocenter().</p>
     *
     * @param deviceIndex index of the device to open
     * @return the device identifier or null on failure; call SDL_GetError() for
     * more information.
     * @see #SDL_HapticClose(SDL_Haptic)
     * @see #SDL_HapticIndex(SDL_Haptic)
     * @see #SDL_HapticOpenFromJoystick(SDL_Joystick)
     * @see #SDL_HapticOpenFromMouse()
     * @see #SDL_HapticPause(SDL_Haptic)
     * @see #SDL_HapticSetAutocenter(SDL_Haptic, int)
     * @see #SDL_HapticSetGain(SDL_Haptic, int)
     * @see #SDL_HapticStopAll(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Haptic SDL_HapticOpen(
            int deviceIndex);

    /**
     * Check if the haptic device at the designated index has been opened.
     *
     * @param deviceIndex the index of the device to query
     * @return 1 if it has been opened, 0 if it hasn't or on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticIndex(SDL_Haptic)
     * @see #SDL_HapticOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticOpened(
            int deviceIndex);

    /**
     * Get the index of a haptic device.
     *
     * @param haptic the SDL_Haptic device to query
     * @return the index of the specified haptic device or a negative error code
     * on failure; call SDL_GetError() for more information.
     * @see #SDL_HapticOpen(int)
     * @see #SDL_HapticOpened(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticIndex(
            SDL_Haptic haptic);

    /**
     * Query whether or not the current mouse has haptic capabilities.
     *
     * @return true if the mouse is haptic or false if it isn't.
     * @see #SDL_HapticOpenFromMouse()
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_MouseIsHaptic();

    /**
     * Try to open a haptic device from the current mouse.
     *
     * @return the haptic device identifier or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticOpen(int)
     * @see #SDL_MouseIsHaptic()
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Haptic SDL_HapticOpenFromMouse();

    /**
     * Query if a joystick has haptic features.
     *
     * @param joystick the SDL_Joystick to test for haptic capabilities
     * @return true if the joystick is haptic, false if it isn't, or a
     * negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_HapticOpenFromJoystick(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_JoystickIsHaptic(
            SDL_Joystick joystick);

    /**
     * Open a haptic device for use from a joystick device.
     *
     * <p>You must still close the haptic device separately. It will not be closed
     * with the joystick.</p>
     *
     * <p>When opened from a joystick you should first close the haptic device before
     * closing the joystick device. If not, on some implementations the haptic
     * device will also get unallocated and you'll be unable to use force feedback
     * on that device.</p>
     *
     * @param joystick the SDL_Joystick to create a haptic device from
     * @return a valid haptic device identifier on success or null on failure;
     * call SDL_GetError() for more information.
     * @see #SDL_HapticClose(SDL_Haptic)
     * @see #SDL_HapticOpen(int)
     * @see #SDL_JoystickIsHaptic(SDL_Joystick)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Haptic SDL_HapticOpenFromJoystick(
            SDL_Joystick joystick);

    /**
     * Close a haptic device previously opened with SDL_HapticOpen().
     *
     * @param haptic the SDL_Haptic device to close
     * @see #SDL_HapticOpen(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_HapticClose(
            SDL_Haptic haptic);

    /**
     * Get the number of effects a haptic device can store.
     *
     * <p>On some platforms this isn't fully supported, and therefore is an
     * approximation. Always check to see if your created effect was actually
     * created and do not rely solely on SDL_HapticNumEffects().</p>
     *
     * @param haptic the SDL_Haptic device to query
     * @return the number of effects the haptic device can store or a negative
     * error code on failure; call SDL_GetError() for more information.
     * @see #SDL_HapticNumEffectsPlaying(SDL_Haptic)
     * @see #SDL_HapticQuery(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticNumEffects(
            SDL_Haptic haptic);

    /**
     * Get the number of effects a haptic device can play at the same time.
     *
     * <p>This is not supported on all platforms, but will always return a value.</p>
     *
     * @param haptic the SDL_Haptic device to query maximum playing effects
     * @return the number of effects the haptic device can play at the same time
     * or a negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_HapticNumEffects(SDL_Haptic)
     * @see #SDL_HapticQuery(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticNumEffectsPlaying(
            SDL_Haptic haptic);

    /**
     * Get the haptic device's supported features in bitwise manner.
     *
     * @param haptic the SDL_Haptic device to query
     * @return a list of supported haptic features in bitwise manner (OR'd), or 0
     * on failure; call SDL_GetError() for more information.
     * @see #SDL_HapticEffectSupported(SDL_Haptic, SDL_HapticEffect)
     * @see #SDL_HapticNumEffects(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(flagsFromClass = SDL_HapticEffectType.class)
    public static native int SDL_HapticQuery(
            SDL_Haptic haptic);

    /**
     * Get the number of haptic axes the device has.
     *
     * <p>The number of haptic axes might be useful if working with the
     * SDL_HapticDirection effect.</p>
     *
     * @param haptic the SDL_Haptic device to query
     * @return the number of axes on success or a negative error code on failure;
     * call SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticNumAxes(
            SDL_Haptic haptic);

    /**
     * Check to see if an effect is supported by a haptic device.
     *
     * @param haptic the SDL_Haptic device to query
     * @param effect the desired effect to query
     * @return true if effect is supported, false if it isn't, or a
     * negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_HapticNewEffect(SDL_Haptic, SDL_HapticEffect)
     * @see #SDL_HapticQuery(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticEffectSupported(
            SDL_Haptic haptic,
            SDL_HapticEffect effect);

    /**
     * Create a new haptic effect on a specified device.
     *
     * @param haptic an SDL_Haptic device to create the effect on
     * @param effect an SDL_HapticEffect structure containing the properties of
     *               the effect to create
     * @return the ID of the effect on success or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_HapticDestroyEffect(SDL_Haptic, int)
     * @see #SDL_HapticRunEffect(SDL_Haptic, int, int)
     * @see #SDL_HapticUpdateEffect(SDL_Haptic, int, SDL_HapticEffect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticNewEffect(
            SDL_Haptic haptic,
            SDL_HapticEffect effect);

    /**
     * Update the properties of an effect.
     *
     * <p>Can be used dynamically, although behavior when dynamically changing
     * direction may be strange. Specifically the effect may re-upload itself and
     * start playing from the start. You also cannot change the type either when
     * running SDL_HapticUpdateEffect().</p>
     *
     * @param haptic the SDL_Haptic device that has the effect
     * @param effect the identifier of the effect to update
     * @param data   an SDL_HapticEffect structure containing the new effect
     *               properties to use
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticDestroyEffect(SDL_Haptic, int)
     * @see #SDL_HapticNewEffect(SDL_Haptic, SDL_HapticEffect)
     * @see #SDL_HapticRunEffect(SDL_Haptic, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticUpdateEffect(
            SDL_Haptic haptic,
            int effect,
            SDL_HapticEffect data);

    /**
     * Run the haptic effect on its associated haptic device.
     *
     * <p>To repeat the effect over and over indefinitely, set {@code iterations} to
     * {@code SDL_HAPTIC_INFINITY}. (Repeats the envelope - attack and fade.) To make
     * one instance of the effect last indefinitely (so the effect does not fade),
     * set the effect's {@code length} in its structure/union to {@code SDL_HAPTIC_INFINITY}
     * instead.</p>
     *
     * @param haptic     the SDL_Haptic device to run the effect on
     * @param effect     the ID of the haptic effect to run
     * @param iterations the number of iterations to run the effect; use
     *                   {@code SDL_HAPTIC_INFINITY} to repeat forever
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticDestroyEffect(SDL_Haptic, int)
     * @see #SDL_HapticGetEffectStatus(SDL_Haptic, int)
     * @see #SDL_HapticStopEffect(SDL_Haptic, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticRunEffect(
            SDL_Haptic haptic,
            int effect,
            int iterations);

    /**
     * Stop the haptic effect on its associated haptic device.
     *
     * *
     *
     * @param haptic the SDL_Haptic device to stop the effect on
     * @param effect the ID of the haptic effect to stop
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticDestroyEffect(SDL_Haptic, int)
     * @see #SDL_HapticRunEffect(SDL_Haptic, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticStopEffect(
            SDL_Haptic haptic,
            int effect);

    /**
     * Destroy a haptic effect on the device.
     *
     * <p>This will stop the effect if it's running. Effects are automatically
     * destroyed when the device is closed.</p>
     *
     * @param haptic the SDL_Haptic device to destroy the effect on
     * @param effect the ID of the haptic effect to destroy
     * @see #SDL_HapticNewEffect(SDL_Haptic, SDL_HapticEffect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_HapticDestroyEffect(
            SDL_Haptic haptic,
            int effect);

    /**
     * Get the status of the current effect on the specified haptic device.
     *
     * <p>Device must support the SDL_HAPTIC_STATUS feature.</p>
     *
     * @param haptic the SDL_Haptic device to query for the effect status on
     * @param effect the ID of the haptic effect to query its status
     * @return 0 if it isn't playing, 1 if it is playing, or a negative error
     * code on failure; call SDL_GetError() for more information.
     * @see #SDL_HapticRunEffect(SDL_Haptic, int, int)
     * @see #SDL_HapticStopEffect(SDL_Haptic, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticGetEffectStatus(
            SDL_Haptic haptic,
            int effect);

    /**
     * Set the global gain of the specified haptic device.
     *
     * <p>Device must support the SDL_HAPTIC_GAIN feature.</p>
     *
     * <p>The user may specify the maximum gain by setting the environment variable
     * {@code SDL_HAPTIC_GAIN_MAX} which should be between 0 and 100. All calls to
     * SDL_HapticSetGain() will scale linearly using {@code SDL_HAPTIC_GAIN_MAX} as the
     * maximum.</p>
     *
     * @param haptic the SDL_Haptic device to set the gain on
     * @param gain   value to set the gain to, should be between 0 and 100 (0 - 100)
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticQuery(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticSetGain(
            SDL_Haptic haptic,
            int gain);

    /**
     * Set the global autocenter of the device.
     *
     * <p>Autocenter should be between 0 and 100. Setting it to 0 will disable
     * autocentering.</p>
     *
     * <p>Device must support the SDL_HAPTIC_AUTOCENTER feature.</p>
     *
     * @param haptic     the SDL_Haptic device to set autocentering on
     * @param autocenter value to set autocenter to (0-100)
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticQuery(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticSetAutocenter(
            SDL_Haptic haptic,
            int autocenter);

    /**
     * Pause a haptic device.
     *
     * <p>Device must support the {@code SDL_HAPTIC_PAUSE} feature. Call
     * SDL_HapticUnpause() to resume playback.</p>
     *
     * <p>Do not modify the effects nor add new ones while the device is paused. That
     * can cause all sorts of weird errors.</p>
     *
     * @param haptic the SDL_Haptic device to pause
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticUnpause(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticPause(
            SDL_Haptic haptic);

    /**
     * Unpause a haptic device.
     *
     * <p>Call to unpause after SDL_HapticPause().</p>
     *
     * @param haptic the SDL_Haptic device to unpause
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticPause(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticUnpause(
            SDL_Haptic haptic);

    /**
     * Stop all the currently playing effects on a haptic device.
     *
     * @param haptic the SDL_Haptic device to stop
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticStopAll(
            SDL_Haptic haptic);

    /**
     * Check whether rumble is supported on a haptic device.
     *
     * @param haptic haptic device to check for rumble support
     * @return true if effect is supported, false if it isn't, or a
     * negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_HapticRumbleInit(SDL_Haptic)
     * @see #SDL_HapticRumblePlay(SDL_Haptic, float, int)
     * @see #SDL_HapticRumbleStop(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticRumbleSupported(
            SDL_Haptic haptic);

    /**
     * Initialize a haptic device for simple rumble playback.
     *
     * @param haptic the haptic device to initialize for simple rumble playback
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticOpen(int)
     * @see #SDL_HapticRumblePlay(SDL_Haptic, float, int)
     * @see #SDL_HapticRumbleStop(SDL_Haptic)
     * @see #SDL_HapticRumbleSupported(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticRumbleInit(
            SDL_Haptic haptic);

    /**
     * Run a simple rumble effect on a haptic device.
     *
     * @param haptic   the haptic device to play the rumble effect on
     * @param strength strength of the rumble to play as a 0-1 float value
     * @param length   length of the rumble to play in milliseconds
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticRumbleInit(SDL_Haptic)
     * @see #SDL_HapticRumbleStop(SDL_Haptic)
     * @see #SDL_HapticRumbleSupported(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticRumblePlay(
            SDL_Haptic haptic,
            float strength,
            int length);

    /**
     * Stop the simple rumble on a haptic device.
     *
     * @param haptic the haptic device to stop the rumble effect on
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_HapticRumbleInit(SDL_Haptic)
     * @see #SDL_HapticRumblePlay(SDL_Haptic, float, int)
     * @see #SDL_HapticRumbleSupported(SDL_Haptic)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_HapticRumbleStop(
            SDL_Haptic haptic);
}
