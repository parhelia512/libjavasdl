package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * A user-defined event type (event.user.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "code",
        "data1",
        "data2"
})
public final class SDL_UserEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_USEREVENT SDL_USEREVENT}
     * through {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_LASTEVENT SDL_LASTEVENT}-1
     */
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The associated window if any */
    public int windowID;

    /** User defined event code */
    public int code;

    /** User defined data pointer */
    public Pointer data1;

    /** User defined data pointer */
    public Pointer data2;

    public SDL_UserEvent() {
    }

    public SDL_UserEvent(Pointer p) {
        super(p);
    }
}
