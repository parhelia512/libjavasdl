package io.github.libjsdl.api.haptic;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "length",
        "largeMagnitude",
        "smallMagnitude"
})
public final class SDL_HapticLeftRight extends Structure {

    public short type;
    public int length;
    public short largeMagnitude;
    public short smallMagnitude;
}
