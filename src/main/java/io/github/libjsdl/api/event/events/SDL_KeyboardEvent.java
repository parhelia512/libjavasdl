package io.github.libjsdl.api.event.events;

import io.github.libjsdl.api.SDL_Keysym;
import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_KeyboardEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public byte state;
    public byte repeat;
    public byte padding2;
    public byte padding3;
    public SDL_Keysym keysym;
}
