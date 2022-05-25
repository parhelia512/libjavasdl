package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEMOTION;
import static org.libsdl.api.touch.SdlTouch.SDL_TOUCH_MOUSEID;

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
public final class SDL_MouseMotionEvent extends JnaStructure {

    @MagicConstant(intValues = SDL_MOUSEMOTION)
    public int type;
    public int timestamp;
    public int windowID;

    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;
    public int state;
    public int x;
    public int y;
    public int xrel;
    public int yrel;
}
