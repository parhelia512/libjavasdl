package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEBUTTONDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_MOUSEBUTTONUP;
import static org.libsdl.api.event.SdlEventsConst.SDL_PRESSED;
import static org.libsdl.api.event.SdlEventsConst.SDL_RELEASED;
import static org.libsdl.api.touch.SdlTouchConst.SDL_TOUCH_MOUSEID;

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
public final class SDL_MouseButtonEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_MOUSEBUTTONDOWN, SDL_MOUSEBUTTONUP})
    public int type;
    public int timestamp;
    public int windowID;

    @MagicConstant(intValues = SDL_TOUCH_MOUSEID)
    public int which;
    public byte button;

    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;
    public byte clicks;
    public byte padding1;
    public int x;
    public int y;
}
