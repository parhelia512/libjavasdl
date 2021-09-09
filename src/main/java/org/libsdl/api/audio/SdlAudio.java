package org.libsdl.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.endian.SdlEndianConst.SDL_BIG_ENDIAN;
import static org.libsdl.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static org.libsdl.api.endian.SdlEndianConst.SDL_LIL_ENDIAN;
import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;

/**
 * <p>Adapted from SDL_audio.h</p>
 *
 * <p>Access to the raw audio mixing buffer for the SDL library.</p>
 */
public final class SdlAudio {

    public static final int SDL_AUDIO_MASK_BITSIZE = (0xFF);
    public static final int SDL_AUDIO_MASK_DATATYPE = (1 << 8);
    public static final int SDL_AUDIO_MASK_ENDIAN = (1 << 12);
    public static final int SDL_AUDIO_MASK_SIGNED = (1 << 15);

    public static int SDL_AUDIO_BITSIZE(int x) {
        return (x & SDL_AUDIO_MASK_BITSIZE);
    }

    public static boolean SDL_AUDIO_ISFLOAT(int x) {
        return (x & SDL_AUDIO_MASK_DATATYPE) != 0;
    }

    public static boolean SDL_AUDIO_ISBIGENDIAN(int x) {
        return (x & SDL_AUDIO_MASK_ENDIAN) != 0;
    }

    public static boolean SDL_AUDIO_ISSIGNED(int x) {
        return (x & SDL_AUDIO_MASK_SIGNED) != 0;
    }

    public static boolean SDL_AUDIO_ISINT(int x) {
        return (!SDL_AUDIO_ISFLOAT(x));
    }

    public static boolean SDL_AUDIO_ISLITTLEENDIAN(int x) {
        return (!SDL_AUDIO_ISBIGENDIAN(x));
    }

    public static boolean SDL_AUDIO_ISUNSIGNED(int x) {
        return (!SDL_AUDIO_ISSIGNED(x));
    }

    /**
     * Unsigned 8-bit samples
     */
    public static final int AUDIO_U8 = 0x0008;

    /**
     * Signed 8-bit samples
     */
    public static final int AUDIO_S8 = 0x8008;

    /**
     * Unsigned 16-bit samples
     */
    public static final int AUDIO_U16LSB = 0x0010;

    /**
     * Signed 16-bit samples
     */
    public static final int AUDIO_S16LSB = 0x8010;

    /**
     * As above, but big-endian byte order
     */
    public static final int AUDIO_U16MSB = 0x1010;

    /**
     * As above, but big-endian byte order
     */
    public static final int AUDIO_S16MSB = 0x9010;

    public static final int AUDIO_U16 = AUDIO_U16LSB;

    public static final int AUDIO_S16 = AUDIO_S16LSB;

    /**
     * 32-bit integer samples
     */
    public static final int AUDIO_S32LSB = 0x8020;

    /**
     * 32-bit integer samples, big-endian byte order
     */
    public static final int AUDIO_S32MSB = 0x9020;

    public static final int AUDIO_S32 = AUDIO_S32LSB;

    /**
     * 32-bit floating point samples
     */
    public static final int AUDIO_F32LSB = 0x8120;

    /**
     * 32-bit floating point samples, big-endian byte order
     */
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

    private SdlAudio() {
    }

    /**
     * <p>Loads a WAV from a file.</p>
     *
     * <p>Compatibility convenience function.</p>
     */
    public static SDL_AudioSpec SDL_LoadWAV(String file, SDL_AudioSpec spec, Pointer audio_buf, IntByReference audio_len) {
        return NativeFunctions.SDL_LoadWAV_RW(SDL_RWFromFile(file, "rb"), 1, spec, audio_buf, audio_len);
    }

    private final static class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        private NativeFunctions() {
        }

        public static native int SDL_GetNumAudioDrivers();

        public static native String SDL_GetAudioDriver(int index);

        public static native int SDL_AudioInit(String driver_name);

        public static native void SDL_AudioQuit();

        public static native String SDL_GetCurrentAudioDriver();

        public static native int SDL_OpenAudio(SDL_AudioSpec desired, SDL_AudioSpec obtained);

        public static native int SDL_GetNumAudioDevices(int iscapture);

        public static native String SDL_GetAudioDeviceName(int index, int iscapture);

        public static native int SDL_GetAudioDeviceSpec(int index, int iscapture, SDL_AudioSpec spec);

        public static native SDL_AudioDeviceID SDL_OpenAudioDevice(String device, int iscapture, SDL_AudioSpec desired, SDL_AudioSpec obtained, int allowed_changes);

        @MagicConstant(valuesFromClass = SDL_AudioStatus.class)
        public static native int SDL_GetAudioStatus();

        @MagicConstant(valuesFromClass = SDL_AudioStatus.class)
        public static native int SDL_GetAudioDeviceStatus(SDL_AudioDeviceID dev);

        public static native void SDL_PauseAudio(int pause_on);

        public static native void SDL_PauseAudioDevice(SDL_AudioDeviceID dev, int pause_on);

        // TODO: Test
        public static native SDL_AudioSpec SDL_LoadWAV_RW(SDL_RWops src, int freesrc, SDL_AudioSpec spec, Pointer audio_buf, IntByReference audio_len);

        public static native void SDL_FreeWAV(Pointer audio_buf);

        public static native int SDL_BuildAudioCVT(SDL_AudioCVT cvt, SDL_AudioFormat src_format, byte src_channels, int src_rate, SDL_AudioFormat dst_format, byte dst_channels, int dst_rate);

        public static native int SDL_ConvertAudio(SDL_AudioCVT cvt);

        public static native SDL_AudioStream SDL_NewAudioStream(SDL_AudioFormat src_format, byte src_channels, int src_rate, SDL_AudioFormat dst_format, byte dst_channels, int dst_rate);

        public static native int SDL_AudioStreamPut(SDL_AudioStream stream, Pointer buf, int len);

        public static native int SDL_AudioStreamGet(SDL_AudioStream stream, Pointer buf, int len);

        public static native int SDL_AudioStreamAvailable(SDL_AudioStream stream);

        public static native int SDL_AudioStreamFlush(SDL_AudioStream stream);

        public static native void SDL_AudioStreamClear(SDL_AudioStream stream);

        public static native void SDL_FreeAudioStream(SDL_AudioStream stream);

        public static native void SDL_MixAudio(Pointer dst, Pointer src, int len, int volume);

        public static native void SDL_MixAudioFormat(Pointer dst, Pointer src, SDL_AudioFormat format, int len, int volume);

        public static native int SDL_QueueAudio(SDL_AudioDeviceID dev, Pointer data, int len);

        public static native int SDL_DequeueAudio(SDL_AudioDeviceID dev, Pointer data, int len);

        public static native int SDL_GetQueuedAudioSize(SDL_AudioDeviceID dev);

        public static native void SDL_ClearQueuedAudio(SDL_AudioDeviceID dev);

        public static native void SDL_LockAudio();

        public static native void SDL_LockAudioDevice(SDL_AudioDeviceID dev);

        public static native void SDL_UnlockAudio();

        public static native void SDL_UnlockAudioDevice(SDL_AudioDeviceID dev);

        public static native void SDL_CloseAudio();

        public static native void SDL_CloseAudioDevice(SDL_AudioDeviceID dev);
    }
}
