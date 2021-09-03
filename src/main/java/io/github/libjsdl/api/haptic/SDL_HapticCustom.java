package io.github.libjsdl.api.haptic;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "channels",
        "period",
        "samples",
        "data",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticCustom extends Structure {

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
