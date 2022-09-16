package org.libsdl.api.error;

import java.util.Locale;
import com.sun.jna.Library;
import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

public final class SdlError {

    static {
        NativeLoader.registerNativeMethods(SdlError.class);
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
     * <p>The {@code fmt} argument is a String with format compatible with Java-style {@link java.util.Formatter}
     * (or {@code String.format()} or {@code System.out.printf()}). Note that it is very similar to the
     * original C-style {@code printf()} but has some differences.
     * The formatting is performed in Java prior to the actual SDL call and only pure strings are passed to the SDL library.</p>
     *
     * <p>Locale used for formatting is the default system locale.</p>
     *
     * <p>This function always returns -1, since SDL frequently uses -1 to signify an
     * failing result. However this is of a very limited use in Java, as it uses Exceptions to report errors.</p>
     *
     * @param fmt  a {@code java.util.Formatter}-style (Java's {@code printf()} syntax) message format string
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
     * <p>The {@code fmt} argument is a String with format compatible with Java-style {@link java.util.Formatter}
     * (or {@code String.format()} or {@code System.out.printf()}). Note that it is very similar to the
     * original C-style {@code printf()} but has some differences.
     * The formatting is performed in Java prior to the actual SDL call and only pure strings are passed to the SDL library.</p>
     *
     * <p>This function always returns -1, since SDL frequently uses -1 to signify an
     * failing result. However this is of a very limited use in Java, as it uses Exceptions to report errors.</p>
     *
     * @param lang a {@code java.util.Locale} used to format the arguments
     * @param fmt  a {@code java.util.Formatter}-style (Java's {@code printf()} syntax) message format string
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
    public static native String SDL_GetError();

    public static native Pointer SDL_GetErrorMsg(Pointer errstr, int maxlen);

    public static native void SDL_ClearError();

    /* Varargs are not supported in JNA Direct mapping, so Interface mapping is used here. */
    private interface NativeVarargFunctions extends Library {

        NativeVarargFunctions INSTANCE = NativeLoader.loadSdl2LibraryInstance(NativeVarargFunctions.class);

        int SDL_SetError(
                String fmt,
                Object... args);
    }
}
