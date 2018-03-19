package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_JoyDeviceEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
    public int which;
}
