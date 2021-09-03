package io.github.libjsdl.api.log;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import io.github.libjsdl.api.error.SDL_LogOutputFunction;
import io.github.libjsdl.loader.NativeLoader;

public final class SdlLog {

    public static final int SDL_MAX_LOG_MESSAGE = 4096;

    public static final int SDL_LOG_CATEGORY_APPLICATION = 0;
    public static final int SDL_LOG_CATEGORY_ERROR = 1;
    public static final int SDL_LOG_CATEGORY_ASSERT = 2;
    public static final int SDL_LOG_CATEGORY_SYSTEM = 3;
    public static final int SDL_LOG_CATEGORY_AUDIO = 4;
    public static final int SDL_LOG_CATEGORY_VIDEO = 5;
    public static final int SDL_LOG_CATEGORY_RENDER = 6;
    public static final int SDL_LOG_CATEGORY_INPUT = 7;
    public static final int SDL_LOG_CATEGORY_TEST = 8;
    public static final int SDL_LOG_CATEGORY_RESERVED1 = 9;
    public static final int SDL_LOG_CATEGORY_RESERVED2 = 10;
    public static final int SDL_LOG_CATEGORY_RESERVED3 = 11;
    public static final int SDL_LOG_CATEGORY_RESERVED4 = 12;
    public static final int SDL_LOG_CATEGORY_RESERVED5 = 13;
    public static final int SDL_LOG_CATEGORY_RESERVED6 = 14;
    public static final int SDL_LOG_CATEGORY_RESERVED7 = 15;
    public static final int SDL_LOG_CATEGORY_RESERVED8 = 16;
    public static final int SDL_LOG_CATEGORY_RESERVED9 = 17;
    public static final int SDL_LOG_CATEGORY_RESERVED10 = 18;
    public static final int SDL_LOG_CATEGORY_CUSTOM = 19;

    public static final int SDL_LOG_PRIORITY_VERBOSE = 1;
    public static final int SDL_LOG_PRIORITY_DEBUG = 2;
    public static final int SDL_LOG_PRIORITY_INFO = 3;
    public static final int SDL_LOG_PRIORITY_WARN = 4;
    public static final int SDL_LOG_PRIORITY_ERROR = 5;
    public static final int SDL_LOG_PRIORITY_CRITICAL = 6;
    public static final int SDL_NUM_LOG_PRIORITIES = 7;

    static {
        NativeLoader.registerNativeMethods(SdlLog.class);
    }

    private SdlLog() {
    }

    public static native void SDL_LogSetAllPriority(
            int priority);

    public static native void SDL_LogSetPriority(
            int category,
            int priority);

    public static native int SDL_LogGetPriority(
            int category);

    public static native void SDL_LogResetPriorities();

    // TODO: Replace Object[] by Object... in SDL_Log(..)
    //       Note: Varargs are not supported in direct mapping

    public static native void SDL_Log(
            final String fmt,
            final Object[] args);

    public static native void SDL_LogVerbose(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogDebug(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogInfo(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogWarn(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogError(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogCritical(
            final int category,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogMessage(
            final int category,
            final int priority,
            final String fmt,
            final Object[] args);

    public static native void SDL_LogGetOutputFunction(
            PointerByReference callback,
            PointerByReference userdata);

    public static native void SDL_LogSetOutputFunction(
            SDL_LogOutputFunction callback,
            Pointer userdata);

    public static native void SDL_LogMessageV(
            final int category,
            final int priority,
            final String fmt,
            final Pointer ap);
}
