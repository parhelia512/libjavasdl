package org.libsdl.api.log;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.NativeLoader;

public final class SdlLog {

    static {
        NativeLoader.registerNativeMethods(SdlLog.class);
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

    // TODO: Replace Object[] by Object... in SDL_Log(..)
    //       Note: Varargs are not supported in direct mapping
    // TODO: Test if it works with Object[]
    public static native void SDL_Log(
            String fmt,
            Object[] args);

    public static native void SDL_LogVerbose(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogDebug(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogInfo(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogWarn(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogError(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogCritical(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            String fmt,
            Object[] args);

    public static native void SDL_LogMessage(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String fmt,
            Object[] args);

    public static native void SDL_LogMessageV(
            @MagicConstant(valuesFromClass = SDL_LogCategory.class) int category,
            @MagicConstant(valuesFromClass = SDL_LogPriority.class) int priority,
            String fmt,
            Pointer ap);

    public static native void SDL_LogGetOutputFunction(
            PointerByReference callback,
            PointerByReference userdata);

    // TODO: Write a Java callback handler to route the logs to SLF4J
    public static native void SDL_LogSetOutputFunction(
            SDL_LogOutputFunction callback,
            Pointer userdata);
}
