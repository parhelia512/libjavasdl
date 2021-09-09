package org.libsdl.api.audio;

import com.sun.jna.IntegerType;

/**
 * <p>SDL Audio Device IDs.</p>
 *
 * <p>A successful call to SDL_OpenAudio() is always device id 1, and legacy
 * SDL audio APIs assume you want this device ID. SDL_OpenAudioDevice() calls
 * always returns devices >= 2 on success. The legacy calls are good both
 * for backwards compatibility and when you don't care about multiple,
 * specific, or capture devices.</p>
 */
public class SDL_AudioDeviceID extends IntegerType {

    public SDL_AudioDeviceID() {
        super(4);
    }

    public SDL_AudioDeviceID(int value) {
        super(4, value);
    }

    public void setValue(int value) {
        super.setValue(value);
    }
}
