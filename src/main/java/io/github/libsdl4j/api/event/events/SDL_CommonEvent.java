package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Fields shared by every event
 */
@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_CommonEvent extends Structure {

    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    public SDL_CommonEvent() {
    }

    public SDL_CommonEvent(Pointer p) {
        super(p);
    }
}
