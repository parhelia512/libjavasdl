package io.github.libjsdl.api.haptic;

import io.github.libjsdl.jna.AbstractSdlStructure;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SDL_HapticCondition extends AbstractSdlStructure {

    public short type;
    public SDL_HapticDirection direction;
    public int length;
    public short delay;
    public short button;
    public short interval;
    public short[] rightSat = new short[3];
    public short[] leftSat = new short[3];
    public short[] rightCoeff = new short[3];
    public short[] leftCSoeff = new short[3];
    public short[] deadband = new short[3];
    public short[] center = new short[3];
}
