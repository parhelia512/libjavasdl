package org.libsdl.api.rwops;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import org.libsdl.api.stdinc.size_t;

@FunctionalInterface
public interface SDL_RWReadFunction extends Callback {

    size_t read(
            SDL_RWops context,
            Pointer ptr,
            size_t itemSize,
            size_t maxnum);
}
