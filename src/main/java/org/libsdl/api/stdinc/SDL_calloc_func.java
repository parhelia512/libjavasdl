package org.libsdl.api.stdinc;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.jna.size_t;

@FunctionalInterface
public interface SDL_calloc_func extends Callback {

    Pointer SDL_calloc(size_t nmemb, size_t size);
}
