package org.libsdl.api.gesture;

import com.sun.jna.IntegerType;

public class SDL_GestureID extends IntegerType {

    public SDL_GestureID() {
        super(8, false);
    }

    public SDL_GestureID(long value) {
        super(8, value, false);
    }
}
