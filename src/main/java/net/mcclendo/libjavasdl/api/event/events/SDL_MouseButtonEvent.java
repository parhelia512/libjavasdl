package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_MouseButtonEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public int which;
    public byte button;
    public byte state;
    public byte clicks;
    public byte padding1;
    public int x;
    public int y;
}
