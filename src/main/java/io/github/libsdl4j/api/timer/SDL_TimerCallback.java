package io.github.libsdl4j.api.timer;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_TimerCallback extends Callback {

    /**
     * Function prototype for the timer callback function.
     *
     * <p>The callback function is passed the current timer interval and returns
     * the next timer interval. If the returned value is the same as the one
     * passed in, the periodic alarm continues, otherwise a new alarm is
     * scheduled. If the callback returns 0, the periodic alarm is cancelled.</p>
     */
    int onTimerTick(int interval, Pointer param);
}
