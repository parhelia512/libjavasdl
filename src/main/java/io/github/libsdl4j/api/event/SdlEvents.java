package io.github.libsdl4j.api.event;

import com.sun.jna.Callback;
import com.sun.jna.CallbackReference;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_DISABLE;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_ENABLE;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_IGNORE;
import static io.github.libsdl4j.api.event.SdlEventsConst.SDL_QUERY;

/**
 * Definitions from file SDL_events.h
 *
 * <p>Include file for SDL event handling.</p>
 */
public final class SdlEvents {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    /**
     * Pump the event loop, gathering events from the input devices.
     *
     * <p>This function updates the event queue and internal input device state.</p>
     *
     * **WARNING**: This should only be run in the thread that initialized the
     * video subsystem, and for extra safety, you should consider only doing those
     * things on the main thread in any case.
     *
     * <p>SDL_PumpEvents() gathers all the pending input information from devices and
     * places it in the event queue. Without calls to SDL_PumpEvents() no events
     * would ever be placed on the queue. Often the need for calls to
     * SDL_PumpEvents() is hidden from the user since SDL_PollEvent() and
     * SDL_WaitEvent() implicitly call SDL_PumpEvents(). However, if you are not
     * polling or waiting for events (e.g. you are filtering them), then you must
     * call SDL_PumpEvents() to force an event queue update.</p>
     *
     * @see #SDL_PollEvent(SDL_Event)
     * @see #SDL_WaitEvent(SDL_Event)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_PumpEvents();

    // TODO: Test

    /**
     * Check the event queue for messages and optionally return them.
     *
     * <p>{@code action} may be any of the following:</p>
     *
     * - {@code SDL_ADDEVENT}: up to {@code numevents} events will be added to the back of the
     * event queue.
     * - {@code SDL_PEEKEVENT}: {@code numevents} events at the front of the event queue,
     * within the specified minimum and maximum type, will be returned to the
     * caller and will _not_ be removed from the queue.
     * - {@code SDL_GETEVENT}: up to {@code numevents} events at the front of the event queue,
     * within the specified minimum and maximum type, will be returned to the
     * caller and will be removed from the queue.
     *
     * <p>You may have to call SDL_PumpEvents() before calling this function.
     * Otherwise, the events may not be ready to be filtered when you call
     * SDL_PeepEvents().</p>
     *
     * <p>This function is thread-safe.</p>
     *
     * @param events    destination buffer for the retrieved events
     * @param numEvents if action is SDL_ADDEVENT, the number of events to add
     *                  back to the event queue; if action is SDL_PEEKEVENT or
     *                  SDL_GETEVENT, the maximum number of events to retrieve
     * @param action    action to take; see [[#action|Remarks]] for details
     * @param minType   minimum value of the event type to be considered;
     *                  SDL_FIRSTEVENT is a safe choice
     * @param maxType   maximum value of the event type to be considered;
     *                  SDL_LASTEVENT is a safe choice
     * @return the number of events actually stored or a negative error code on
     * failure; call SDL_GetError() for more information.
     * @see #SDL_PollEvent(SDL_Event)
     * @see #SDL_PumpEvents()
     * @see #SDL_PushEvent(SDL_Event)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_PeepEvents(
            Pointer events,
            int numEvents,
            @MagicConstant(valuesFromClass = SDL_eventaction.class) int action,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    /**
     * Check for the existence of a certain event type in the event queue.
     *
     * <p>If you need to check for a range of event types, use SDL_HasEvents()
     * instead.</p>
     *
     * @param type the type of event to be queried; see SDL_EventType for details
     * @return true if events matching {@code type} are present, or false if
     * events matching {@code type} are not present.
     * @see #SDL_HasEvents(int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_HasEvent(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    /**
     * Check for the existence of certain event types in the event queue.
     *
     * <p>If you need to check for a single event type, use SDL_HasEvent() instead.</p>
     *
     * @param minType the low end of event type to be queried, inclusive; see
     *                SDL_EventType for details
     * @param maxType the high end of event type to be queried, inclusive; see
     *                SDL_EventType for details
     * @return true if events with type greater or equal to {@code minType} and less or equal to {@code maxType} are
     * present, or false if not.
     * @see #SDL_HasEvents(int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_HasEvents(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    /**
     * Clear events of a specific type from the event queue.
     *
     * <p>This will unconditionally remove any events from the queue that match
     * {@code type}. If you need to remove a range of event types, use SDL_FlushEvents()
     * instead.</p>
     *
     * <p>It's also normal to just ignore events you don't care about in your event
     * loop without calling this function.</p>
     *
     * <p>This function only affects currently queued events. If you want to make
     * sure that all pending OS events are flushed, you can call SDL_PumpEvents()
     * on the main thread immediately before the flush call.</p>
     *
     * @param type the type of event to be cleared; see SDL_EventType for details
     * @see #SDL_FlushEvents(int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FlushEvent(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    /**
     * Clear events of a range of types from the event queue.
     *
     * <p>This will unconditionally remove any events from the queue that are in the
     * range of {@code minType} to {@code maxType}, inclusive. If you need to remove a single
     * event type, use SDL_FlushEvent() instead.</p>
     *
     * <p>It's also normal to just ignore events you don't care about in your event
     * loop without calling this function.</p>
     *
     * <p>This function only affects currently queued events. If you want to make
     * sure that all pending OS events are flushed, you can call SDL_PumpEvents()
     * on the main thread immediately before the flush call.</p>
     *
     * @param minType the low end of event type to be cleared, inclusive; see
     *                SDL_EventType for details
     * @param maxType the high end of event type to be cleared, inclusive; see
     *                SDL_EventType for details
     * @see #SDL_FlushEvent(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FlushEvents(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    /**
     * Poll for currently pending events.
     *
     * <p>If {@code event} is not NULL, the next event is removed from the queue and stored
     * in the SDL_Event structure pointed to by {@code event}. The 1 returned refers to
     * this event, immediately stored in the SDL Event structure -- not an event
     * to follow.</p>
     *
     * <p>If {@code event} is NULL, it simply returns 1 if there is an event in the queue,
     * but will not remove it from the queue.</p>
     *
     * <p>As this function may implicitly call SDL_PumpEvents(), you can only call
     * this function in the thread that set the video mode.</p>
     *
     * <p>SDL_PollEvent() is the favored way of receiving system events since it can
     * be done from the main loop and does not suspend the main loop while waiting
     * on an event to be posted.</p>
     *
     * <p>The common practice is to fully process the event queue once every frame,
     * usually as a first step before updating the game's state:</p>
     *
     * <pre>
     * SDL_Event event = new SDL_Event();
     * while (gameIsStillRunning) {
     *     while (SDL_PollEvent(event)) {  // poll until all events are handled!
     *         // decide what to do with this event.
     *     }
     *
     *     // update game state, draw the current frame
     * }
     * </pre>
     *
     * @param event the SDL_Event structure to be filled with the next event from
     *              the queue, or NULL
     * @return 1 if there is a pending event or 0 if there are none available.
     * @see #SDL_GetEventFilter(PointerByReference)
     * @see #SDL_PeepEvents(Pointer, int, int, int, int)
     * @see #SDL_PushEvent(SDL_Event)
     * @see #SDL_SetEventFilter(SDL_EventFilter, Pointer)
     * @see #SDL_WaitEvent(SDL_Event)
     * @see #SDL_WaitEventTimeout(SDL_Event, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_PollEvent(
            SDL_Event event);

    /**
     * Wait indefinitely for the next available event.
     *
     * <p>If {@code event} is not NULL, the next event is removed from the queue and stored
     * in the SDL_Event structure pointed to by {@code event}.</p>
     *
     * <p>As this function may implicitly call SDL_PumpEvents(), you can only call
     * this function in the thread that initialized the video subsystem.</p>
     *
     * @param event the SDL_Event structure to be filled in with the next event
     *              from the queue, or NULL
     * @return 1 on success or 0 if there was an error while waiting for events;
     * call SDL_GetError() for more information.
     * @see #SDL_PollEvent(SDL_Event)
     * @see #SDL_PumpEvents()
     * @see #SDL_WaitEventTimeout(SDL_Event, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_WaitEvent(
            SDL_Event event);

    /**
     * Wait until the specified timeout (in milliseconds) for the next available
     * event.
     *
     * <p>If {@code event} is not NULL, the next event is removed from the queue and stored
     * in the SDL_Event structure pointed to by {@code event}.</p>
     *
     * <p>As this function may implicitly call SDL_PumpEvents(), you can only call
     * this function in the thread that initialized the video subsystem.</p>
     *
     * @param event   the SDL_Event structure to be filled in with the next event
     *                from the queue, or NULL
     * @param timeout the maximum number of milliseconds to wait for the next
     *                available event
     * @return 1 on success or 0 if there was an error while waiting for events;
     * call SDL_GetError() for more information. This also returns 0 if
     * the timeout elapsed without an event arriving.
     * @see #SDL_PollEvent(SDL_Event)
     * @see #SDL_PumpEvents()
     * @see #SDL_WaitEvent(SDL_Event)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_WaitEventTimeout(
            SDL_Event event,
            int timeout);

    /**
     * Add an event to the event queue.
     *
     * <p>The event queue can actually be used as a two way communication channel.
     * Not only can events be read from the queue, but the user can also push
     * their own events onto it. {@code event} is a pointer to the event structure you
     * wish to push onto the queue. The event is copied into the queue, and the
     * caller may dispose of the memory pointed to after SDL_PushEvent() returns.</p>
     *
     * <p>Note: Pushing device input events onto the queue doesn't modify the state
     * of the device within SDL.</p>
     *
     * <p>This function is thread-safe, and can be called from other threads safely.</p>
     *
     * <p>Note: Events pushed onto the queue with SDL_PushEvent() get passed through
     * the event filter but events added with SDL_PeepEvents() do not.</p>
     *
     * <p>For pushing application-specific events, please use SDL_RegisterEvents() to
     * get an event type that does not conflict with other code that also wants
     * its own custom event types.</p>
     *
     * @param event the SDL_Event to be added to the queue
     * @return 1 on success, 0 if the event was filtered, or a negative error
     * code on failure; call SDL_GetError() for more information. A
     * common reason for error is the event queue being full.
     * @see #SDL_PeepEvents(Pointer, int, int, int, int)
     * @see #SDL_PollEvent(SDL_Event)
     * @see #SDL_RegisterEvents(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_PushEvent(
            SDL_Event event);

    /**
     * Set up a filter to process all events before they change internal state and
     * are posted to the internal event queue.
     *
     * <p>If the filter function returns 1 when called, then the event will be added
     * to the internal queue. If it returns 0, then the event will be dropped from
     * the queue, but the internal state will still be updated. This allows
     * selective filtering of dynamically arriving events.</p>
     *
     * **WARNING**: Be very careful of what you do in the event filter function,
     * as it may run in a different thread!
     *
     * <p>On platforms that support it, if the quit event is generated by an
     * interrupt signal (e.g. pressing Ctrl-C), it will be delivered to the
     * application at the next event poll.</p>
     *
     * <p>There is one caveat when dealing with the {@link io.github.libsdl4j.api.event.events.SDL_QuitEvent} event type. The
     * event filter is only called when the window manager desires to close the
     * application window. If the event filter returns 1, then the window will be
     * closed, otherwise the window will remain open if possible.</p>
     *
     * <p>Note: Disabled events never make it to the event filter function; see
     * SDL_EventState().</p>
     *
     * <p>Note: If you just want to inspect events without filtering, you should use
     * SDL_AddEventWatch() instead.</p>
     *
     * <p>Note: Events pushed onto the queue with SDL_PushEvent() get passed through
     * the event filter, but events pushed onto the queue with SDL_PeepEvents() do
     * not.</p>
     *
     * <p><b>Warning</b> A reference to the {@link SDL_EventFilter} object must be retained by the application,
     * otherwise the callback may crash the JVM.</p>
     *
     * @param filter   An SDL_EventFilter function to call when an event happens
     * @param userdata Any arbitrary data the programmer wants to associate with the callback. It will be passed to method from the {@code filter}.
     * @see #SDL_AddEventWatch(SDL_EventFilter, Pointer)
     * @see #SDL_EventState(int, int)
     * @see #SDL_GetEventFilter(PointerByReference)
     * @see #SDL_PeepEvents(Pointer, int, int, int, int)
     * @see #SDL_PushEvent(SDL_Event)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_SetEventFilter(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * Query the current event filter.
     *
     * <p>This function can be used to "chain" filters, by saving the existing filter
     * before replacing it with a function that will call that saved filter.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param userdata A pointer that is passed to `filter` when first registered
     * @return Either a previously registered {@link SDL_EventFilter} or null if none was previously registered
     */
    public static SDL_EventFilter SDL_GetEventFilter(
            PointerByReference userdata) {
        PointerByReference filterHolder = new PointerByReference();
        if (!SDL_GetEventFilter(filterHolder, userdata)) {
            return null;
        }
        Pointer filterPointer = filterHolder.getPointer();
        if (Pointer.nativeValue(filterPointer) == 0L) {
            return null;
        }
        Callback filter = CallbackReference.getCallback(SDL_EventFilter.class, filterPointer);
        return (SDL_EventFilter) filter;
    }

