package io.github.libjsdl.api.video;

import com.sun.jna.Pointer;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_DisplayMode extends AbstractSdlStructure {

    public int format;
    public int w;
    public int h;
    public int refreshRate;
    public Pointer driverdata;
}
