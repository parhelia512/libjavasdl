package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.video.SDL_DisplayEventID;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_DISPLAYEVENT;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "display",
        "event",
        "padding1",
        "padding2",
        "padding3",
        "data1"
})
public final class SDL_DisplayEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_DISPLAYEVENT)
    public int type;
    public int timestamp;

    /** The associated display index */
    public int display;

    @MagicConstant(valuesFromClass = SDL_DisplayEventID.class)
    public byte event;
    public byte padding1;
    public byte padding2;
    public byte padding3;
    public int data1;

    public SDL_DisplayEvent() {
    }

    public SDL_DisplayEvent(Pointer p) {
        super(p);
    }
}
