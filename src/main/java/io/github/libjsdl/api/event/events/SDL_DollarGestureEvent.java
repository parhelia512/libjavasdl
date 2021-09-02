package io.github.libjsdl.api.event.events;

import com.sun.jna.NativeLong;

import io.github.libjsdl.jna.AbstractSdlStructure;

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
