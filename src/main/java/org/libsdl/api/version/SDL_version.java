package org.libsdl.api.version;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "major",
        "minor",
        "patch"
})
public final class SDL_version extends JnaStructure {

    public byte major;
    public byte minor;
    public byte patch;

    public SDL_version() {
    }

    public SDL_version(Pointer p) {
        super(p);
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }
}
