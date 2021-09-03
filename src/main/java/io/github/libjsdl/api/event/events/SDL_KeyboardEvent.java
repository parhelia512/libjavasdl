package io.github.libjsdl.api.event.events;

import com.sun.jna.Structure;

import io.github.libjsdl.api.keybaord.SDL_Keysym;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "state",
        "repeat",
        "padding2",
        "padding3",
        "keysym"
})
public final class SDL_KeyboardEvent extends Structure {

    public int type;
    public int timestamp;
    public int windowID;
    public byte state;
    public byte repeat;
    public byte padding2;
    public byte padding3;
    public SDL_Keysym keysym;
}
