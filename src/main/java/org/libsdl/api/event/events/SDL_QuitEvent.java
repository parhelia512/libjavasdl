package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;

/**
 * The "quit requested" event
 */
@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_QuitEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_QUIT SDL_QUIT} */
    @MagicConstant(intValues = SDL_QUIT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    public SDL_QuitEvent() {
    }

    public SDL_QuitEvent(Pointer p) {
        super(p);
    }
}
