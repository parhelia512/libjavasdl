package org.libsdl.api.haptic.effect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.haptic.SDL_HapticDirection;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_DAMPER;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_FRICTION;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_INERTIA;
import static org.libsdl.api.haptic.SDL_HapticEffectType.SDL_HAPTIC_SPRING;
import static org.libsdl.api.haptic.SdlHapticConst.SDL_HAPTIC_INFINITY;

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
public final class SDL_HapticCondition extends JnaStructure {

    @MagicConstant(intValues = {
            SDL_HAPTIC_SPRING,
            SDL_HAPTIC_DAMPER,
            SDL_HAPTIC_INERTIA,
            SDL_HAPTIC_FRICTION})
    public short type;
    public SDL_HapticDirection direction;

    @MagicConstant(intValues = SDL_HAPTIC_INFINITY)
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

    public SDL_HapticCondition() {
    }

    public SDL_HapticCondition(Pointer p) {
        super(p);
    }
}
