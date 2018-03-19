package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_SysWMEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public Pointer msg;
}
