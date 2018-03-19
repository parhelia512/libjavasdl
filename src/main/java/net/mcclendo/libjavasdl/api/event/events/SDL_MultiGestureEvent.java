package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.NativeLong;

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
