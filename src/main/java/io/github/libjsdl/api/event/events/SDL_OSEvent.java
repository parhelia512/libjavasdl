package io.github.libjsdl.api.event.events;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_OSEvent extends AbstractSdlStructure {

    public int type;
    public int timestamp;
}
