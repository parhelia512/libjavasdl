package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.api.SDL_Keysym;
import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

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
