package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.jna.JnaUtils;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_TEXTEDITING_EXT;

/**
 * Extended keyboard text editing event structure (event.editExt.*) when text would be
 * truncated if stored in the text buffer SDL_TextEditingEvent
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "rawText",
        "start",
        "length"
})
public final class SDL_TextEditingExtEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_TEXTEDITING_EXT SDL_TEXTEDITING_EXT} */
    @MagicConstant(intValues = SDL_TEXTEDITING_EXT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with keyboard focus, if any */
    public int windowID;

    /**
     * The pointer to the raw bytes of the text.
     * Do not use it, because it is freed automatically after reading fields from native memory.
     *
     * Use {@link #getText() text} property instead ({@link #getText()}). It contains the converted text.
     */
    public Pointer rawText;

    private String convertedText;

    /** The start cursor of selected editing text */
    public int start;

    /** The length of selected editing text */
    public int length;

    public SDL_TextEditingExtEvent() {
    }

    public SDL_TextEditingExtEvent(Pointer p) {
        super(p);
    }

    @Override
    protected Object readField(StructField structField) {
        Object result = super.readField(structField);
        if (structField.name.equals("rawText")) {
            if (Pointer.nativeValue(rawText) == 0L) {
                return rawText;
            }
            convertedText = JnaUtils.extractStringAndReleaseNativeSdlMemory(rawText);
            rawText = Pointer.NULL;
            return rawText;
        }
        return result;
    }

    /** The editing text. Will not be null */
    public String getText() {
        return convertedText;
    }
}
