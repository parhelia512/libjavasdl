package org.libsdl.api.haptic;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.haptic.effect.SDL_HapticCondition;
import org.libsdl.api.haptic.effect.SDL_HapticConstant;
import org.libsdl.api.haptic.effect.SDL_HapticCustom;
import org.libsdl.api.haptic.effect.SDL_HapticLeftRight;
import org.libsdl.api.haptic.effect.SDL_HapticPeriodic;
import org.libsdl.api.haptic.effect.SDL_HapticRamp;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CONSTANT;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CUSTOM;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_DAMPER;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_FRICTION;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_INERTIA;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_LEFTRIGHT;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_RAMP;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHDOWN;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHUP;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SINE;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SPRING;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_TRIANGLE;

public final class SDL_HapticEffect extends Union {

    @MagicConstant(valuesFromClass = SDL_HapticEffectType.class)
    public short type;
    public SDL_HapticConstant constant;
    public SDL_HapticPeriodic periodic;
    public SDL_HapticCondition condition;
    public SDL_HapticRamp ramp;
    public SDL_HapticLeftRight leftright;
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
