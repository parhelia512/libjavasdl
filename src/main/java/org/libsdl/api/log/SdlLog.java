package org.libsdl.api.log;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_APPLICATION;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_ASSERT;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_AUDIO;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_ERROR;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_INPUT;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RENDER;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED1;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED10;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED2;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED3;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED4;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED5;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED6;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED7;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED8;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_RESERVED9;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_SYSTEM;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_TEST;
import static org.libsdl.api.log.SDL_LogCategory.SDL_LOG_CATEGORY_VIDEO;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_CRITICAL;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_DEBUG;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_ERROR;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_INFO;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_VERBOSE;
import static org.libsdl.api.log.SDL_LogPriority.SDL_LOG_PRIORITY_WARN;
import static org.libsdl.api.log.SdlLogConst.SDL_MAX_LOG_MESSAGE;

public final class SdlLog {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlLog.class);
    }

    private SdlLog() {
    }

    public static native void SDL_LogSetAllPriority(
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority);

    public static native void SDL_LogSetPriority(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority);

    @MagicConstant(valuesFromClass = SDL_LogPriority.class)
    public static native int SDL_LogGetPriority(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category);

    public static native void SDL_LogResetPriorities();

    public static void SDL_Log(
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_Log(fmt, args);
    }

    public static void SDL_LogVerbose(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogVerbose(category, fmt, args);
    }

    public static void SDL_LogDebug(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogDebug(category, fmt, args);
    }

    public static void SDL_LogInfo(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogInfo(category, fmt, args);
    }

    public static void SDL_LogWarn(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogWarn(category, fmt, args);
    }

    public static void SDL_LogError(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogError(category, fmt, args);
    }

    public static void SDL_LogCritical(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogCritical(category, fmt, args);
    }

    public static void SDL_LogMessage(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String fmt,
            Object... args) {
        if (fmt.length() > SDL_MAX_LOG_MESSAGE) {
            throw new IllegalArgumentException("Log message is too long (" + fmt.length() + " characters), maximum is " + SDL_MAX_LOG_MESSAGE);
        }
        NativeVarargFunctions.INSTANCE.SDL_LogMessage(category, priority, fmt, args);
    }

    public static native void SDL_LogGetOutputFunction(
            PointerByReference callback,
            PointerByReference userdata);

    public static native void SDL_LogSetOutputFunction(
            SDL_LogOutputFunction callback,
            Pointer userdata);

    public static native void SDL_LogSetOutputFunction(
            Pointer callback,
            Pointer userdata);

    /**
     * <p>Log message handler that will route all SDL internal logging to Java's SLF4J.</p>
     *
     * <p>Use this method as the first parameter to {@link #SDL_LogSetOutputFunction(SDL_LogOutputFunction, Pointer)}
     * to route all SDL internal logging to Java-style SLF4J.
     * Thus your application can have a single logging backend via a Java de-facto standard
     * SLF4J (LogBack, Log4J 2, etc.). All SDL internal logging will bubble up to Java
     * so that you can configure it as is common in Java.<p/>
     *
     * <p>If you want to use this log message handler, you must add SLF4J as a dependency to your project.</p>
     *
     * <p>Do not call the method directly. Use it as a log message router.</p>
     *
     * <p>It's not mandatory to use exactly this method. You can use it as an inspiration
     * and write your own router.</p>
     *
     * <p>Example use in the beginning of your Java app:</p>
     *
     * <pre>
     * SDL_LogSetOutputFunction(SdlLog::routeLibSdlLogToSlf4j, Pointer.NULL);
     * SDL_LogSetAllPriority(SDL_LOG_PRIORITY_VERBOSE);
     * </pre>
     *
     * @param userdata arbitrary data associated with the logging instance. Not used.
     * @param category will become the logger name for SLF4J.
     * @param priority will become the log priority (trace, debug, info, warn, error).
     * @param message  will become the actual message to be logged.
     */
    public static void routeSdlLoggingToSlf4j(
            Pointer userdata,
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String message) {
        String loggerName;
        switch (category) {
            case SDL_LOG_CATEGORY_APPLICATION:
                loggerName = "org.libsdl.application";
                break;
            case SDL_LOG_CATEGORY_ERROR:
                loggerName = "org.libsdl.error";
                break;
            case SDL_LOG_CATEGORY_ASSERT:
                loggerName = "org.libsdl.assert";
                break;
            case SDL_LOG_CATEGORY_SYSTEM:
                loggerName = "org.libsdl.system";
                break;
            case SDL_LOG_CATEGORY_AUDIO:
                loggerName = "org.libsdl.audio";
                break;
            case SDL_LOG_CATEGORY_VIDEO:
                loggerName = "org.libsdl.video";
                break;
            case SDL_LOG_CATEGORY_RENDER:
                loggerName = "org.libsdl.render";
                break;
            case SDL_LOG_CATEGORY_INPUT:
                loggerName = "org.libsdl.input";
                break;
            case SDL_LOG_CATEGORY_TEST:
                loggerName = "org.libsdl.test";
                break;
            case SDL_LOG_CATEGORY_RESERVED1:
            case SDL_LOG_CATEGORY_RESERVED2:
            case SDL_LOG_CATEGORY_RESERVED3:
            case SDL_LOG_CATEGORY_RESERVED4:
            case SDL_LOG_CATEGORY_RESERVED5:
            case SDL_LOG_CATEGORY_RESERVED6:
            case SDL_LOG_CATEGORY_RESERVED7:
            case SDL_LOG_CATEGORY_RESERVED8:
            case SDL_LOG_CATEGORY_RESERVED9:
            case SDL_LOG_CATEGORY_RESERVED10:
                loggerName = "org.libsdl.reserved";
                break;
            default:
                loggerName = "org.libsdl.custom" + category;
                break;
        }
        Logger logger = LoggerFactory.getLogger(loggerName);

        switch (priority) {
            case SDL_LOG_PRIORITY_VERBOSE:
                logger.trace(message);
                break;
            default:
            case SDL_LOG_PRIORITY_DEBUG:
                logger.debug(message);
                break;
            case SDL_LOG_PRIORITY_INFO:
                logger.info(message);
                break;
            case SDL_LOG_PRIORITY_WARN:
                logger.warn(message);
                break;
            case SDL_LOG_PRIORITY_ERROR:
            case SDL_LOG_PRIORITY_CRITICAL:
                logger.error(message);
                break;
        }
    }

    /* Varargs are not supported in JNA Direct mapping, so Interface mapping is used here. */
    private interface NativeVarargFunctions extends Library {

        NativeVarargFunctions INSTANCE = SdlNativeLibraryLoader.loadLibSDL2InterfaceInstance(NativeVarargFunctions.class);

        void SDL_Log(
                String fmt,
                Object... args);

        void SDL_LogVerbose(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogDebug(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogInfo(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogWarn(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogError(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogCritical(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                String fmt,
                Object... args);

        void SDL_LogMessage(
                @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
                @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
                String fmt,
                Object... args);
    }
}
