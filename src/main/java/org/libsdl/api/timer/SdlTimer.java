package org.libsdl.api.timer;

import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

public final class SdlTimer {

    /**
     * Get the number of milliseconds since SDL library initialization.
     *
     * This value wraps if the program runs for more than ~49 days.
     *
     * \returns an unsigned 32-bit value representing the number of milliseconds
     *          since the SDL library initialized.
     *
     * \sa SDL_TICKS_PASSED
     */
    public static int SDL_GetTicks() {
        return NativeFunctions.SDL_GetTicks();
    }

    /**
     * Compare SDL ticks values, and return true if `A` has passed `B`.
     *
     * For example, if you want to wait 100 ms, you could do this:
     *
     * ```java
     * int timeout = SDL_GetTicks() + 100;
     * while (!SDL_TICKS_PASSED(SDL_GetTicks(), timeout)) {
     *     // ... do work until timeout has elapsed
     * }
     * ```
     */
    public static boolean SDL_TICKS_PASSED(int ticksCountA, int ticksCountB) {
        return (ticksCountB - ticksCountA) <= 0;
    }

    /**
     * Get the current value of the high resolution counter.
     *
     * This function is typically used for profiling.
     *
     * The counter values are only meaningful relative to each other. Differences
     * between values can be converted to times by using
     * SDL_GetPerformanceFrequency().
     *
     * \returns the current counter value.
     *
     * \sa SDL_GetPerformanceFrequency
     */
    public static long SDL_GetPerformanceCounter() {
        return NativeFunctions.SDL_GetPerformanceCounter();
    }

    /**
     * Get the count per second of the high resolution counter.
     *
     * \returns a platform-specific count per second.
     *
     * \since This function is available since SDL 2.0.0.
     *
     * \sa SDL_GetPerformanceCounter
     */
    public static long SDL_GetPerformanceFrequency() {
        return NativeFunctions.SDL_GetPerformanceFrequency();
    }

    /**
     * Wait a specified number of milliseconds before returning.
     *
     * This function waits a specified number of milliseconds before returning. It
     * waits at least the specified time, but possibly longer due to OS
     * scheduling.
     *
     * \param ms the number of milliseconds to delay
     */
    public static void SDL_Delay(int ms) {
        NativeFunctions.SDL_Delay(ms);
    }

    /**
     * Call a callback function at a future time.
     *
     * If you use this function, you must pass `SDL_INIT_TIMER` to SDL_Init().
     *
     * The callback function is passed the current timer interval and the user
     * supplied parameter from the SDL_AddTimer() call and should return the next
     * timer interval. If the value returned from the callback is 0, the timer is
     * canceled.
     *
     * The callback is run on a separate thread.
     *
     * Timers take into account the amount of time it took to execute the
     * callback. For example, if the callback took 250 ms to execute and returned
     * 1000 (ms), the timer would only wait another 750 ms before its next
     * iteration.
     *
     * Timing may be inexact due to OS scheduling. Be sure to note the current
     * time with SDL_GetTicks() or SDL_GetPerformanceCounter() in case your
     * callback needs to adjust for variances.
     *
     * \param interval the timer delay, in milliseconds, passed to `callback`
     * \param callback the SDL_TimerCallback function to call when the specified
     *                 `interval` elapses
     * \param param a pointer that is passed to `callback`
     * \returns a timer ID or 0 if an error occurs; call SDL_GetError() for more
     *          information.
     *
     * \sa SDL_RemoveTimer
     */
    public static SDL_TimerID SDL_AddTimer(int interval, SDL_TimerCallback callback, Pointer param) {
        return NativeFunctions.SDL_AddTimer(interval, callback, param);
    }

    /**
     * Remove a timer created with SDL_AddTimer().
     *
     * \param id the ID of the timer to remove
     * \returns SDL_TRUE if the timer is removed or SDL_FALSE if the timer wasn't
     *          found.
     *
     * \sa SDL_AddTimer
     */
    public static boolean SDL_RemoveTimer(SDL_TimerID id) {
        return NativeFunctions.SDL_RemoveTimer(id);
    }

    private static final class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(NativeFunctions.class);
        }

        public static native int SDL_GetTicks();

        public static native long SDL_GetPerformanceCounter();

        public static native long SDL_GetPerformanceFrequency();

        public static native void SDL_Delay(int ms);

        public static native SDL_TimerID SDL_AddTimer(
                int interval,
                SDL_TimerCallback callback,
                Pointer param);

        public static native boolean SDL_RemoveTimer(SDL_TimerID id);
    }
}
