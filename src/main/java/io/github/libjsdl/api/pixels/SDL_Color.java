package io.github.libjsdl.api.pixels;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "r",
        "g",
        "b",
        "a"
})
public final class SDL_Color extends Structure {

    public byte r;
    public byte g;
    public byte b;
    public byte a;
}
