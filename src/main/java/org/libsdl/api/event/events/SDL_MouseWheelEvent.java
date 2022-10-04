package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEWHEEL;
import static org.libsdl.api.mouse.SDL_MouseWheelDirection.SDL_MOUSEWHEEL_FLIPPED;
import static org.libsdl.api.mouse.SDL_MouseWheelDirection.SDL_MOUSEWHEEL_NORMAL;
import static org.libsdl.api.touch.SdlTouchConst.SDL_TOUCH_MOUSEID;

/**
 * Mouse wheel event structure (event.wheel.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "x",
        "y",
        "direction",
        "preciseX",
        "preciseY"
})
public final class SDL_MouseWheelEvent extends Structure {

    /** {@link org.libsdl.api.event.SDL_EventType#SDL_MOUSEWHEEL SDL_MOUSEWHEEL} */
    @MagicConstant(intValues = SDL_MOUSEWHEEL)
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The window with mouse focus, if any */
    public int windowID;

    /** The mouse instance id, or {@link org.libsdl.api.touch.SdlTouchConst#SDL_TOUCH_MOUSEID SDL_TOUCH_MOUSEID} */
    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;

    /** The amount scrolled horizontally, positive to the right and negative to the left */
    public int x;

    /** The amount scrolled vertically, positive away from the user and negative toward the user */
    public int y;

    /**
     * Set to either {@link org.libsdl.api.mouse.SDL_MouseWheelDirection#SDL_MOUSEWHEEL_NORMAL SDL_MOUSEWHEEL_NORMAL}
     * or {@link org.libsdl.api.mouse.SDL_MouseWheelDirection#SDL_MOUSEWHEEL_FLIPPED SDL_MOUSEWHEEL_FLIPPED}.
     * When {@code SDL_MOUSEWHEEL_FLIPPED} the values in {@code X} and {@code Y} will be opposite.
     * Multiply by -1 to change them back
     */
    @MagicConstant(intValues = {SDL_MOUSEWHEEL_NORMAL, SDL_MOUSEWHEEL_FLIPPED})
    public int direction;

    /** The amount scrolled horizontally, positive to the right and negative to the left, with float precision (added in 2.0.18) */
    public float preciseX;

    /** The amount scrolled vertically, positive away from the user and negative toward the user, with float precision (added in 2.0.18) */
    public float preciseY;

    public SDL_MouseWheelEvent() {
    }

    public SDL_MouseWheelEvent(Pointer p) {
        super(p);
    }
}
