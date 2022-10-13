package io.github.libsdl4j.api.touch;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "id",
        "x",
        "y",
        "pressure"
})
public final class SDL_Finger extends Structure {

    public SDL_FingerID id;
    public float x;
    public float y;
    public float pressure;

    public SDL_Finger() {
    }

    public SDL_Finger(Pointer p) {
        super(p);
    }
}
