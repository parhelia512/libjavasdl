package org.libsdl.api.haptic;

import com.sun.jna.Structure;

@SuppressWarnings("checkstyle:MagicNumber")
@Structure.FieldOrder({
        "type",
        "dir"
})
public final class SDL_HapticDirection extends Structure {

    public byte type;
    public int[] dir = new int[3];
}
