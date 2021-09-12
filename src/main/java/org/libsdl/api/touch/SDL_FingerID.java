package org.libsdl.api.touch;

import com.sun.jna.IntegerType;

public class SDL_FingerID extends IntegerType {

    public SDL_FingerID() {
        super(8, false);
    }

    public SDL_FingerID(long value) {
        super(8, value, false);
    }
}