    /**
     * Query the current event filter.
     *
     * <p>This function can be used to "chain" filters, by saving the existing filter
     * before replacing it with a function that will call that saved filter.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_GetEventFilter(PointerByReference)}.</p>
     *
     * @param filter   the current callback function will be stored here
     * @param userdata the pointer that is passed to the current event filter will
     *                 be stored here
     * @return true on success or false if there is no event filter set.
     * @see #SDL_SetEventFilter(SDL_EventFilter, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_GetEventFilter(
            PointerByReference filter,
            PointerByReference userdata);

    /**
     * Add a callback to be triggered when an event is added to the event queue.
     *
     * <p>{@code filter} will be called when an event happens, and its return value is
     * ignored.</p>
     *
     * **WARNING**: Be very careful of what you do in the event filter function,
     * as it may run in a different thread!
     *
     * <p>If the quit event is generated by a signal (e.g. SIGINT), it will bypass
     * the internal queue and be delivered to the watch callback immediately, and
     * arrive at the next event poll.</p>
     *
     * <p>Note: the callback is called for events posted by the user through
     * SDL_PushEvent(), but not for disabled events, nor for events by a filter
     * callback set with SDL_SetEventFilter(), nor for events posted by the user
     * through SDL_PeepEvents().</p>
     *
     * @param filter   an SDL_EventFilter function to call when an event happens.
     * @param userdata a pointer that is passed to {@code filter}
     * @see #SDL_DelEventWatch(SDL_EventFilter, Pointer)
     * @see #SDL_SetEventFilter(SDL_EventFilter, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_AddEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * Remove an event watch callback added with SDL_AddEventWatch().
     *
     * <p>This function takes the same input as SDL_AddEventWatch() to identify and
     * delete the corresponding callback.</p>
     *
     * @param filter   the function originally passed to SDL_AddEventWatch()
     * @param userdata the pointer originally passed to SDL_AddEventWatch()
     * @see #SDL_AddEventWatch(SDL_EventFilter, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_DelEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * Run a specific filter function on the current event queue, removing any
     * events for which the filter returns 0.
     *
     * <p>See SDL_SetEventFilter() for more information. Unlike SDL_SetEventFilter(),
     * this function does not change the filter permanently, it only uses the
     * supplied filter until this function returns.</p>
     *
     * @param filter   the SDL_EventFilter function to call when an event happens
     * @param userdata a pointer that is passed to {@code filter}
     * @see #SDL_GetEventFilter(PointerByReference)
     * @see #SDL_SetEventFilter(SDL_EventFilter, Pointer)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FilterEvents(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * Set the state of processing events by type.
     *
     * <p>{@code state} may be any of the following:</p>
     *
     * <ul>
     *     <li>{@code SDL_QUERY}: returns the current processing state of the specified event</li>
     *     <li>{@code SDL_IGNORE} (aka {@code SDL_DISABLE}): the event will automatically be dropped
     *         from the event queue and will not be filtered</li>
     *     <li>{@code SDL_ENABLE}: the event will be processed normally</li>
     * </ul>
     *
     * @param type  the type of event; see SDL_EventType for details
     * @param state how to process the event
     * @return {@code SDL_DISABLE} or {@code SDL_ENABLE}, representing the processing state
     * of the event before this function makes any changes to it.
     * @see #SDL_GetEventState(int)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(intValues = {SDL_DISABLE, SDL_ENABLE})
    public static native byte SDL_EventState(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type,
            @MagicConstant(intValues = {SDL_QUERY, SDL_IGNORE, SDL_ENABLE}) int state);

    @MagicConstant(intValues = {SDL_DISABLE, SDL_ENABLE})
    public static byte SDL_GetEventState(
            @MagicConstant(intValues = {SDL_QUERY, SDL_IGNORE, SDL_ENABLE}) int type) {
        return SDL_EventState(type, SDL_QUERY);
    }

    /**
     * Allocate a set of user-defined events, and return the beginning event
     * number for that set of events.
     *
     * <p>Calling this function with {@code numevents} less or equal to 0 is an error and will return
     * (Uint32)-1.</p>
     *
     * <p>Note, (Uint32)-1 means the maximum unsigned 32-bit integer value (or
     * 0xFFFFFFFF), but is clearer to write.</p>
     *
     * @param numEvents the number of events to be allocated
     * @return the beginning event number, or -1 if there are not enough
     * user-defined events left.
     * @see #SDL_PushEvent(SDL_Event)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_EventType.class)
    public static native int SDL_RegisterEvents(
            int numEvents);
}
