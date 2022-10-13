package io.github.libsdl4j.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

/**
 * A structure to hold a set of audio conversion filters and buffers.
 *
 * <p>Note that various parts of the conversion pipeline can take advantage
 * of SIMD operations (like SSE2, for example). SDL_AudioCVT doesn't require
 * you to pass it aligned data, but can possibly run much faster if you
 * set both its (buf) field to a pointer that is aligned to 16 bytes, and its
 * (len) field to something that's a multiple of 16, if possible.</p>
 */
@Structure.FieldOrder({
        "needed",
        "srcFormat",
        "dstFormat",
        "rateIncr",
        "buf",
        "len",
        "lenCvt",
        "lenMult",
        "lenRatio",
        "filters",
        "filterIndex"
})
public final class SDL_AudioCVT extends Structure {

    /**
     * Upper limit of filters in SDL_AudioCVT
     *
     * <p>The maximum number of SDL_AudioFilter functions in SDL_AudioCVT is
     * currently limited to 9. The SDL_AudioCVT.filters array has 10 pointers,
     * one of which is the terminating null pointer.</p>
     */
    public static final int SDL_AUDIOCVT_MAX_FILTERS = 9;

    /** Set to 1 if conversion possible */
    public int needed;

    /** Source audio format */
    public SDL_AudioFormat srcFormat;

    /** Target audio format */
    public SDL_AudioFormat dstFormat;

    /** Rate conversion increment */
    public double rateIncr;

    /** Buffer to hold entire audio data */
    public ByteByReference buf;

    /** Length of original audio buffer */
    public int len;

    /** Length of converted audio buffer */
    public int lenCvt;

    /** buffer must be len*lenMult big */
    public int lenMult;

    /** Given len, final size is len*lenRatio */
    public double lenRatio;

    // TODO: Test sizeof and if it generally works
    /** null-terminated list of filter functions */
    public SDL_AudioFilter[] filters = new SDL_AudioFilter[SDL_AUDIOCVT_MAX_FILTERS + 1];

    /** Current audio conversion function */
    public int filterIndex;

    public SDL_AudioCVT() {
    }

    public SDL_AudioCVT(Pointer p) {
        super(p);
    }
}
