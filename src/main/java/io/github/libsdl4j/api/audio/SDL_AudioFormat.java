package io.github.libsdl4j.api.audio;

import com.sun.jna.IntegerType;

/**
 * Audio format flags.
 *
 * <p>These are what the 16 bits in SDL_AudioFormat currently mean...
 * (Unspecified bits are always zero).</p>
 *
 * <pre>
 * ++-----------------------sample is signed if set
 * ||
 * ||       ++-----------sample is bigendian if set
 * ||       ||
 * ||       ||          ++---sample is float if set
 * ||       ||          ||
 * ||       ||          || +---sample bit size---+
 * ||       ||          || |                     |
 * 15 14 13 12 11 10 09 08 07 06 05 04 03 02 01 00
 * </pre>
 *
 * <p>There are macros in SDL 2.0 and later to query these bits.</p>
 */
public final class SDL_AudioFormat extends IntegerType {

    public SDL_AudioFormat() {
        this(0L);
    }

    public SDL_AudioFormat(long value) {
        super(2, value, true);
    }
}
