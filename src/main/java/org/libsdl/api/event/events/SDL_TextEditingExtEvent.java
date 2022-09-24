package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaUtils;

import static org.libsdl.api.event.SDL_EventType.SDL_TEXTEDITING_EXT;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "text",
        "start",
        "length"
})
public final class SDL_TextEditingExtEvent extends Structure {

    @MagicConstant(intValues = SDL_TEXTEDITING_EXT)
    public int type;
    public int timestamp;
    public int windowID;
    public Pointer text;
    public int start;
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
