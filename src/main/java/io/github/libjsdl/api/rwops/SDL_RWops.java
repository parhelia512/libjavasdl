package io.github.libjsdl.api.rwops;

import com.sun.jna.Pointer;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_RWops extends AbstractSdlStructure {

    public Pointer size;
    public Pointer seek;
    public Pointer read;
    public Pointer write;
    public Pointer close;

    public int type;
}
