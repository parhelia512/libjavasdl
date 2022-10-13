package io.github.libsdl4j.api.gesture;

import com.sun.jna.IntegerType;

public final class SDL_GestureID extends IntegerType {

    public SDL_GestureID() {
        this(0L);
    }

    public SDL_GestureID(long value) {
        super(8, value, false);
    }
}
