package io.github.libjsdl.api.haptic;

import io.github.libjsdl.jna.AbstractSdlStructure;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SDL_HapticDirection extends AbstractSdlStructure {
    public byte type;
    int[] dir = new int[3];
}
