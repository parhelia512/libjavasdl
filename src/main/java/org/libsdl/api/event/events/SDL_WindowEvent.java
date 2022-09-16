package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.video.SDL_WindowEventID;

import static org.libsdl.api.event.SDL_EventType.SDL_WINDOWEVENT;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1",
        "data2"
})
public final class SDL_WindowEvent extends Structure {

    @MagicConstant(intValues = SDL_WINDOWEVENT)
    public int type;
    public int timestamp;
    public int windowID;

    @MagicConstant(valuesFromClass = SDL_WindowEventID.class)
    public byte event;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public int data1;
    public int data2;

    public SDL_WindowEvent() {
    }

    public SDL_WindowEvent(Pointer p) {
        super(p);
    }
}
