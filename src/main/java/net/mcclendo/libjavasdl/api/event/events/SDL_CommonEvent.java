package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_CommonEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
}
