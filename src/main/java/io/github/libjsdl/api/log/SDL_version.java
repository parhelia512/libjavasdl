package io.github.libjsdl.api.log;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "major",
        "minor",
        "patch"
})
public final class SDL_version extends Structure {

    public byte major;
    public byte minor;
    public byte patch;
}
