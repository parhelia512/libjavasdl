package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_TEXTEDITING;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text",
        "start",
        "length"
})
public final class SDL_TextEditingEvent extends Structure {

    private static final int SDL_TEXTEDITINGEVENT_TEXT_SIZE = 32;

    @MagicConstant(intValues = SDL_TEXTEDITING)
    public int type;
    public int timestamp;
    public int windowID;
    public byte[] text = new byte[SDL_TEXTEDITINGEVENT_TEXT_SIZE];      // TODO: byte, char or String?
    public int start;
    public int length;

    public SDL_TextEditingEvent() {
    }

    public SDL_TextEditingEvent(Pointer p) {
        super(p);
    }
}
