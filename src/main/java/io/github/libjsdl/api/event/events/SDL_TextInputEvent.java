package io.github.libjsdl.api.event.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text"
})
public final class SDL_TextInputEvent extends Structure {

    private static final int BUF_SIZE = 32;

    public int type;
    public int timestamp;
    public int windowID;
    public byte[] text = new byte[BUF_SIZE];
}
