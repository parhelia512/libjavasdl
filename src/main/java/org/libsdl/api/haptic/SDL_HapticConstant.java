package org.libsdl.api.haptic;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "level",
        "attackLength",
        "attackLevel",
        "fadeLength",
        "fadeLevel"
})
public final class SDL_HapticConstant extends Structure {

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
