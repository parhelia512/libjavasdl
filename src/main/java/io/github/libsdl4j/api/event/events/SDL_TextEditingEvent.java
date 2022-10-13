package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_TEXTEDITING;

/**
 * Keyboard text editing event structure (event.edit.*)
 */
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

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_TEXTEDITING SDL_TEXTEDITING} */
    @MagicConstant(intValues = SDL_TEXTEDITING)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    // TODO: byte, char or String?
    /** The editing text */
    public byte[] text = new byte[SDL_TEXTEDITINGEVENT_TEXT_SIZE];

    /** The start cursor of selected editing text */
    public int start;

    /** The length of selected editing text */
    public int length;

    public SDL_TextEditingEvent() {
    }

    public SDL_TextEditingEvent(Pointer p) {
        super(p);
    }
}
