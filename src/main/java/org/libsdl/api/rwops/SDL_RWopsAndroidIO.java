package org.libsdl.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "asset"
})
public final class SDL_RWopsAndroidIO extends Structure {

    public Pointer asset;
}
