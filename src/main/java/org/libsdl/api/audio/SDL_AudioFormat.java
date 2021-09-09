package org.libsdl.api.audio;

import com.sun.jna.IntegerType;

public class SDL_AudioFormat extends IntegerType {

    /**
     * Create a zero-valued signed IntegerType.
     */
    public SDL_AudioFormat() {
        super(2);
    }

    /**
     * Create a signed IntegerType with the given value.
     *
     * @param value
     */
    public SDL_AudioFormat(short value) {
        super(2, value);
    }
}
