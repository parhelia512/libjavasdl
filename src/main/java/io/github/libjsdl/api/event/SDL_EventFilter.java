package io.github.libjsdl.api.event;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

import io.github.libjsdl.api.event.events.SDL_Event;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {

    int callback(
            Pointer userdata,
            SDL_Event event);
}
