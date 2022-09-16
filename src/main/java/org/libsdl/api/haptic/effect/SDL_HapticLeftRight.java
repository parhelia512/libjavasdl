package org.libsdl.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_LEFTRIGHT;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

@Structure.FieldOrder({
        "type",
        "length",
        "largeMagnitude",
        "smallMagnitude"
})
public final class SDL_HapticLeftRight extends JnaStructure {

    @MagicConstant(intValues = SDL_HAPTIC_LEFTRIGHT)
    public short type;

    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
    public int length;
    public short largeMagnitude;
    public short smallMagnitude;

    public SDL_HapticLeftRight() {
    }

    public SDL_HapticLeftRight(Pointer p) {
        super(p);
    }
}
