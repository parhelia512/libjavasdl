package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_MOUSEMOTION;
import static io.github.libsdl4j.api.touch.SdlTouchConst.SDL_TOUCH_MOUSEID;

/**
 * Mouse motion event structure (event.motion.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "state",
        "x",
        "y",
        "xrel",
        "yrel"
})
public final class SDL_MouseMotionEvent extends Structure {

    /** {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_MOUSEMOTION SDL_MOUSEMOTION} */
    @MagicConstant(intValues = SDL_MOUSEMOTION)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /**
     * The mouse instance id, or
     * {@link io.github.libsdl4j.api.touch.SdlTouchConst#SDL_TOUCH_MOUSEID SDL_TOUCH_MOUSEID}
     */
    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;

    /** The current button state */
    public int state;

    /** X coordinate, relative to window */
    public int x;

    /** Y coordinate, relative to window */
    public int y;

    /** The relative motion in the X direction */
    public int xrel;

    /** The relative motion in the Y direction */
    public int yrel;

    public SDL_MouseMotionEvent() {
    }

    public SDL_MouseMotionEvent(Pointer p) {
        super(p);
    }
}
