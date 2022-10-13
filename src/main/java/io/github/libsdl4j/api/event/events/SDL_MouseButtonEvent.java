package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_MOUSEBUTTONDOWN;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_MOUSEBUTTONUP;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_PRESSED;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_RELEASED;
import static io.github.libsdl4j.api.touch.SdlTouchConst.SDL_TOUCH_MOUSEID;

/**
 * Mouse button event structure (event.button.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "button",
        "state",
        "clicks",
        "padding1",
        "x",
        "y"
})
public final class SDL_MouseButtonEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_MOUSEBUTTONDOWN SDL_MOUSEBUTTONDOWN}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_MOUSEBUTTONUP SDL_MOUSEBUTTONUP}
     */
    @MagicConstant(intValues = {SDL_MOUSEBUTTONDOWN, SDL_MOUSEBUTTONUP})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /** The mouse instance id, or SDL_TOUCH_MOUSEID */
    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;

    /** The mouse button index */
    public byte button;

    /**
     * {@link io.github.libsdl4j.api.event.SdlEventsConst#SDL_PRESSED SDL_PRESSED}
     * or {@link io.github.libsdl4j.api.event.SdlEventsConst#SDL_RELEASED SDL_RELEASED}
     */
    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;

    /** 1 for single-click, 2 for double-click, etc. */
    public byte clicks;

    public byte padding1;

    /** X coordinate, relative to window */
    public int x;

    /** Y coordinate, relative to window */
    public int y;

    public SDL_MouseButtonEvent() {
    }

    public SDL_MouseButtonEvent(Pointer p) {
        super(p);
    }
}
