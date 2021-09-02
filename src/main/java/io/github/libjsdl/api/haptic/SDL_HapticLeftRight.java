package io.github.libjsdl.api.haptic;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_HapticLeftRight extends AbstractSdlStructure {

    public short type;
    public int length;
    public short largeMagnitude;
    public short smallMagnitude;
}
