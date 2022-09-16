package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEWHEEL;
import static org.libsdl.api.mouse.SDL_MouseWheelDirection.SDL_MOUSEWHEEL_FLIPPED;
import static org.libsdl.api.mouse.SDL_MouseWheelDirection.SDL_MOUSEWHEEL_NORMAL;
import static org.libsdl.api.touch.SdlTouchConst.SDL_TOUCH_MOUSEID;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "which",
        "x",
        "y",
        "direction"
})
public final class SDL_MouseWheelEvent extends Structure {

    @MagicConstant(intValues = SDL_MOUSEWHEEL)
    public int type;
    public int timestamp;
    public int windowID;

    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;
    public int x;
    public int y;

    @MagicConstant(intValues = {SDL_MOUSEWHEEL_NORMAL, SDL_MOUSEWHEEL_FLIPPED})
    public int direction;

    public SDL_MouseWheelEvent() {
    }

    public SDL_MouseWheelEvent(Pointer p) {
        super(p);
    }
}
