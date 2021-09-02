package io.github.libjsdl.api.keybaord;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_Keysym extends AbstractSdlStructure {

    public int scancode;
    public int sym;
    public short mod;
    public int unused;
}
