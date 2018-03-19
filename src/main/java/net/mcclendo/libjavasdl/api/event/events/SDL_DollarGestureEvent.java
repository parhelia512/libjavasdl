package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.NativeLong;

public final class SDL_DollarGestureEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public NativeLong touchId;
    public NativeLong gestureId;
    public int numFingers;
    public float error;
    public float x;
    public float y;
}
