package io.github.libsdl4j.api.audio;

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
 *  5:  FL FR LFE BL BR             (4.1 surround)
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
public final class SDL_AudioSpec extends Structure {

    /** DSP frequency -- samples per second */
    public int freq;

    /** Audio data format */
    public SDL_AudioFormat format;

    /** Number of channels: 1 mono, 2 stereo */
    public byte channels;

    /** Audio buffer silence value (calculated) */
    public byte silence;

    /** Audio buffer size in sample FRAMES (total samples divided by channel count) */
    public short samples;

    /** Necessary for some compile environments */
    public short padding;

    /** Audio buffer size in bytes (calculated) */
    public int size;

    /** Callback that feeds the audio device (NULL to use SDL_QueueAudio()). */
    public SDL_AudioCallback callback;

    /** Userdata passed to callback (ignored for NULL callbacks). */
    public Pointer userdata;

    public SDL_AudioSpec() {
    }

    public SDL_AudioSpec(Pointer p) {
        super(p);
    }
}
