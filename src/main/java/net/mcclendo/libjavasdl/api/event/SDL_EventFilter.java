package net.mcclendo.libjavasdl.api.event;

import net.mcclendo.libjavasdl.api.event.events.SDL_Event;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {

    int callback(
            Pointer userdata,
            SDL_Event event);
}
