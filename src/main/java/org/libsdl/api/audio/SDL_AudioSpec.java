package org.libsdl.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * <p>The calculated values in this structure are calculated by SDL_OpenAudio().</p>
 *
 * <p>For multi-channel audio, the default SDL channel mapping is:</p>
 * <pre>
 *  2:  FL FR                       (stereo)
 *  3:  FL FR LFE                   (2.1 surround)
 *  4:  FL FR BL BR                 (quad)
 *  5:  FL FR FC BL BR              (quad + center)
 *  6:  FL FR FC LFE SL SR          (5.1 surround - last two can also be BL BR)
 *  7:  FL FR FC LFE BC SL SR       (6.1 surround)
 *  8:  FL FR FC LFE BL BR SL SR    (7.1 surround)
 * </pre>
 */
@Structure.FieldOrder({
        "freq",
        "format",
        "channels",
        "silence",
        "samples",
        "padding",
        "size",
        "callback",
        "userdata"
})
public class SDL_AudioSpec extends Structure {

    /**
     * DSP frequency -- samples per second
     */
    int freq;

    /**
     * Audio data format
     */
    SDL_AudioFormat format;

    /**
     * Number of channels: 1 mono, 2 stereo
     */
    byte channels;

    /**
     * Audio buffer silence value (calculated)
     */
    byte silence;

    /**
     * Audio buffer size in sample FRAMES (total samples divided by channel count)
     */
    short samples;

    /**
     * Necessary for some compile environments
     */
    short padding;

    /**
     * Audio buffer size in bytes (calculated)
     */
    int size;

    /**
     * Callback that feeds the audio device (NULL to use SDL_QueueAudio()).
     */
    SDL_AudioCallback callback;

    /**
     * Userdata passed to callback (ignored for NULL callbacks).
     */
    Pointer userdata;
}
