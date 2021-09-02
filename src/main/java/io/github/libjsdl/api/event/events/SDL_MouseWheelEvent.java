package io.github.libjsdl.api.event.events;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_MouseWheelEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public int which;
    public int x;
    public int y;
    public int direction;
}
