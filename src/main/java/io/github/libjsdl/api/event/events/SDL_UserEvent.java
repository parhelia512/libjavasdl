package io.github.libjsdl.api.event.events;

import com.sun.jna.Pointer;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_UserEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public int code;
    public Pointer data1;
    public Pointer data2;
}
