package net.mcclendo.libjavasdl.api.haptic;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_HapticConstant extends AbstractSdlStructure {

    public short type;
    public SDL_HapticDirection direction;
    public int length;
    public short delay;
    public short button;
    public short interval;
    public short level;
    public short attackLength;
    public short attackLevel;
    public short fadeLength;
    public short fadeLevel;
}
