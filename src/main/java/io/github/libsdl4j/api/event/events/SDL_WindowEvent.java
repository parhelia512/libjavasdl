package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.video.SDL_WindowEventID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_WINDOWEVENT;

/**
 * Window state change event data (event.window.*)
 */
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

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_WINDOWEVENT SDL_WINDOWEVENT} */
    @MagicConstant(intValues = SDL_WINDOWEVENT)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The associated window */
    public int windowID;

    /** {@link SDL_WindowEventID} */
    @MagicConstant(valuesFromClass = SDL_WindowEventID.class)
    public byte event;

    public byte padding1;
    public byte padding2;
    public byte padding3;

    /** event dependent data */
    public int data1;

    /** event dependent data */
    public int data2;

    public SDL_WindowEvent() {
    }

    public SDL_WindowEvent(Pointer p) {
        super(p);
    }
}
