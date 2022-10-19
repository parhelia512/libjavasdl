package io.github.libsdl4j.api.event;

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
public interface SDL_EventFilter extends Callback {

    /**
     * A callback that watches the event queue.
     *
     * @param userdata what was passed as {@code userdata} to SDL_SetEventFilter()
     *                 or SDL_AddEventWatch, etc
     * @param event    the event that triggered the callback
     * @return 1 to permit event to be added to the queue, and 0 to disallow
     * it. When used with SDL_AddEventWatch, the return value is ignored.
     * @see SdlEvents#SDL_SetEventFilter(SDL_EventFilter, Pointer)
     * @see SdlEvents#SDL_AddEventWatch(SDL_EventFilter, Pointer)
     */
    int filterEvent(
            Pointer userdata,
            SDL_Event event);
}
