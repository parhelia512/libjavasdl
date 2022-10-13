package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import io.github.libsdl4j.jna.JnaUtils;

import static org.libsdl.api.event.SDL_EventType.SDL_TEXTEDITING_EXT;

/**
 * Extended keyboard text editing event structure (event.editExt.*) when text would be
 * truncated if stored in the text buffer SDL_TextEditingEvent
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text",
        "start",
        "length"
})
public final class SDL_TextEditingExtEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_TEXTEDITING_EXT SDL_TEXTEDITING_EXT} */
    @MagicConstant(intValues = SDL_TEXTEDITING_EXT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    /** The editing text, which should be freed with SDL_free(), and will not be NULL */
    public Pointer text;

    /** The start cursor of selected editing text */
    public int start;

    /** The length of selected editing text */
    public int length;

    private transient String convertedText;

    public SDL_TextEditingExtEvent() {
    }

    public SDL_TextEditingExtEvent(Pointer p) {
        super(p);
    }

    public synchronized String getText() {
        if (text != null) {
            convertedText = JnaUtils.extractStringAndReleaseNativeSdlMemory(text);
            text = null;
        }
        return convertedText;
    }
}
