package io.github.libjsdl.api.event.events;

import com.sun.jna.Pointer;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_SysWMEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public Pointer msg;
}
