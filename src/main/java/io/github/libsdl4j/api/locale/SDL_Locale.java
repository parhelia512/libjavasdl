package io.github.libsdl4j.api.locale;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "language",
        "country"
})
public final class SDL_Locale extends Structure {

    /** A language name, like "en" for English. */
    public String language;

    /** A country, like "US" for America. Can be null. */
    public String country;

    public SDL_Locale() {
        super();
    }

    public SDL_Locale(Pointer p) {
        super(p);
    }
}
