package org.libsdl.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaStructure;

import static org.libsdl.api.event.SDL_EventType.SDL_AUDIODEVICEADDED;
import static org.libsdl.api.event.SDL_EventType.SDL_AUDIODEVICEREMOVED;

@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "iscapture",
        "padding1",
        "padding2",
        "padding3"
})
public final class SDL_AudioDeviceEvent extends JnaStructure {

    @MagicConstant(intValues = {SDL_AUDIODEVICEADDED, SDL_AUDIODEVICEREMOVED})
    public int type;
    public int timestamp;
    public int which;
    public byte iscapture;
    public byte padding1;
    public byte padding2;
    public byte padding3;

    public SDL_AudioDeviceEvent() {
    }

    public SDL_AudioDeviceEvent(Pointer p) {
        super(p);
    }
}
