package net.mcclendo.libjavasdl.api.haptic;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

@SuppressWarnings("checkstyle:MagicNumber")
public final class SDL_HapticDirection extends AbstractSdlStructure {
    public byte type;
    int[] dir = new int[3];
}
