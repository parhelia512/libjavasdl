package org.libsdl.api.timer;

import com.sun.jna.IntegerType;

public class SDL_TimerID extends IntegerType {

    public SDL_TimerID() {
        super(4);
    }

    public SDL_TimerID(int value) {
        super(4, value);
    }

    public void setValue(int value) {
        super.setValue(value);
    }
}
