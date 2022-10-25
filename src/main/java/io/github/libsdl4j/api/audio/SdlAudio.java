package io.github.libsdl4j.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.rwops.SDL_RWops;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.StringRef;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.rwops.SdlRWops.SDL_RWFromFile;

/**
 * Definitions from file SDL_audio.h
 *
 * <p>Access to the raw audio mixing buffer for the SDL library.</p>
 */
public final class SdlAudio {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlAudio.class);
    }

    private SdlAudio() {
    }

    /**
     * Use this function to get the number of built-in audio drivers.
     *
     * <p>This function returns a hardcoded number. This never returns a negative
     * value; if there are no drivers compiled into this build of SDL, this
     * function returns zero. The presence of a driver in this list does not mean
     * it will function, it just means SDL is capable of interacting with that
     * interface. For example, a build of SDL might have esound support, but if
     * there's no esound server available, SDL's esound driver would fail if used.</p>
     *
     * <p>By default, SDL tries all drivers, in its preferred order, until one is
     * found to be usable.</p>
     *
     * @return the number of built-in audio drivers.
     * @see #SDL_GetAudioDriver(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumAudioDrivers();

    /**
     * Use this function to get the name of a built in audio driver.
     *
     * <p>The list of audio drivers is given in the order that they are normally
     * initialized by default; the drivers that seem more reasonable to choose
     * first (as far as the SDL developers believe) are earlier in the list.</p>
     *
     * <p>The names of drivers are all simple, low-ASCII identifiers, like "alsa",
     * "coreaudio" or "xaudio2". These never have Unicode characters, and are not
     * meant to be proper names.</p>
     *
     * @param index the index of the audio driver; the value ranges from 0 to
     *              SDL_GetNumAudioDrivers() - 1
     * @return the name of the audio driver at the requested index, or NULL if an
     * invalid index was specified.
     * @see #SDL_GetNumAudioDrivers()
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetAudioDriver(
            int index);

    /**
     * Use this function to initialize a particular audio driver.
     *
     * <p>This function is used internally, and should not be used unless you have a
     * specific need to designate the audio driver you want to use. You should
     * normally use SDL_Init() or SDL_InitSubSystem().</p>
     *
     * @param driverName the name of the desired audio driver
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_AudioQuit()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_AudioInit(
            String driverName);

    /**
     * Use this function to shut down audio if you initialized it with
     * SDL_AudioInit().
     *
     * <p>This function is used internally, and should not be used unless you have a
     * specific need to specify the audio driver you want to use. You should
     * normally use SDL_Quit() or SDL_QuitSubSystem().</p>
     *
     * @see #SDL_AudioInit(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_AudioQuit();

    /**
     * Get the name of the current audio driver.
     *
     * <p>The returned string points to internal static memory and thus never becomes
     * invalid, even if you quit the audio subsystem and initialize a new driver
     * (although such a case would return a different static string from another
     * call to this function, of course). As such, you should not modify or free
     * the returned string.</p>
     *
     * @return the name of the current audio driver or NULL if no driver has been
     * initialized.
     * @see #SDL_AudioInit(String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetCurrentAudioDriver();

    /**
     * This function is a legacy means of opening the audio device.
     *
     * <p>This function remains for compatibility with SDL 1.2, but also because it's
     * slightly easier to use than the new functions in SDL 2.0. The new, more
     * powerful, and preferred way to do this is SDL_OpenAudioDevice().</p>
     *
     * <p>This function is roughly equivalent to:</p>
     *
     * <pre>
     * SDL_OpenAudioDevice(NULL, 0, desired, obtained, SDL_AUDIO_ALLOW_ANY_CHANGE);
     * </pre>
     *
     * <p>With two notable exceptions:</p>
     *
     * - If {@code obtained} is NULL, we use {@code desired} (and allow no changes), which
     * means desired will be modified to have the correct values for silence,
     * etc, and SDL will convert any differences between your app's specific
     * request and the hardware behind the scenes.
     * - The return value is always success or failure, and not a device ID, which
     * means you can only have one device open at a time with this function.
     *
     * @param desired  an SDL_AudioSpec structure representing the desired output
     *                 format. Please refer to the SDL_OpenAudioDevice
     *                 documentation for details on how to prepare this structure.
     * @param obtained an SDL_AudioSpec structure filled in with the actual
     *                 parameters, or NULL.
     * @return 0 if successful, placing the actual hardware parameters in the
     * structure pointed to by {@code obtained}.
     *
     * <p>If {@code obtained} is NULL, the audio data passed to the callback
     * function will be guaranteed to be in the requested format, and
     * will be automatically converted to the actual hardware audio
     * format if necessary. If {@code obtained} is NULL, {@code desired} will have
     * fields modified.</p>
     *
     * <p>This function returns a negative error code on failure to open the
     * audio device or failure to set up the audio thread; call
     * SDL_GetError() for more information.</p>
     * @see #SDL_CloseAudio()
     * @see #SDL_LockAudio()
     * @see #SDL_PauseAudio(int)
     * @see #SDL_UnlockAudio()
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_OpenAudio(
            SDL_AudioSpec desired,
            SDL_AudioSpec obtained);

    /**
     * Get the number of built-in audio devices.
     *
     * <p>This function is only valid after successfully initializing the audio
     * subsystem.</p>
     *
     * <p>Note that audio capture support is not implemented as of SDL 2.0.4, so the
     * {@code iscapture} parameter is for future expansion and should always be zero for
     * now.</p>
     *
     * <p>This function will return -1 if an explicit list of devices can't be
     * determined. Returning -1 is not an error. For example, if SDL is set up to
     * talk to a remote audio server, it can't list every one available on the
     * Internet, but it will still allow a specific host to be specified in
     * SDL_OpenAudioDevice().</p>
     *
     * <p>In many common cases, when this function returns a value 0 or less, it can still
     * successfully open the default device (NULL for first argument of
     * SDL_OpenAudioDevice()).</p>
     *
     * <p>This function may trigger a complete redetect of available hardware. It
     * should not be called for each iteration of a loop, but rather once at the
     * start of a loop:</p>
     *
     * <pre>
     * // Don't do this:
     * for (int i = 0; i &lt; SDL_GetNumAudioDevices(0); i++)
     *
     * // Do this instead:
     * int count = SDL_GetNumAudioDevices(0);
     * for (int i = 0; i &lt; count; ++i) { do_something_here(); }
     * </pre>
     *
     * @param iscapture zero to request playback devices, non-zero to request
     *                  recording devices
     * @return the number of available devices exposed by the current driver or
     * -1 if an explicit list of devices can't be determined. A return
     * value of -1 does not necessarily mean an error condition.
     * @see #SDL_GetAudioDeviceName(int, int)
     * @see #SDL_OpenAudioDevice(String, int, SDL_AudioSpec, SDL_AudioSpec, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetNumAudioDevices(
            int iscapture);

    /**
     * Get the human-readable name of a specific audio device.
     *
     * <p>This function is only valid after successfully initializing the audio
     * subsystem. The values returned by this function reflect the latest call to
     * SDL_GetNumAudioDevices(); re-call that function to redetect available
     * hardware.</p>
     *
     * <p>The string returned by this function is UTF-8 encoded, read-only, and
     * managed internally. You are not to free it. If you need to keep the string
     * for any length of time, you should make your own copy of it, as it will be
     * invalid next time any of several other SDL functions are called.</p>
     *
     * @param index     the index of the audio device; valid values range from 0 to
     *                  SDL_GetNumAudioDevices() - 1
     * @param iscapture non-zero to query the list of recording devices, zero to
     *                  query the list of output devices.
     * @return the name of the audio device at the requested index, or NULL on
     * error.
     * @see #SDL_GetNumAudioDevices(int)
     * @see #SDL_GetDefaultAudioInfo(StringRef, SDL_AudioSpec, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetAudioDeviceName(
            int index,
            int iscapture);

    /**
     * Get the preferred audio format of a specific audio device.
     *
     * <p>This function is only valid after a successfully initializing the audio
     * subsystem. The values returned by this function reflect the latest call to
     * SDL_GetNumAudioDevices(); re-call that function to redetect available
     * hardware.</p>
     *
     * <p>{@code spec} will be filled with the sample rate, sample format, and channel
     * count.</p>
     *
     * @param index     the index of the audio device; valid values range from 0 to
     *                  SDL_GetNumAudioDevices() - 1
     * @param iscapture non-zero to query the list of recording devices, zero to
     *                  query the list of output devices.
     * @param spec      The SDL_AudioSpec to be initialized by this function.
     * @return 0 on success, nonzero on error
     * @see #SDL_GetNumAudioDevices(int)
     * @see #SDL_GetDefaultAudioInfo(StringRef, SDL_AudioSpec, int)
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_GetAudioDeviceSpec(
            int index,
            int iscapture,
            SDL_AudioSpec spec);

    /**
     * Get the name and preferred format of the default audio device.
     *
     * <p>Some (but not all!) platforms have an isolated mechanism to get information
     * about the "default" device. This can actually be a completely different
     * device that's not in the list you get from SDL_GetAudioDeviceSpec(). It can
     * even be a network address! (This is discussed in SDL_OpenAudioDevice().)</p>
     *
     * <p>As a result, this call is not guaranteed to be performant, as it can query
     * the sound server directly every time, unlike the other query functions. You
     * should call this function sparingly!</p>
     *
     * <p>{@code spec} will be filled with the sample rate, sample format, and channel
     * count, if a default device exists on the system. If {@code name} is provided,
     * will be filled with either a dynamically-allocated UTF-8 string or null.</p>
     *
     * @param name      A StringRef to be filled with the name of the default device.
     * @param spec      The SDL_AudioSpec to be initialized by this function.
     * @param iscapture non-zero to query the default recording device, zero to
     *                  query the default output device.
     * @return 0 on success, nonzero on error
     * @see #SDL_GetAudioDeviceName(int, int)
     * @see #SDL_GetAudioDeviceSpec(int, int, SDL_AudioSpec)
     * @see #SDL_OpenAudioDevice(String, int, SDL_AudioSpec, SDL_AudioSpec, int)
     * @since This function is available since SDL 2.24.0.
     */
    public static int SDL_GetDefaultAudioInfo(
            StringRef name,
            SDL_AudioSpec spec,
            int iscapture) {
        PointerByReference namePointer = new PointerByReference();
        int result = InternalNativeFunctions.SDL_GetDefaultAudioInfo(namePointer, spec, iscapture);
        if (Pointer.nativeValue(namePointer.getValue()) == 0L) {
            return result;
        }
        String nameString = JnaUtils.extractStringAndReleaseNativeSdlMemory(namePointer.getValue());
        name.setValue(nameString);
        return result;
    }

    /**
     * Open a specific audio device.
     *
     * <p>SDL_OpenAudio(), unlike this function, always acts on device ID 1. As such,
     * this function will never return a 1 so as not to conflict with the legacy
     * function.</p>
     *
     * <p>Please note that SDL 2.0 before 2.0.5 did not support recording; as such,
     * this function would fail if {@code iscapture} was not zero. Starting with SDL
     * 2.0.5, recording is implemented and this value can be non-zero.</p>
     *
     * <p>Passing in a {@code device} name of NULL requests the most reasonable default
     * (and is equivalent to what SDL_OpenAudio() does to choose a device). The
     * {@code device} name is a UTF-8 string reported by SDL_GetAudioDeviceName(), but
     * some drivers allow arbitrary and driver-specific strings, such as a
     * hostname/IP address for a remote audio server, or a filename in the
     * diskaudio driver.</p>
     *
     * <p>An opened audio device starts out paused, and should be enabled for playing
     * by calling SDL_PauseAudioDevice(devid, 0) when you are ready for your audio
     * callback function to be called. Since the audio driver may modify the
     * requested size of the audio buffer, you should allocate any local mixing
     * buffers after you open the audio device.</p>
     *
     * <p>The audio callback runs in a separate thread in most cases; you can prevent
     * race conditions between your callback and other threads without fully
     * pausing playback with SDL_LockAudioDevice(). For more information about the
     * callback, see SDL_AudioSpec.</p>
     *
     * <p>Managing the audio spec via 'desired' and 'obtained':</p>
     *
     * <p>When filling in the desired audio spec structure:</p>
     *
     * - {@code desired->freq} should be the frequency in sample-frames-per-second (Hz).
     * - {@code desired->format} should be the audio format ({@code AUDIO_S16SYS}, etc).
     * - {@code desired->samples} is the desired size of the audio buffer, in _sample
     * frames_ (with stereo output, two samples--left and right--would make a
     * single sample frame). This number should be a power of two, and may be
     * adjusted by the audio driver to a value more suitable for the hardware.
     * Good values seem to range between 512 and 8096 inclusive, depending on
     * the application and CPU speed. Smaller values reduce latency, but can
     * lead to underflow if the application is doing heavy processing and cannot
     * fill the audio buffer in time. Note that the number of sample frames is
     * directly related to time by the following formula: `ms =
     * (sampleframes*1000)/freq`
     * - {@code desired->size} is the size in _bytes_ of the audio buffer, and is
     * calculated by SDL_OpenAudioDevice(). You don't initialize this.
     * - {@code desired->silence} is the value used to set the buffer to silence, and is
     * calculated by SDL_OpenAudioDevice(). You don't initialize this.
     * - {@code desired->callback} should be set to a function that will be called when
     * the audio device is ready for more data. It is passed a pointer to the
     * audio buffer, and the length in bytes of the audio buffer. This function
     * usually runs in a separate thread, and so you should protect data
     * structures that it accesses by calling SDL_LockAudioDevice() and
     * SDL_UnlockAudioDevice() in your code. Alternately, you may pass a NULL
     * pointer here, and call SDL_QueueAudio() with some frequency, to queue
     * more audio samples to be played (or for capture devices, call
     * SDL_DequeueAudio() with some frequency, to obtain audio samples).
     * - {@code desired->userdata} is passed as the first parameter to your callback
     * function. If you passed a NULL callback, this value is ignored.
     *
     * <p>{@code allowed_changes} can have the following flags OR'd together:</p>
     *
     * - {@code SDL_AUDIO_ALLOW_FREQUENCY_CHANGE}
     * - {@code SDL_AUDIO_ALLOW_FORMAT_CHANGE}
     * - {@code SDL_AUDIO_ALLOW_CHANNELS_CHANGE}
     * - {@code SDL_AUDIO_ALLOW_SAMPLES_CHANGE}
     * - {@code SDL_AUDIO_ALLOW_ANY_CHANGE}
     *
     * <p>These flags specify how SDL should behave when a device cannot offer a
     * specific feature. If the application requests a feature that the hardware
     * doesn't offer, SDL will always try to get the closest equivalent.</p>
     *
     * <p>For example, if you ask for float32 audio format, but the sound card only
     * supports int16, SDL will set the hardware to int16. If you had set
     * SDL_AUDIO_ALLOW_FORMAT_CHANGE, SDL will change the format in the {@code obtained}
     * structure. If that flag was *not* set, SDL will prepare to convert your
     * callback's float32 audio to int16 before feeding it to the hardware and
     * will keep the originally requested format in the {@code obtained} structure.</p>
     *
     * <p>The resulting audio specs, varying depending on hardware and on what
     * changes were allowed, will then be written back to {@code obtained}.</p>
     *
     * <p>If your application can only handle one specific data format, pass a zero
     * for {@code allowed_changes} and let SDL transparently handle any differences.</p>
     *
     * @param device         a UTF-8 string reported by SDL_GetAudioDeviceName() or a
     *                       driver-specific name as appropriate. NULL requests the most
     *                       reasonable default device.
     * @param iscapture      non-zero to specify a device should be opened for
     *                       recording, not playback
     * @param desired        an SDL_AudioSpec structure representing the desired output
     *                       format; see SDL_OpenAudio() for more information
     * @param obtained       an SDL_AudioSpec structure filled in with the actual output
     *                       format; see SDL_OpenAudio() for more information
     * @param allowedChanges 0, or one or more flags OR'd together
     * @return a valid device ID that is greater than 0 on success or 0 on failure; call
     * SDL_GetError() for more information.
     *
     * <p>For compatibility with SDL 1.2, this will never return 1, since
     * SDL reserves that ID for the legacy SDL_OpenAudio() function.</p>
     * @see #SDL_CloseAudioDevice(SDL_AudioDeviceID)
     * @see #SDL_GetAudioDeviceName(int, int)
     * @see #SDL_LockAudioDevice(SDL_AudioDeviceID)
     * @see #SDL_OpenAudio(SDL_AudioSpec, SDL_AudioSpec)
     * @see #SDL_PauseAudioDevice(SDL_AudioDeviceID, int)
     * @see #SDL_UnlockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_AudioDeviceID SDL_OpenAudioDevice(
            String device,
            int iscapture,
            SDL_AudioSpec desired,
            SDL_AudioSpec obtained,
            int allowedChanges);

    /**
     * This function is a legacy means of querying the audio device.
     *
     * <p>New programs might want to use SDL_GetAudioDeviceStatus() instead. This
     * function is equivalent to calling...</p>
     *
     * <pre>
     * SDL_GetAudioDeviceStatus(1);
     * </pre>
     *
     * <p>...and is only useful if you used the legacy SDL_OpenAudio() function.</p>
     *
     * @return the SDL_AudioStatus of the audio device opened by SDL_OpenAudio().
     * @see #SDL_GetAudioDeviceStatus(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_AudioStatus.class)
    public static native int SDL_GetAudioStatus();

    /**
     * Use this function to get the current audio state of an audio device.
     *
     * @param dev the ID of an audio device previously opened with
     *            SDL_OpenAudioDevice()
     * @return the SDL_AudioStatus of the specified audio device.
     * @see #SDL_PauseAudioDevice(SDL_AudioDeviceID, int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_AudioStatus.class)
    public static native int SDL_GetAudioDeviceStatus(
            SDL_AudioDeviceID dev);

    /**
     * This function is a legacy means of pausing the audio device.
     *
     * <p>New programs might want to use SDL_PauseAudioDevice() instead. This
     * function is equivalent to calling...</p>
     *
     * <pre>
     * SDL_PauseAudioDevice(1, pauseOn);
     * </pre>
     *
     * <p>...and is only useful if you used the legacy SDL_OpenAudio() function.</p>
     *
     * @param pauseOn non-zero to pause, 0 to unpause
     * @see #SDL_GetAudioStatus()
     * @see #SDL_PauseAudioDevice(SDL_AudioDeviceID, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_PauseAudio(
            int pauseOn);

    /**
     * Use this function to pause and unpause audio playback on a specified
     * device.
     *
     * <p>This function pauses and unpauses the audio callback processing for a given
     * device. Newly-opened audio devices start in the paused state, so you must
     * call this function with **pause_on**=0 after opening the specified audio
     * device to start playing sound. This allows you to safely initialize data
     * for your callback function after opening the audio device. Silence will be
     * written to the audio device while paused, and the audio callback is
     * guaranteed to not be called. Pausing one device does not prevent other
     * unpaused devices from running their callbacks.</p>
     *
     * <p>Pausing state does not stack; even if you pause a device several times, a
     * single unpause will start the device playing again, and vice versa. This is
     * different from how SDL_LockAudioDevice() works.</p>
     *
     * <p>If you just need to protect a few variables from race conditions vs your
     * callback, you shouldn't pause the audio device, as it will lead to dropouts
     * in the audio playback. Instead, you should use SDL_LockAudioDevice().</p>
     *
     * @param dev     a device opened by SDL_OpenAudioDevice()
     * @param pauseOn non-zero to pause, 0 to unpause
     * @see #SDL_LockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_PauseAudioDevice(
            SDL_AudioDeviceID dev,
            int pauseOn);

    /**
     * Load the audio data of a WAVE file into memory.
     *
     * <p>Loading a WAVE file requires {@code src}, {@code spec}, {@code audio_buf} and {@code audio_len} to
     * be valid pointers. The entire data portion of the file is then loaded into
     * memory and decoded if necessary.</p>
     *
     * <p>If {@code freesrc} is non-zero, the data source gets automatically closed and
     * freed before the function returns.</p>
     *
     * <p>Supported formats are RIFF WAVE files with the formats PCM (8, 16, 24, and
     * 32 bits), IEEE Float (32 bits), Microsoft ADPCM and IMA ADPCM (4 bits), and
     * A-law and mu-law (8 bits). Other formats are currently unsupported and
     * cause an error.</p>
     *
     * <p>If this function succeeds, the pointer returned by it is equal to {@code spec}
     * and the pointer to the audio data allocated by the function is written to
     * {@code audio_buf} and its length in bytes to {@code audio_len}. The SDL_AudioSpec
     * members {@code freq}, {@code channels}, and {@code format} are set to the values of the audio
     * data in the buffer. The {@code samples} member is set to a sane default and all
     * others are set to zero.</p>
     *
     * <p>It's necessary to use SDL_FreeWAV() to free the audio data returned in
     * {@code audio_buf} when it is no longer used.</p>
     *
     * <p>Because of the underspecification of the .WAV format, there are many
     * problematic files in the wild that cause issues with strict decoders. To
     * provide compatibility with these files, this decoder is lenient in regards
     * to the truncation of the file, the fact chunk, and the size of the RIFF
     * chunk. The hints {@code SDL_HINT_WAVE_RIFF_CHUNK_SIZE},
     * {@code SDL_HINT_WAVE_TRUNCATION}, and {@code SDL_HINT_WAVE_FACT_CHUNK} can be used to
     * tune the behavior of the loading process.</p>
     *
     * <p>Any file that is invalid (due to truncation, corruption, or wrong values in
     * the headers), too big, or unsupported causes an error. Additionally, any
     * critical I/O error from the data source will terminate the loading process
     * with an error. The function returns NULL on error and in all cases (with
     * the exception of {@code src} being NULL), an appropriate error message will be
     * set.</p>
     *
     * <p>It is required that the data source supports seeking.</p>
     *
     * <p>Example:</p>
     *
     * <pre>
     * SDL_LoadWAV_RW(SDL_RWFromFile("sample.wav", "rb"), 1, spec, buf, len);
     * </pre>
     *
     * <p>Note that the SDL_LoadWAV macro does this same thing for you, but in a less
     * messy way:</p>
     *
     * <pre>
     * SDL_LoadWAV("sample.wav", spec, buf, len);
     * </pre>
     *
     * @param src      The data source for the WAVE data
     * @param freesrc  If non-zero, SDL will _always_ free the data source
     * @param spec     An SDL_AudioSpec that will be filled in with the wave file's
     *                 format details
     * @param audioBuf A pointer filled with the audio data, allocated by the
     *                 function.
     * @param audioLen A pointer filled with the length of the audio data buffer
     *                 in bytes
     * @return This function, if successfully called, returns {@code spec}, which will
     * be filled with the audio data format of the wave source data.
     * {@code audio_buf} will be filled with a pointer to an allocated buffer
     * containing the audio data, and {@code audio_len} is filled with the
     * length of that audio buffer in bytes.
     *
     * <p>This function returns NULL if the .WAV file cannot be opened, uses
     * an unknown data format, or is corrupt; call SDL_GetError() for
     * more information.</p>
     *
     * <p>When the application is done with the data returned in
     * {@code audio_buf}, it should call SDL_FreeWAV() to dispose of it.</p>
     * @see #SDL_FreeWAV(Pointer)
     * @see #SDL_LoadWAV(String, SDL_AudioSpec, PointerByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    // TODO: Test
    public static native SDL_AudioSpec SDL_LoadWAV_RW(
            SDL_RWops src,
            int freesrc,
            SDL_AudioSpec spec,
            PointerByReference audioBuf,
            IntByReference audioLen);

    /**
     * Loads a WAV from a file.
     *
     * <p>Compatibility convenience function.</p>
     */
    public static SDL_AudioSpec SDL_LoadWAV(
            String file,
            SDL_AudioSpec spec,
            PointerByReference audioBuf,
            IntByReference audioLen) {
        return SDL_LoadWAV_RW(SDL_RWFromFile(file, "rb"), 1, spec, audioBuf, audioLen);
    }

    /**
     * Free data previously allocated with SDL_LoadWAV() or SDL_LoadWAV_RW().
     *
     * <p>After a WAVE file has been opened with SDL_LoadWAV() or SDL_LoadWAV_RW()
     * its data can eventually be freed with SDL_FreeWAV(). It is safe to call
     * this function with a NULL pointer.</p>
     *
     * @param audioBuf a pointer to the buffer created by SDL_LoadWAV() or
     *                 SDL_LoadWAV_RW()
     * @see #SDL_LoadWAV(String, SDL_AudioSpec, PointerByReference, IntByReference)
     * @see #SDL_LoadWAV_RW(SDL_RWops, int, SDL_AudioSpec, PointerByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreeWAV(
            Pointer audioBuf);

    /**
     * Initialize an SDL_AudioCVT structure for conversion.
     *
     * <p>Before an SDL_AudioCVT structure can be used to convert audio data it must
     * be initialized with source and destination information.</p>
     *
     * <p>This function will zero out every field of the SDL_AudioCVT, so it must be
     * called before the application fills in the final buffer information.</p>
     *
     * <p>Once this function has returned successfully, and reported that a
     * conversion is necessary, the application fills in the rest of the fields in
     * SDL_AudioCVT, now that it knows how large a buffer it needs to allocate,
     * and then can call SDL_ConvertAudio() to complete the conversion.</p>
     *
     * @param cvt         an SDL_AudioCVT structure filled in with audio conversion
     *                    information
     * @param srcFormat   the source format of the audio data; for more info see
     *                    SDL_AudioFormat
     * @param srcChannels the number of channels in the source
     * @param srcRate     the frequency (sample-frames-per-second) of the source
     * @param dstFormat   the destination format of the audio data; for more info
     *                    see SDL_AudioFormat
     * @param dstChannels the number of channels in the destination
     * @param dstRate     the frequency (sample-frames-per-second) of the destination
     * @return 1 if the audio filter is prepared, 0 if no conversion is needed,
     * or a negative error code on failure; call SDL_GetError() for more
     * information.
     * @see #SDL_ConvertAudio(SDL_AudioCVT)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_BuildAudioCVT(
            SDL_AudioCVT cvt,
            SDL_AudioFormat srcFormat,
            byte srcChannels,
            int srcRate,
            SDL_AudioFormat dstFormat,
            byte dstChannels,
            int dstRate);

    /**
     * Convert audio data to a desired audio format.
     *
     * <p>This function does the actual audio data conversion, after the application
     * has called SDL_BuildAudioCVT() to prepare the conversion information and
     * then filled in the buffer details.</p>
     *
     * <p>Once the application has initialized the {@code cvt} structure using
     * SDL_BuildAudioCVT(), allocated an audio buffer and filled it with audio
     * data in the source format, this function will convert the buffer, in-place,
     * to the desired format.</p>
     *
     * <p>The data conversion may go through several passes; any given pass may
     * possibly temporarily increase the size of the data. For example, SDL might
     * expand 16-bit data to 32 bits before resampling to a lower frequency,
     * shrinking the data size after having grown it briefly. Since the supplied
     * buffer will be both the source and destination, converting as necessary
     * in-place, the application must allocate a buffer that will fully contain
     * the data during its largest conversion pass. After SDL_BuildAudioCVT()
     * returns, the application should set the {@code cvt.len} field to the size, in
     * bytes, of the source data, and allocate a buffer that is {@code cvt.len *
     * cvt.len_mult}  bytes long for the {@code buf} field.</p>
     *
     * <p>The source data should be copied into this buffer before the call to
     * SDL_ConvertAudio(). Upon successful return, this buffer will contain the
     * converted audio, and {@code cvt.len_cvt} will be the size of the converted data,
     * in bytes. Any bytes in the buffer past {@code cvt.len_cvt} are undefined once
     * this function returns.</p>
     *
     * @param cvt an SDL_AudioCVT structure that was previously set up by
     *            SDL_BuildAudioCVT().
     * @return 0 if the conversion was completed successfully or a negative error
     * code on failure; call SDL_GetError() for more information.
     * @see #SDL_BuildAudioCVT(SDL_AudioCVT, SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ConvertAudio(
            SDL_AudioCVT cvt);

    /**
     * Create a new audio stream.
     *
     * @param srcFormat   The format of the source audio
     * @param srcChannels The number of channels of the source audio
     * @param srcRate     The sampling rate of the source audio
     * @param dstFormat   The format of the desired audio output
     * @param dstChannels The number of channels of the desired audio output
     * @param dstRate     The sampling rate of the desired audio output
     * @return 0 on success, or -1 on error.
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamFlush(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native SDL_AudioStream SDL_NewAudioStream(
            SDL_AudioFormat srcFormat,
            byte srcChannels,
            int srcRate,
            SDL_AudioFormat dstFormat,
            byte dstChannels,
            int dstRate);

    /**
     * Add data to be converted/resampled to the stream.
     *
     * @param stream The stream the audio data is being added to
     * @param buf    A pointer to the audio data to add
     * @param len    The number of bytes to write to the stream
     * @return 0 on success, or -1 on error.
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamFlush(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_AudioStreamPut(
            SDL_AudioStream stream,
            Pointer buf,
            int len);

    /**
     * Get converted/resampled data from the stream
     *
     * @param stream The stream the audio is being requested from
     * @param buf    A buffer to fill with audio data
     * @param len    The maximum number of bytes to fill
     * @return the number of bytes read from the stream, or -1 on error
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamFlush(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_AudioStreamGet(
            SDL_AudioStream stream,
            Pointer buf,
            int len);

    /**
     * Get the number of converted/resampled bytes available.
     *
     * <p>The stream may be buffering data behind the scenes until it has enough to
     * resample correctly, so this number might be lower than what you expect, or
     * even be zero. Add more data or flush the stream if you need the data now.</p>
     *
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamFlush(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_AudioStreamAvailable(
            SDL_AudioStream stream);

    /**
     * Tell the stream that you're done sending data, and anything being buffered
     * should be converted/resampled and made available immediately.
     *
     * <p>It is legal to add more data to a stream after flushing, but there will be
     * audio gaps in the output. Generally this is intended to signal the end of
     * input, so the complete output becomes available.</p>
     *
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native int SDL_AudioStreamFlush(
            SDL_AudioStream stream);

    /**
     * Clear any pending data in the stream without converting it
     *
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @see #SDL_FreeAudioStream(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native void SDL_AudioStreamClear(
            SDL_AudioStream stream);

    /**
     * Free an audio stream
     *
     * @see #SDL_NewAudioStream(SDL_AudioFormat, byte, int, SDL_AudioFormat, byte, int)
     * @see #SDL_AudioStreamPut(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamGet(SDL_AudioStream, Pointer, int)
     * @see #SDL_AudioStreamAvailable(SDL_AudioStream)
     * @see #SDL_AudioStreamFlush(SDL_AudioStream)
     * @see #SDL_AudioStreamClear(SDL_AudioStream)
     * @since This function is available since SDL 2.0.7.
     */
    public static native void SDL_FreeAudioStream(
            SDL_AudioStream stream);

    /**
     * This function is a legacy means of mixing audio.
     *
     * <p>This function is equivalent to calling...</p>
     *
     * <pre>
     * SDL_MixAudioFormat(dst, src, format, len, volume);
     * </pre>
     *
     * <p>...where {@code format} is the obtained format of the audio device from the
     * legacy SDL_OpenAudio() function.</p>
     *
     * @param dst    the destination for the mixed audio
     * @param src    the source audio buffer to be mixed
     * @param len    the length of the audio buffer in bytes
     * @param volume ranges from 0 - 128, and should be set to SDL_MIX_MAXVOLUME
     *               for full audio volume
     * @see #SDL_MixAudioFormat(Pointer, Pointer, SDL_AudioFormat, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_MixAudio(
            Pointer dst,
            Pointer src,
            int len,
            int volume);

    /**
     * Mix audio data in a specified format.
     *
     * <p>This takes an audio buffer {@code src} of {@code len} bytes of {@code format} data and mixes
     * it into {@code dst}, performing addition, volume adjustment, and overflow
     * clipping. The buffer pointed to by {@code dst} must also be {@code len} bytes of
     * {@code format} data.</p>
     *
     * <p>This is provided for convenience -- you can mix your own audio data.</p>
     *
     * <p>Do not use this function for mixing together more than two streams of
     * sample data. The output from repeated application of this function may be
     * distorted by clipping, because there is no accumulator with greater range
     * than the input (not to mention this being an inefficient way of doing it).</p>
     *
     * <p>It is a common misconception that this function is required to write audio
     * data to an output stream in an audio callback. While you can do that,
     * SDL_MixAudioFormat() is really only needed when you're mixing a single
     * audio stream with a volume adjustment.</p>
     *
     * @param dst    the destination for the mixed audio
     * @param src    the source audio buffer to be mixed
     * @param format the SDL_AudioFormat structure representing the desired audio
     *               format
     * @param len    the length of the audio buffer in bytes
     * @param volume ranges from 0 - 128, and should be set to SDL_MIX_MAXVOLUME
     *               for full audio volume
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_MixAudioFormat(
            Pointer dst,
            Pointer src,
            SDL_AudioFormat format,
            int len,
            int volume);

    /**
     * Queue more audio on non-callback devices.
     *
     * <p>If you are looking to retrieve queued audio from a non-callback capture
     * device, you want SDL_DequeueAudio() instead. SDL_QueueAudio() will return
     * -1 to signify an error if you use it with capture devices.</p>
     *
     * <p>SDL offers two ways to feed audio to the device: you can either supply a
     * callback that SDL triggers with some frequency to obtain more audio (pull
     * method), or you can supply no callback, and then SDL will expect you to
     * supply data at regular intervals (push method) with this function.</p>
     *
     * <p>There are no limits on the amount of data you can queue, short of
     * exhaustion of address space. Queued data will drain to the device as
     * necessary without further intervention from you. If the device needs audio
     * but there is not enough queued, it will play silence to make up the
     * difference. This means you will have skips in your audio playback if you
     * aren't routinely queueing sufficient data.</p>
     *
     * <p>This function copies the supplied data, so you are safe to free it when the
     * function returns. This function is thread-safe, but queueing to the same
     * device from two threads at once does not promise which buffer will be
     * queued first.</p>
     *
     * <p>You may not queue audio on a device that is using an application-supplied
     * callback; doing so returns an error. You have to use the audio callback or
     * queue audio with this function, but not both.</p>
     *
     * <p>You should not call SDL_LockAudio() on the device before queueing; SDL
     * handles locking internally for this function.</p>
     *
     * <p>Note that SDL2 does not support planar audio. You will need to resample
     * from planar audio formats into a non-planar one (see SDL_AudioFormat)
     * before queuing audio.</p>
     *
     * @param dev  the device ID to which we will queue audio
     * @param data the data to queue to the device for later playback
     * @param len  the number of bytes (not samples!) to which {@code data} points
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_ClearQueuedAudio(SDL_AudioDeviceID)
     * @see #SDL_GetQueuedAudioSize(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_QueueAudio(
            SDL_AudioDeviceID dev,
            Pointer data,
            int len);

    /**
     * Dequeue more audio on non-callback devices.
     *
     * <p>If you are looking to queue audio for output on a non-callback playback
     * device, you want SDL_QueueAudio() instead. SDL_DequeueAudio() will always
     * return 0 if you use it with playback devices.</p>
     *
     * <p>SDL offers two ways to retrieve audio from a capture device: you can either
     * supply a callback that SDL triggers with some frequency as the device
     * records more audio data, (push method), or you can supply no callback, and
     * then SDL will expect you to retrieve data at regular intervals (pull
     * method) with this function.</p>
     *
     * <p>There are no limits on the amount of data you can queue, short of
     * exhaustion of address space. Data from the device will keep queuing as
     * necessary without further intervention from you. This means you will
     * eventually run out of memory if you aren't routinely dequeueing data.</p>
     *
     * <p>Capture devices will not queue data when paused; if you are expecting to
     * not need captured audio for some length of time, use SDL_PauseAudioDevice()
     * to stop the capture device from queueing more data. This can be useful
     * during, say, level loading times. When unpaused, capture devices will start
     * queueing data from that point, having flushed any capturable data available
     * while paused.</p>
     *
     * <p>This function is thread-safe, but dequeueing from the same device from two
     * threads at once does not promise which thread will dequeue data first.</p>
     *
     * <p>You may not dequeue audio from a device that is using an
     * application-supplied callback; doing so returns an error. You have to use
     * the audio callback, or dequeue audio with this function, but not both.</p>
     *
     * <p>You should not call SDL_LockAudio() on the device before dequeueing; SDL
     * handles locking internally for this function.</p>
     *
     * @param dev  the device ID from which we will dequeue audio
     * @param data a pointer into where audio data should be copied
     * @param len  the number of bytes (not samples!) to which (data) points
     * @return the number of bytes dequeued, which could be less than requested;
     * call SDL_GetError() for more information.
     * @see #SDL_ClearQueuedAudio(SDL_AudioDeviceID)
     * @see #SDL_GetQueuedAudioSize(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.5.
     */
    public static native int SDL_DequeueAudio(
            SDL_AudioDeviceID dev,
            Pointer data,
            int len);

    /**
     * Get the number of bytes of still-queued audio.
     *
     * <p>For playback devices: this is the number of bytes that have been queued for
     * playback with SDL_QueueAudio(), but have not yet been sent to the hardware.</p>
     *
     * <p>Once we've sent it to the hardware, this function can not decide the exact
     * byte boundary of what has been played. It's possible that we just gave the
     * hardware several kilobytes right before you called this function, but it
     * hasn't played any of it yet, or maybe half of it, etc.</p>
     *
     * <p>For capture devices, this is the number of bytes that have been captured by
     * the device and are waiting for you to dequeue. This number may grow at any
     * time, so this only informs of the lower-bound of available data.</p>
     *
     * <p>You may not queue or dequeue audio on a device that is using an
     * application-supplied callback; calling this function on such a device
     * always returns 0. You have to use the audio callback or queue audio, but
     * not both.</p>
     *
     * <p>You should not call SDL_LockAudio() on the device before querying; SDL
     * handles locking internally for this function.</p>
     *
     * @param dev the device ID of which we will query queued audio size
     * @return the number of bytes (not samples!) of queued audio.
     * @see #SDL_ClearQueuedAudio(SDL_AudioDeviceID)
     * @see #SDL_QueueAudio(SDL_AudioDeviceID, Pointer, int)
     * @see #SDL_DequeueAudio(SDL_AudioDeviceID, Pointer, int)
     * @since This function is available since SDL 2.0.4.
     */
    public static native int SDL_GetQueuedAudioSize(
            SDL_AudioDeviceID dev);

    /**
     * Drop any queued audio data waiting to be sent to the hardware.
     *
     * <p>Immediately after this call, SDL_GetQueuedAudioSize() will return 0. For
     * output devices, the hardware will start playing silence if more audio isn't
     * queued. For capture devices, the hardware will start filling the empty
     * queue with new data if the capture device isn't paused.</p>
     *
     * <p>This will not prevent playback of queued audio that's already been sent to
     * the hardware, as we can not undo that, so expect there to be some fraction
     * of a second of audio that might still be heard. This can be useful if you
     * want to, say, drop any pending music or any unprocessed microphone input
     * during a level change in your game.</p>
     *
     * <p>You may not queue or dequeue audio on a device that is using an
     * application-supplied callback; calling this function on such a device
     * always returns 0. You have to use the audio callback or queue audio, but
     * not both.</p>
     *
     * <p>You should not call SDL_LockAudio() on the device before clearing the
     * queue; SDL handles locking internally for this function.</p>
     *
     * <p>This function always succeeds and thus returns void.</p>
     *
     * @param dev the device ID of which to clear the audio queue
     * @see #SDL_GetQueuedAudioSize(SDL_AudioDeviceID)
     * @see #SDL_QueueAudio(SDL_AudioDeviceID, Pointer, int)
     * @see #SDL_DequeueAudio(SDL_AudioDeviceID, Pointer, int)
     * @since This function is available since SDL 2.0.4.
     */
    public static native void SDL_ClearQueuedAudio(
            SDL_AudioDeviceID dev);

    /**
     * This function is a legacy means of locking the audio device.
     *
     * <p>New programs might want to use SDL_LockAudioDevice() instead. This function
     * is equivalent to calling...</p>
     *
     * <pre>
     * SDL_LockAudioDevice(1);
     * </pre>
     *
     * <p>...and is only useful if you used the legacy SDL_OpenAudio() function.</p>
     *
     * @see #SDL_LockAudioDevice(SDL_AudioDeviceID)
     * @see #SDL_UnlockAudio()
     * @see #SDL_UnlockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_LockAudio();

    /**
     * Use this function to lock out the audio callback function for a specified
     * device.
     *
     * <p>The lock manipulated by these functions protects the audio callback
     * function specified in SDL_OpenAudioDevice(). During a
     * SDL_LockAudioDevice()/SDL_UnlockAudioDevice() pair, you can be guaranteed
     * that the callback function for that device is not running, even if the
     * device is not paused. While a device is locked, any other unpaused,
     * unlocked devices may still run their callbacks.</p>
     *
     * <p>Calling this function from inside your audio callback is unnecessary. SDL
     * obtains this lock before calling your function, and releases it when the
     * function returns.</p>
     *
     * <p>You should not hold the lock longer than absolutely necessary. If you hold
     * it too long, you'll experience dropouts in your audio playback. Ideally,
     * your application locks the device, sets a few variables and unlocks again.
     * Do not do heavy work while holding the lock for a device.</p>
     *
     * <p>It is safe to lock the audio device multiple times, as long as you unlock
     * it an equivalent number of times. The callback will not run until the
     * device has been unlocked completely in this way. If your application fails
     * to unlock the device appropriately, your callback will never run, you might
     * hear repeating bursts of audio, and SDL_CloseAudioDevice() will probably
     * deadlock.</p>
     *
     * <p>Internally, the audio device lock is a mutex; if you lock from two threads
     * at once, not only will you block the audio callback, you'll block the other
     * thread.</p>
     *
     * @param dev the ID of the device to be locked
     * @see #SDL_UnlockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_LockAudioDevice(
            SDL_AudioDeviceID dev);

    /**
     * This function is a legacy means of unlocking the audio device.
     *
     * <p>New programs might want to use SDL_UnlockAudioDevice() instead. This
     * function is equivalent to calling...</p>
     *
     * <pre>
     * SDL_UnlockAudioDevice(1);
     * </pre>
     *
     * <p>...and is only useful if you used the legacy SDL_OpenAudio() function.</p>
     *
     * @see #SDL_LockAudio()
     * @see #SDL_UnlockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_UnlockAudio();

    /**
     * Use this function to unlock the audio callback function for a specified
     * device.
     *
     * <p>This function should be paired with a previous SDL_LockAudioDevice() call.</p>
     *
     * @param dev the ID of the device to be unlocked
     * @see #SDL_LockAudioDevice(SDL_AudioDeviceID)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_UnlockAudioDevice(
            SDL_AudioDeviceID dev);

    /**
     * This function is a legacy means of closing the audio device.
     *
     * <p>This function is equivalent to calling...</p>
     *
     * <pre>
     * SDL_CloseAudioDevice(1);
     * </pre>
     *
     * <p>...and is only useful if you used the legacy SDL_OpenAudio() function.</p>
     *
     * @see #SDL_OpenAudio(SDL_AudioSpec, SDL_AudioSpec)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_CloseAudio();

    /**
     * Use this function to shut down audio processing and close the audio device.
     *
     * <p>The application should close open audio devices once they are no longer
     * needed. Calling this function will wait until the device's audio callback
     * is not running, release the audio hardware and then clean up internal
     * state. No further audio will play from this device once this function
     * returns.</p>
     *
     * <p>This function may block briefly while pending audio data is played by the
     * hardware, so that applications don't drop the last buffer of data they
     * supplied.</p>
     *
     * <p>The device ID is invalid as soon as the device is closed, and is eligible
     * for reuse in a new SDL_OpenAudioDevice() call immediately.</p>
     *
     * @param dev an audio device previously opened with SDL_OpenAudioDevice()
     * @see #SDL_OpenAudioDevice(String, int, SDL_AudioSpec, SDL_AudioSpec, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_CloseAudioDevice(
            SDL_AudioDeviceID dev);

    private static final class InternalNativeFunctions {

        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native int SDL_GetDefaultAudioInfo(
                PointerByReference name,
                SDL_AudioSpec spec,
                int iscapture);
    }
}
