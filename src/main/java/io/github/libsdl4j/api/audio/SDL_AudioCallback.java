package io.github.libsdl4j.api.audio;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
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
