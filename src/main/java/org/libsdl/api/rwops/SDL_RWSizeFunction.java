package org.libsdl.api.rwops;

import com.sun.jna.Callback;

@FunctionalInterface
public interface SDL_RWSizeFunction extends Callback {

    long size(
            SDL_RWops context);
}
