package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_QuitEvent extends Structure {

    @MagicConstant(intValues = SDL_QUIT)
    public int type;
    public int timestamp;

    public SDL_QuitEvent() {
    }

    public SDL_QuitEvent(Pointer p) {
        super(p);
    }
}
