package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_MultiGestureEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong touchId;
    public float dTheta;
    public float dDist;
    public float x;
    public float y;
    public short numFingers;
    public short padding;
}
