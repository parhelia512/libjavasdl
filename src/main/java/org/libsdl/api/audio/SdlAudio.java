package org.libsdl.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;

/**
 * <p>Adapted from SDL_audio.h</p>
 *
 * <p>Access to the raw audio mixing buffer for the SDL library.</p>
 */
public final class SdlAudio {

    static {
        NativeLoader.registerNativeMethods(SdlAudio.class);
    }

    private SdlAudio() {
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

    /**
     * <p>Loads a WAV from a file.</p>
     *
     * <p>Compatibility convenience function.</p>
     */
    public static SDL_AudioSpec SDL_LoadWAV(String file, SDL_AudioSpec spec, Pointer audio_buf, IntByReference audio_len) {
        return SDL_LoadWAV_RW(SDL_RWFromFile(file, "rb"), 1, spec, audio_buf, audio_len);
    }

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
