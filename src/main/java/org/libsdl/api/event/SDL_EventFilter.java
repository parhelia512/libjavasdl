package org.libsdl.api.event;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {

    int filterEvent(
            Pointer userdata,
            SDL_Event event);
}
