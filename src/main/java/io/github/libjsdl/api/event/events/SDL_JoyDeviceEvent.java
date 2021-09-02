package io.github.libjsdl.api.event.events;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_JoyDeviceEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int which;
}
