package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;

import io.github.libjsdl.jna.AbstractSdlStructure;

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
