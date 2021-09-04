package org.libsdl.api.haptic;

import com.sun.jna.Union;

public final class SDL_HapticEffect extends Union {

    public short type;
    public SDL_HapticConstant constant;
    public SDL_HapticPeriodic periodic;
    public SDL_HapticCondition condition;
    public SDL_HapticRamp ramp;
    public SDL_HapticLeftRight leftright;
    public SDL_HapticCustom custom;
}
