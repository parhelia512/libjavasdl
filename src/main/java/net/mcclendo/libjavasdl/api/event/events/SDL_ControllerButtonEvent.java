package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.NativeLong;

public final class SDL_ControllerButtonEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte button;
    public byte state;
    public byte padding1;
    public byte padding2;
}
