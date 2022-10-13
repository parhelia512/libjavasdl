package io.github.libsdl4j.api.audio;

import static io.github.libsdl4j.api.endian.SdlEndianConst.SDL_BIG_ENDIAN;
import static io.github.libsdl4j.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static io.github.libsdl4j.api.endian.SdlEndianConst.SDL_LIL_ENDIAN;

public final class SdlAudioConst {

    public static final int SDL_AUDIO_MASK_BITSIZE = 0xFF;
    public static final int SDL_AUDIO_MASK_DATATYPE = 1 << 8;
    public static final int SDL_AUDIO_MASK_ENDIAN = 1 << 12;
    public static final int SDL_AUDIO_MASK_SIGNED = 1 << 15;

    public static int SDL_AUDIO_BITSIZE(
            int x) {
        return (x & SDL_AUDIO_MASK_BITSIZE);
    }

    public static boolean SDL_AUDIO_ISFLOAT(
            int x) {
        return (x & SDL_AUDIO_MASK_DATATYPE) != 0;
    }

    public static boolean SDL_AUDIO_ISBIGENDIAN(
            int x) {
        return (x & SDL_AUDIO_MASK_ENDIAN) != 0;
    }

    public static boolean SDL_AUDIO_ISSIGNED(
            int x) {
        return (x & SDL_AUDIO_MASK_SIGNED) != 0;
    }

    public static boolean SDL_AUDIO_ISINT(
            int x) {
        return (!SDL_AUDIO_ISFLOAT(x));
    }

    public static boolean SDL_AUDIO_ISLITTLEENDIAN(
            int x) {
        return (!SDL_AUDIO_ISBIGENDIAN(x));
    }

    public static boolean SDL_AUDIO_ISUNSIGNED(
            int x) {
        return (!SDL_AUDIO_ISSIGNED(x));
    }

    /** Unsigned 8-bit samples */
    public static final int AUDIO_U8 = 0x0008;

    /** Signed 8-bit samples */
    public static final int AUDIO_S8 = 0x8008;

    /** Unsigned 16-bit samples */
    public static final int AUDIO_U16LSB = 0x0010;

    /** Signed 16-bit samples */
    public static final int AUDIO_S16LSB = 0x8010;

    /** Unsigned 16-bit samples, big-endian byte order */
    public static final int AUDIO_U16MSB = 0x1010;

    /** Signed 16-bit samples, big-endian byte order */
    public static final int AUDIO_S16MSB = 0x9010;

    public static final int AUDIO_U16 = AUDIO_U16LSB;

    public static final int AUDIO_S16 = AUDIO_S16LSB;

    /** 32-bit integer samples */
    public static final int AUDIO_S32LSB = 0x8020;

    /** 32-bit integer samples, big-endian byte order */
    public static final int AUDIO_S32MSB = 0x9020;

    public static final int AUDIO_S32 = AUDIO_S32LSB;

    /** 32-bit floating point samples */
    public static final int AUDIO_F32LSB = 0x8120;

    /** 32-bit floating point samples, big-endian byte order */
    public static final int AUDIO_F32MSB = 0x9120;

    public static final int AUDIO_F32 = AUDIO_F32LSB;

    public static final int AUDIO_U16SYS;
    public static final int AUDIO_S16SYS;
    public static final int AUDIO_S32SYS;
    public static final int AUDIO_F32SYS;

    static {
        if (SDL_BYTEORDER == SDL_LIL_ENDIAN) {
            AUDIO_U16SYS = AUDIO_U16LSB;
            AUDIO_S16SYS = AUDIO_S16LSB;
            AUDIO_S32SYS = AUDIO_S32LSB;
            AUDIO_F32SYS = AUDIO_F32LSB;
        } else if (SDL_BYTEORDER == SDL_BIG_ENDIAN) {
            AUDIO_U16SYS = AUDIO_U16MSB;
            AUDIO_S16SYS = AUDIO_S16MSB;
            AUDIO_S32SYS = AUDIO_S32MSB;
            AUDIO_F32SYS = AUDIO_F32MSB;
        } else {
            throw new IllegalStateException();
        }
    }

    public static final int SDL_AUDIO_ALLOW_FREQUENCY_CHANGE = 0x00000001;
    public static final int SDL_AUDIO_ALLOW_FORMAT_CHANGE = 0x00000002;
    public static final int SDL_AUDIO_ALLOW_CHANNELS_CHANGE = 0x00000004;
    public static final int SDL_AUDIO_ALLOW_SAMPLES_CHANGE = 0x00000008;
    public static final int SDL_AUDIO_ALLOW_ANY_CHANGE = SDL_AUDIO_ALLOW_FREQUENCY_CHANGE
            | SDL_AUDIO_ALLOW_FORMAT_CHANGE
            | SDL_AUDIO_ALLOW_CHANNELS_CHANGE
            | SDL_AUDIO_ALLOW_SAMPLES_CHANGE;

    public static final int SDL_MIX_MAXVOLUME = 128;

    private SdlAudioConst() {
    }
}
