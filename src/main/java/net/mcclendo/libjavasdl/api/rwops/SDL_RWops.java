package net.mcclendo.libjavasdl.api.rwops;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_RWops extends AbstractSdlStructure {

    public Pointer size;
    public Pointer seek;
    public Pointer read;
    public Pointer write;
    public Pointer close;

    public int type;
}
