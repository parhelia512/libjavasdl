package net.mcclendo.libjavasdl.api.video;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_DisplayMode extends AbstractSdlStructure {

    public int format;
    public int w;
    public int h;
    public int refreshRate;
    public Pointer driverdata;
}
