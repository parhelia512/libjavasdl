package io.github.libsdl4j.api.touch;

import com.sun.jna.IntegerType;

public final class SDL_TouchID extends IntegerType {

    public SDL_TouchID() {
        this(0L);
    }

    public SDL_TouchID(long value) {
        super(8, value, false);
    }
}
