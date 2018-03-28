package net.mcclendo.libjavasdl.api.keybaord;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_Keysym extends AbstractSdlStructure {

    public int scancode;
    public int sym;
    public short mod;
    public int unused;
}
