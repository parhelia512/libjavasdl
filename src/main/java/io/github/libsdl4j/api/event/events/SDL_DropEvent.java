package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_DROPBEGIN;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_DROPCOMPLETE;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_DROPFILE;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_DROPTEXT;

/**
 * An event used to request a file open by the system (event.drop.*)
 * This event is enabled by default, you can disable it with SDL_EventState().
 *
 * <p><b>Note:</b> If this event is enabled, you must free the filename in the event.</p>
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "file",
        "windowID"
})
public final class SDL_DropEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_DROPBEGIN SDL_DROPBEGIN}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_DROPFILE SDL_DROPFILE}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_DROPTEXT SDL_DROPTEXT}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_DROPCOMPLETE SDL_DROPCOMPLETE}
     */
    @MagicConstant(intValues = {SDL_DROPBEGIN, SDL_DROPFILE, SDL_DROPTEXT, SDL_DROPCOMPLETE})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    // TODO: Test how to read file name to a Java String
    /** The file name, which should be freed with SDL_free(), is null on begin/complete */
    public Pointer file;

    /** The window that was dropped on, if any */
    public int windowID;

    public SDL_DropEvent() {
    }

    public SDL_DropEvent(Pointer p) {
        super(p);
    }
}
