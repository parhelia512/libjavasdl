package org.libsdl.api.event.events;

import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.keyboard.SDL_Keysym;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_KEYDOWN;
import static org.libsdl.api.event.SDL_EventType.SDL_KEYUP;
import static org.libsdl.api.event.SdlEventsConst.SDL_PRESSED;
import static org.libsdl.api.event.SdlEventsConst.SDL_RELEASED;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "windowID",
        "state",
        "repeat",
        "padding2",
        "padding3",
        "keysym"
})
public final class SDL_KeyboardEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_KEYDOWN, SDL_KEYUP})
    public int type;
    public int timestamp;
    public int windowID;

    @MagicConstant(intValues = {SDL_PRESSED, SDL_RELEASED})
    public byte state;
    public byte repeat;
    public byte padding2;
    public byte padding3;
    public SDL_Keysym keysym;
}
