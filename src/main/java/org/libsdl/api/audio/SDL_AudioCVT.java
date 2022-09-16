package org.libsdl.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

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
        "filterIndex",
})
public final class SDL_AudioCVT extends Structure {

    /**
     * <p>Upper limit of filters in SDL_AudioCVT</p>
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
    /** null-terminated list of filter functions*/
    public SDL_AudioFilter[] filters = new SDL_AudioFilter[SDL_AUDIOCVT_MAX_FILTERS + 1];

    /** Current audio conversion function */
    public int filterIndex;

    public SDL_AudioCVT() {
    }

    public SDL_AudioCVT(Pointer p) {
        super(p);
    }
}
