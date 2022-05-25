package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "code",
        "data1",
        "data2"
})
public final class SDL_UserEvent extends JnaStructure {

    public int type;
    public int timestamp;
    public int windowID;
    public int code;
    public Pointer data1;
    public Pointer data2;
}
