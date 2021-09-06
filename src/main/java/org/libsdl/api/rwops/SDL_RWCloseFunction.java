package org.libsdl.api.rwops;

import com.sun.jna.Callback;

@FunctionalInterface
public interface SDL_RWCloseFunction extends Callback {

    int close(
            SDL_RWops context);
}
