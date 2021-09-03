package io.github.libjsdl.api.haptic;

import io.github.libjsdl.api.joystick.SDL_Joystick;
import io.github.libjsdl.loader.NativeLoader;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SdlHaptic {

    public static final int SDL_HAPTIC_CONSTANT = (1 << 0);
    public static final int SDL_HAPTIC_SINE = (1 << 1);
    public static final int SDL_HAPTIC_LEFTRIGHT = (1 << 2);
    public static final int SDL_HAPTIC_TRIANGLE = (1 << 3);
    public static final int SDL_HAPTIC_SAWTOOTHUP = (1 << 4);
    public static final int SDL_HAPTIC_SAWTOOTHDOWN = (1 << 5);
    public static final int SDL_HAPTIC_RAMP = (1 << 6);
    public static final int SDL_HAPTIC_SPRING = (1 << 7);
    public static final int SDL_HAPTIC_DAMPER = (1 << 8);
    public static final int SDL_HAPTIC_INERTIA = (1 << 9);
    public static final int SDL_HAPTIC_FRICTION = (1 << 10);
    public static final int SDL_HAPTIC_CUSTOM = (1 << 11);
    public static final int SDL_HAPTIC_GAIN = (1 << 12);
    public static final int SDL_HAPTIC_AUTOCENTER = (1 << 13);
    public static final int SDL_HAPTIC_STATUS = (1 << 14);
    public static final int SDL_HAPTIC_PAUSE = (1 << 15);
    public static final int SDL_HAPTIC_POLAR = 0;
    public static final int SDL_HAPTIC_CARTESIAN = 1;
    public static final int SDL_HAPTIC_SPHERICAL = 2;
    public static final int SDL_HAPTIC_INFINITY = (int) 4294967295L;

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

    public static native int SDL_MouseIsHaptic();

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
