package org.libsdl.api.stdinc;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.jna.size_t;

@FunctionalInterface
public interface SDL_realloc_func extends Callback {

    Pointer SDL_realloc(Pointer mem, size_t size);
}
