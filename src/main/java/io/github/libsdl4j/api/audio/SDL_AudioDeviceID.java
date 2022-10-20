package io.github.libsdl4j.api.audio;

import com.sun.jna.IntegerType;

/**
 * SDL Audio Device IDs.
 *
 * <p>A successful call to SDL_OpenAudio() is always device ID 1, and legacy
 * SDL audio APIs assume you want this device ID. SDL_OpenAudioDevice() calls
 * always returns device IDs greater or equal to 2 on success. The legacy calls are good both
 * for backwards compatibility and when you don't care about multiple,
 * specific, or capture devices.</p>
 */
public final class SDL_AudioDeviceID extends IntegerType {

    public SDL_AudioDeviceID() {
        this(0L);
    }

    public SDL_AudioDeviceID(long value) {
        super(4, value, true);
    }
}
