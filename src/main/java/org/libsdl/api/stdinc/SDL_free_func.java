package org.libsdl.api.stdinc;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_free_func extends Callback {

    void SDL_free(Pointer mem);
}
