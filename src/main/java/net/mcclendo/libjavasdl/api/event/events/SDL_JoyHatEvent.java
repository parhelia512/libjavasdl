package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.NativeLong;

public final class SDL_JoyHatEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong which;
    public byte hat;
    public byte value;
    public byte padding1;
    public byte padding2;
}
