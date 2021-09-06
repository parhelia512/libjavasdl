package org.libsdl.api.rwops;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.api.stdinc.size_t;

@FunctionalInterface
public interface SDL_RWWriteFunction extends Callback {

    size_t write(
            SDL_RWops context,
            Pointer ptr,
            size_t size,
            size_t num);
}
