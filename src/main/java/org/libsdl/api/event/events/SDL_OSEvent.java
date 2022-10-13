package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_APP_DIDENTERBACKGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_DIDENTERFOREGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_LOWMEMORY;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_TERMINATING;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_WILLENTERBACKGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_WILLENTERFOREGROUND;

/**
 * OS Specific event
 */
@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_OSEvent extends Structure {

    /**
     * {@link org.libsdl.api.event.SDL_EventType#SDL_APP_TERMINATING SDL_APP_TERMINATING}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_APP_LOWMEMORY SDL_APP_LOWMEMORY}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_APP_WILLENTERBACKGROUND SDL_APP_WILLENTERBACKGROUND}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_APP_DIDENTERBACKGROUND SDL_APP_DIDENTERBACKGROUND}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_APP_WILLENTERFOREGROUND SDL_APP_WILLENTERFOREGROUND}
     * or {@link org.libsdl.api.event.SDL_EventType#SDL_APP_DIDENTERFOREGROUND SDL_APP_DIDENTERFOREGROUND}
     */
    @MagicConstant(intValues = {
            SDL_APP_TERMINATING,
            SDL_APP_LOWMEMORY,
            SDL_APP_WILLENTERBACKGROUND,
            SDL_APP_DIDENTERBACKGROUND,
            SDL_APP_WILLENTERFOREGROUND,
            SDL_APP_DIDENTERFOREGROUND
    })
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    public SDL_OSEvent() {
    }

    public SDL_OSEvent(Pointer p) {
        super(p);
    }
}
