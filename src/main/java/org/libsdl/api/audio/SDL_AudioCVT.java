package org.libsdl.api.audio;

import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;


@Structure.FieldOrder({
        "needed",
        "src_format",
        "dst_format",
        "rate_incr",
        "buf",
        "len",
        "len_cvt",
        "len_mult",
        "len_ratio",
        "filters",
        "filter_index",
})
public class SDL_AudioCVT extends Structure {

    /**
     * <p>Upper limit of filters in SDL_AudioCVT</p>
     *
     * <p>The maximum number of SDL_AudioFilter functions in SDL_AudioCVT is
     * currently limited to 9. The SDL_AudioCVT.filters array has 10 pointers,
     * one of which is the terminating null pointer.</p>
     */
    public static final int SDL_AUDIOCVT_MAX_FILTERS = 9;

    /**
     * Set to 1 if conversion possible
     */
    int needed;

    /**
     * Source audio format
     */
    SDL_AudioFormat src_format;

    /**
     * Target audio format
     */
    SDL_AudioFormat dst_format;

    /**
     * Rate conversion increment
     */
    double rate_incr;

    /**
     * Buffer to hold entire audio data
     */
    ByteByReference buf;

    /**
     * Length of original audio buffer
     */
    int len;

    /**
     * Length of converted audio buffer
     */
    int len_cvt;

    /**
     * buffer must be len*len_mult big
     */
    int len_mult;

    /**
     * Given len, final size is len*len_ratio
     */
    double len_ratio;

    // TODO: Test sizeof and if it generally works
    /**
     * null-terminated list of filter functions
     */
    SDL_AudioFilter[] filters = new SDL_AudioFilter[SDL_AUDIOCVT_MAX_FILTERS + 1];

    /**
     * Current audio conversion function
     */
    int filter_index;
}
