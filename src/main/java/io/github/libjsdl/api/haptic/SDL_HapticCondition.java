package io.github.libjsdl.api.haptic;

import com.sun.jna.Structure;

@SuppressWarnings("checkstyle:MagicNumber")
@Structure.FieldOrder({
        "type",
        "direction",
        "length",
        "delay",
        "button",
        "interval",
        "rightSat",
        "leftSat",
        "rightCoeff",
        "leftCSoeff",
        "deadband",
        "center"
})
public final class SDL_HapticCondition extends Structure {

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
