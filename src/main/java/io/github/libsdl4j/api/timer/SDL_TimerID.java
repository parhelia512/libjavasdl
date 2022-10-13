package io.github.libsdl4j.api.timer;

import com.sun.jna.IntegerType;

/**
 * Definition of the timer ID type.
 */
public final class SDL_TimerID extends IntegerType {

    public SDL_TimerID() {
        this(0L);
    }

    public SDL_TimerID(long value) {
        super(4, value, false);
    }
}
