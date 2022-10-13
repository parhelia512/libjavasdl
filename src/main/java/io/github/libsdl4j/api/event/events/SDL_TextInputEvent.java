package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_TEXTINPUT;

/**
 * Keyboard text input event structure (event.text.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text"
})
public final class SDL_TextInputEvent extends Structure {

    private static final int SDL_TEXTINPUTEVENT_TEXT_SIZE = 32;

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_TEXTINPUT SDL_TEXTINPUT} */
    @MagicConstant(intValues = SDL_TEXTINPUT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    // TODO: byte, char or String?
    /** The input text */
    public byte[] text = new byte[SDL_TEXTINPUTEVENT_TEXT_SIZE];

    public SDL_TextInputEvent() {
    }

    public SDL_TextInputEvent(Pointer p) {
        super(p);
    }
}
