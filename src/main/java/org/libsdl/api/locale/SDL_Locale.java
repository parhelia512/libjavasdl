package org.libsdl.api.locale;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "language",
        "country"
})
public class SDL_Locale extends Structure {

    public SDL_Locale() {
    }

    public SDL_Locale(Pointer p) {
        super(p);
    }

    public String language;
    public String country;
}
