package org.libsdl.api.timer;

import com.sun.jna.IntegerType;

/**
 * Definition of the timer ID type.
 */
public class SDL_TimerID extends IntegerType {

    public SDL_TimerID() {
        this(0L);
    }

    public SDL_TimerID(long value) {
        super(4, value, false);
    }
}
