package org.libsdl.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import org.libsdl.api.haptic.SDL_HapticDirection;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHDOWN;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SAWTOOTHUP;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SINE;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_TRIANGLE;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

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
public final class SDL_HapticPeriodic extends JnaStructure {

    @MagicConstant(intValues = {
            SDL_HAPTIC_SINE,
            SDL_HAPTIC_TRIANGLE,
            SDL_HAPTIC_SAWTOOTHUP,
            SDL_HAPTIC_SAWTOOTHDOWN})
    public short type;
    public SDL_HapticDirection direction;

    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
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

    public SDL_HapticPeriodic() {
    }

    public SDL_HapticPeriodic(Pointer p) {
        super(p);
    }
}
