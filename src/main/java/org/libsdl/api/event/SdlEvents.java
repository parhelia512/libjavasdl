package org.libsdl.api.event;

import com.sun.jna.Callback;
import com.sun.jna.CallbackReference;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.event.SdlEventsConst.SDL_DISABLE;
import static org.libsdl.api.event.SdlEventsConst.SDL_ENABLE;
import static org.libsdl.api.event.SdlEventsConst.SDL_IGNORE;
import static org.libsdl.api.event.SdlEventsConst.SDL_QUERY;

public final class SdlEvents {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    public static native void SDL_PumpEvents();

    // TODO: Test
    public static native int SDL_PeepEvents(
            Pointer events,
            int numEvents,
            @MagicConstant(valuesFromClass = SDL_eventaction.class) int action,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native boolean SDL_HasEvent(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native boolean SDL_HasEvents(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native void SDL_FlushEvent(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native void SDL_FlushEvents(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int minType,
            @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native int SDL_PollEvent(
            SDL_Event event);

    public static native int SDL_WaitEvent(
            SDL_Event event);

    public static native int SDL_WaitEventTimeout(
            SDL_Event event,
            int timeout);

    public static native int SDL_PushEvent(
            SDL_Event event);

    /**
     * Watch out! A reference to the {@link SDL_EventFilter} object must be retained by the application,
     * otherwise the callback may crash the JVM.
     *
     * @param filter   The callback function
     * @param userdata Any arbitrary data the programmer wants to associate with the callback.
     */
    public static native void SDL_SetEventFilter(
            SDL_EventFilter filter,
            Pointer userdata);

    /**
     * More Java-way of retrieving {@link SDL_EventFilter}
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
        if (filterPointer == Pointer.NULL) {
            return null;
        }
        Callback filter = CallbackReference.getCallback(SDL_EventFilter.class, filterPointer);
        return (SDL_EventFilter) filter;
    }

    public static native boolean SDL_GetEventFilter(
            PointerByReference filter,
            PointerByReference userdata);

    public static native void SDL_AddEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    public static native void SDL_DelEventWatch(
            SDL_EventFilter filter,
            Pointer userdata);

    public static native void SDL_FilterEvents(
            SDL_EventFilter filter,
            Pointer userdata);

    @MagicConstant(intValues = {SDL_DISABLE, SDL_ENABLE})
    public static native byte SDL_EventState(
            @MagicConstant(valuesFromClass = SDL_EventType.class) int type,
            @MagicConstant(intValues = {SDL_QUERY, SDL_IGNORE, SDL_ENABLE}) int state);

    @MagicConstant(intValues = {SDL_DISABLE, SDL_ENABLE})
    public static byte SDL_GetEventState(
            @MagicConstant(intValues = {SDL_QUERY, SDL_IGNORE, SDL_ENABLE}) int type) {
        return SDL_EventState(type, SDL_QUERY);
    }

    @MagicConstant(valuesFromClass = SDL_EventType.class)
    public static native int SDL_RegisterEvents(
            int numEvents);
}
