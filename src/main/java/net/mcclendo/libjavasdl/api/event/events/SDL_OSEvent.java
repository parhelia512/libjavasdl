package net.mcclendo.libjavasdl.api.event.events;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_OSEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
}
