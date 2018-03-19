package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_WindowEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public byte event;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public int data1;
    public int data2;
}
