package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_QUIT;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_QuitEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_QUIT)
    public int type;
    public int timestamp;
}
