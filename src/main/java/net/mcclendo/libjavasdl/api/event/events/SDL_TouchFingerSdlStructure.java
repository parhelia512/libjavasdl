package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.NativeLong;

public final class SDL_TouchFingerSdlStructure extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong touchId;
    public NativeLong fingerId;
    public float x;
    public float y;
    public float dx;
    public float dy;
    public float pressure;
}
