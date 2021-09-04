package org.libsdl.api.haptic;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "period",
        "magnitude",
        "offset",
        "phase",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticPeriodic extends Structure {

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
