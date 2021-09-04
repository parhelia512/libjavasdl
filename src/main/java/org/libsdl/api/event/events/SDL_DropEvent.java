package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "file",
        "windowID"
})
public final class SDL_DropEvent extends Structure {

    public int type;
    public int timestamp;
    public Pointer file;
    public int windowID;
}
