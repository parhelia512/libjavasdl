package org.libsdl.api.touch;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "id",
        "x",
        "y",
        "pressure"
})
public class SDL_Finger extends JnaStructure {

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
