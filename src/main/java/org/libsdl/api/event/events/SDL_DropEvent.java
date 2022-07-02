package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_DROPBEGIN;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPCOMPLETE;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPFILE;
import static org.libsdl.api.event.SDL_EventType.SDL_DROPTEXT;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "file",
        "windowID"
})
public final class SDL_DropEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_DROPBEGIN, SDL_DROPFILE, SDL_DROPTEXT, SDL_DROPCOMPLETE})
    public int type;
    public int timestamp;
    public Pointer file;            // TODO: Test how to read file name to a Java String
    public int windowID;
}
