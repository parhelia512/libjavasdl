package io.github.libsdl4j.api.error;

import java.util.Locale;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

/**
 * Definitions from file SDL_error.h
 *
 * <p>Simple error message routines for SDL.</p>
 */
public final class SdlError {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlError.class);
    }

    private SdlError() {
    }

    /**
     * Set the SDL error message for the current thread.
     *
     * <p>Calling this function will replace any previous error message that was set.</p>
     *
     * <p>In general, this functions is here just in case you wanted to inject
     * an error message to the regular SDL error processing pipeline.
     * Normally, it should not be used. Java's Exceptions should be used instead.</p>
     *
     * <p>The {@code fmt} argument is a String with format compatible with Java-style {@code printf()}
     * (more precisely {@link java.util.Formatter}, {@code String.format()} or {@code System.out.printf()}).
     * Note that it is very similar to the original C-style {@code printf()} but has some differences.
     * The formatting is performed in Java prior to the actual SDL call and only pure strings are passed to the SDL library.</p>
     *
     * <p>Locale used for formatting is the default system locale.</p>
     *
     * <p>This function always returns -1, since SDL frequently uses -1 to signify an
     * failing result. However this is of a very limited use in Java, as it uses Exceptions to report errors.</p>
     *
     * @param fmt  a Java-style printf() message format string
     * @param args additional parameters matching {@code %} tokens in the {@code fmt} string, if
     *             any
     * @return always -1.
     * @see #SDL_ClearError()
     * @see #SDL_GetError()
     */
    public static int SDL_SetError(
            String fmt,
            Object... args) {
        return SDL_SetError(Locale.getDefault(), fmt, args);
    }

    /**
     * Set the SDL error message for the current thread.
     *
     * <p>Calling this function will replace any previous error message that was set.</p>
     *
     * <p>In general, this functions is here just in case you wanted to inject
     * an error message to the regular SDL error processing pipeline.
     * Normally, it should not be used. Java's Exceptions should be used instead.</p>
     *
     * <p>The {@code fmt} argument is a String with format compatible with Java-style {@code printf()}
     * (more precisely {@link java.util.Formatter}, {@code String.format()} or {@code System.out.printf()}).
     * Note that it is very similar to the original C-style {@code printf()} but has some differences.
     * The formatting is performed in Java prior to the actual SDL call and only pure strings are passed to the SDL library.</p>
     *
     * <p>This function always returns -1, since SDL frequently uses -1 to signify an
     * failing result. However this is of a very limited use in Java, as it uses Exceptions to report errors.</p>
     *
     * @param lang a {@code java.util.Locale} used to format the arguments
     * @param fmt  a Java-style printf() message format string
     * @param args additional parameters matching {@code %} tokens in the {@code fmt} string, if
     *             any
     * @return always -1.
     * @see #SDL_ClearError()
     * @see #SDL_GetError()
     */
    public static int SDL_SetError(
            Locale lang,
            String fmt,
            Object... args) {
        String message = String.format(lang, fmt, args);
        return NativeVarargFunctions.INSTANCE.SDL_SetError(message);
    }

    // TODO: Test if Java and SDL threads work

    /**
     * Retrieve a message about the last error that occurred on the current
     * thread.
     *
     * <p>It is possible for multiple errors to occur before calling SDL_GetError().
     * Only the last error is returned.</p>
     *
     * <p>The message is only applicable when an SDL function has signaled an error.
     * You must check the return values of SDL function calls to determine when to
     * appropriately call SDL_GetError(). You should *not* use the results of
     * SDL_GetError() to decide if an error has occurred! Sometimes SDL will set
     * an error string even when reporting success.</p>
     *
     * <p>SDL will *not* clear the error string for successful API calls. You *must*
     * check return values for failure cases before you can assume the error
     * string applies.</p>
     *
     * <p>Error strings are set per-thread, so an error set in a different thread
     * will not interfere with the current thread's operation.</p>
     *
     * <p>The returned string is internally allocated and must not be freed by the
     * application.</p>
     *
     * @return a message with information about the specific error that occurred,
     * or an empty string if there hasn't been an error message set since
     * the last call to SDL_ClearError(). The message is only applicable
     * when an SDL function has signaled an error. You must check the
     * return values of SDL function calls to determine when to
     * appropriately call SDL_GetError().
     * @see #SDL_ClearError()
     * @see #SDL_SetError(String, Object...)
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetError();

    /**
     * Get the last error message that was set for the current thread.
     *
     * <p>This allows the caller to copy the error string into a provided buffer, but
     * otherwise operates exactly the same as SDL_GetError().</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_GetError()}.</p>
     *
     * @param errstr A buffer to fill with the last error message that was set for
     *               the current thread
     * @param maxlen The size of the buffer pointed to by the errstr parameter
     * @return the pointer passed in as the {@code errstr} parameter.
     * @see #SDL_GetError()
     * @since This function is available since SDL 2.0.14.
     */
    public static native Pointer SDL_GetErrorMsg(
            Pointer errstr,
            int maxlen);

    /**
     * Clear any previous error message for this thread.
     *
     * @see #SDL_GetError()
     * @see #SDL_SetError(String, Object...)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_ClearError();

    /* Varargs are not supported in JNA Direct mapping, so Interface mapping is used here. */
    private interface NativeVarargFunctions extends Library {

        NativeVarargFunctions INSTANCE = SdlNativeLibraryLoader.loadLibSDL2InterfaceInstance(NativeVarargFunctions.class);

        int SDL_SetError(
                String fmt,
                Object... args);
    }
}
