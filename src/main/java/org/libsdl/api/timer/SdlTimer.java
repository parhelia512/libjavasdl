package org.libsdl.api.timer;

import com.sun.jna.Pointer;
import org.libsdl.jna.NativeLoader;

public final class SdlTimer {

    static {
        NativeLoader.registerNativeMethods(SdlTimer.class);
    }

    private SdlTimer() {
    }

    /**
     * Get the number of milliseconds since SDL library initialization.
     *
     * <p>This value wraps if the program runs for more than ~49 days.</p>
     *
     * @return an unsigned 32-bit value representing the number of milliseconds
     * since the SDL library initialized.
     * @see #SDL_TICKS_PASSED(int, int)
     */
    public static native int SDL_GetTicks();

    /**
     * Compare SDL ticks values, and return true if {@code A} has passed {@code B}.
     *
     * <p>For example, if you want to wait 100 ms, you could do this:</p>
     *
     * <blockquote><pre>
     * int timeout = SDL_GetTicks() + 100;
     * while (!SDL_TICKS_PASSED(SDL_GetTicks(), timeout)) {
     *     // ... do work until timeout has elapsed
     * }</pre></blockquote>
     */
    public static boolean SDL_TICKS_PASSED(int ticksCountA, int ticksCountB) {
        return (ticksCountB - ticksCountA) <= 0;
    }

    /**
     * Get the current value of the high resolution counter.
     *
     * <p>This function is typically used for profiling.</p>
     *
     * <p>The counter values are only meaningful relative to each other. Differences
     * between values can be converted to times by using
     * SDL_GetPerformanceFrequency().</p>
     *
     * @return the current counter value.
     * @see #SDL_GetPerformanceFrequency()
     */
    public static native long SDL_GetPerformanceCounter();

    /**
     * Get the count per second of the high resolution counter.
     *
     * @return a platform-specific count per second.
     * @see #SDL_GetPerformanceCounter()
     * @since This function is available since SDL 2.0.0.
     */
    public static native long SDL_GetPerformanceFrequency();

    /**
     * Wait a specified number of milliseconds before returning.
     *
     * <p>This function waits a specified number of milliseconds before returning. It
     * waits at least the specified time, but possibly longer due to OS
     * scheduling.</p>
     *
     * @param ms the number of milliseconds to delay
     */
    public static native void SDL_Delay(int ms);

    /**
     * Call a callback function at a future time.
     *
     * <p>If you use this function, you must pass {@code SDL_INIT_TIMER} to SDL_Init().</p>
     *
     * <p>The callback function is passed the current timer interval and the user
     * supplied parameter from the SDL_AddTimer() call and should return the next
     * timer interval. If the value returned from the callback is 0, the timer is
     * canceled.</p>
     *
     * <p>The callback is run on a separate thread.</p>
     *
     * <p>Timers take into account the amount of time it took to execute the
     * callback. For example, if the callback took 250 ms to execute and returned
     * 1000 (ms), the timer would only wait another 750 ms before its next
     * iteration.</p>
     *
     * <p>Timing may be inexact due to OS scheduling. Be sure to note the current
     * time with SDL_GetTicks() or SDL_GetPerformanceCounter() in case your
     * callback needs to adjust for variances.</p>
     *
     * @param interval the timer delay, in milliseconds, passed to {@code callback}
     * @param callback the SDL_TimerCallback function to call when the specified
     *                 {@code interval} elapses
     * @param param    a pointer that is passed to {@code callback}
     * @return a timer ID or 0 if an error occurs; call SDL_GetError() for more
     * information.
     * @see #SDL_RemoveTimer(SDL_TimerID)
     */
    public static native SDL_TimerID SDL_AddTimer(
            int interval,
            SDL_TimerCallback callback,
            Pointer param);

    /**
     * Remove a timer created with SDL_AddTimer().
     *
     * @param id the ID of the timer to remove
     * @return SDL_TRUE if the timer is removed or SDL_FALSE if the timer wasn't
     * found.
     * @see #SDL_AddTimer(int, SDL_TimerCallback, Pointer)
     */
    public static native boolean SDL_RemoveTimer(SDL_TimerID id);
}
