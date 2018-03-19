package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_UserEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public int code;
    public Pointer data1;
    public Pointer data2;
}
