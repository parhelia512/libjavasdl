package io.github.libsdl4j.api.event.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.touch.SDL_FingerID;
import io.github.libsdl4j.api.touch.SDL_TouchID;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SDL_EventType.SDL_FINGERDOWN;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_FINGERMOTION;
import static io.github.libsdl4j.api.event.SDL_EventType.SDL_FINGERUP;

/**
 * Touch finger event structure (event.tfinger.*)
 */
@Structure.FieldOrder({
        "type",
        "timestamp",
        "touchId",
        "fingerId",
        "x",
        "y",
        "dx",
        "dy",
        "pressure",
        "windowID"
})
public final class SDL_TouchFingerEvent extends Structure {

    /**
     * {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_FINGERMOTION SDL_FINGERMOTION}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_FINGERDOWN SDL_FINGERDOWN}
     * or {@link io.github.libsdl4j.api.event.SDL_EventType#SDL_FINGERUP SDL_FINGERUP}
     */
    @MagicConstant(intValues = {SDL_FINGERDOWN, SDL_FINGERUP, SDL_FINGERMOTION})
    public int type;

    /** In milliseconds, populated using SDL_GetTicks() */
    public int timestamp;

    /** The touch device id */
    public SDL_TouchID touchId;

    public SDL_FingerID fingerId;

    /** Normalized in the range 0...1 */
    public float x;

    /** Normalized in the range 0...1 */
    public float y;

    /** Normalized in the range -1...1 */
    public float dx;

    /** Normalized in the range -1...1 */
    public float dy;

    /** Normalized in the range 0...1 */
    public float pressure;

    /** The window underneath the finger, if any */
    public int windowID;

    public SDL_TouchFingerEvent() {
    }

    public SDL_TouchFingerEvent(Pointer p) {
        super(p);
    }
}
