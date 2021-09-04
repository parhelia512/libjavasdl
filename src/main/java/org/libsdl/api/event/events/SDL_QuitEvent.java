package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_QuitEvent extends Structure {

    public int type;
    public int timestamp;
}
