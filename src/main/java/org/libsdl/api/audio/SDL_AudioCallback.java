package org.libsdl.api.audio;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_AudioCallback extends Callback {

    /**
     * This function is called when the audio device needs more data.
     *
     * <p>Once the callback returns, the buffer will no longer be valid.
     * Stereo samples are stored in a LRLRLR ordering.</p>
     *
     * <p>You can choose to avoid callbacks and use SDL_QueueAudio() instead, if
     * you like. Just open your audio device with a {@code null} callback.</p>
     *
     * @param userdata An application-specific parameter saved in
     *                 the SDL_AudioSpec structure
     * @param stream   A pointer to the audio data buffer.
     * @param len      The length of that buffer in bytes.
     */
    void callback(
            Pointer userdata,
            Pointer stream,
            int len);
}
