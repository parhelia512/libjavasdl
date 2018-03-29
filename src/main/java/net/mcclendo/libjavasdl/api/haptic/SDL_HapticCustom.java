package net.mcclendo.libjavasdl.api.haptic;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_HapticCustom extends AbstractSdlStructure {

    public short type;
    public SDL_HapticDirection direction;
    public int length;
    public short delay;
    public short button;
    public short interval;
    public byte channels;
    public short period;
    public short samples;
    public Pointer data;
    public short attackLength;
    public short attackLevel;
    public short fadeLength;
    public short fadeLevel;
}
