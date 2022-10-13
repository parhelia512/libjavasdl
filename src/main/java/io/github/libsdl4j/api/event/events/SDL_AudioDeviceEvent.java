package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_AUDIODEVICEADDED;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_AUDIODEVICEREMOVED;

/**
 * Audio device event structure (event.adevice.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "which",
        "iscapture",
        "padding1",
        "padding2",
        "padding3"
})
public final class SDL_AudioDeviceEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_AUDIODEVICEADDED SDL_AUDIODEVICEADDED}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_AUDIODEVICEREMOVED SDL_AUDIODEVICEREMOVED}
     */
    @MagicConstant(intValues = {SDL_AUDIODEVICEADDED, SDL_AUDIODEVICEREMOVED})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The audio device index for the ADDED event (valid until next SDL_GetNumAudioDevices() call), SDL_AudioDeviceID for the REMOVED event */
    public int which;

    /** zero if an output device, non-zero if a capture device. */
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
