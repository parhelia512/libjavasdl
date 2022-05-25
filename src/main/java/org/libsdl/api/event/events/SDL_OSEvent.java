package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_APP_DIDENTERBACKGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_DIDENTERFOREGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_LOWMEMORY;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_TERMINATING;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_WILLENTERBACKGROUND;
import static org.libsdl.api.event.SDL_EventType.SDL_APP_WILLENTERFOREGROUND;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_OSEvent extends JnaStructure {

    @MagicConstant(intValues = {
            SDL_APP_TERMINATING,
            SDL_APP_LOWMEMORY,
            SDL_APP_WILLENTERBACKGROUND,
            SDL_APP_DIDENTERBACKGROUND,
            SDL_APP_WILLENTERFOREGROUND,
            SDL_APP_DIDENTERFOREGROUND})
    public int type;
    public int timestamp;
}
