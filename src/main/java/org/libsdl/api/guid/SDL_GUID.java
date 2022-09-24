package org.libsdl.api.guid;

import java.util.UUID;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "leastSigBits",
        "mostSigBits"
})
public class SDL_GUID extends Structure implements Structure.ByValue {

    public long leastSigBits;
    public long mostSigBits;

    public SDL_GUID() {
    }

    public SDL_GUID(Pointer p) {
        super(p);
    }

    @Override
    public String toString() {
        return new UUID(mostSigBits, leastSigBits).toString();
    }

}
