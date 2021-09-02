package io.github.libjsdl.api.haptic;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_HapticPeriodic extends AbstractSdlStructure {

    public short type;
    public SDL_HapticDirection direction;
    public int length;
    public short delay;
    public short button;
    public short interval;
    public short period;
    public short magnitude;
    public short offset;
    public short phase;
    public short attackLength;
    public short attackLevel;
    public short fadeLength;
    public short fadeLevel;
}
