package org.libsdl.api.locale;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "language",
        "country"
})
public final class SDL_Locale extends Structure {

    public String language;
    public String country;

    public SDL_Locale() {
        super();
    }

    public SDL_Locale(Pointer p) {
        super(p);
    }
}
