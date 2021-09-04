package org.libsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text",
        "start",
        "length"
})
public final class SDL_TextEditingEvent extends Structure {

    private static final int BUF_SIZE = 32;

    public int type;
    public int timestamp;
    public int windowID;
    public byte[] text = new byte[BUF_SIZE];
    public int start;
    public int length;
}
