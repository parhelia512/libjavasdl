package org.libsdl.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.haptic.SDL_HapticDirection;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_CUSTOM;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

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

    @MagicConstant(intValues = SDL_HAPTIC_CUSTOM)
    public short type;
    public SDL_HapticDirection direction;

    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
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

    public SDL_HapticCustom() {
    }

    public SDL_HapticCustom(Pointer p) {
        super(p);
    }
}
