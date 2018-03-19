package net.mcclendo.libjavasdl.api.event;

import net.mcclendo.libjavasdl.api.event.events.SDL_Event;
import net.mcclendo.libjavasdl.loader.NativeLoader;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public final class SdlEvents {

    public static final int SDL_RELEASED = 0;
    public static final int SDL_PRESSED = 1;

    public static final int SDL_QUERY = -1;
    public static final int SDL_IGNORE = 0;
    public static final int SDL_DISABLE = 0;
    public static final int SDL_ENABLE = 1;

    static {
        NativeLoader.loadLibrary(
                SdlEvents.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlEvents() {
    }

    public static native void SDL_PumpEvents();

    public static native int SDL_PeepEvents(
            SDL_Event events,
            int numevents,
            int action,
            int minType,
            int maxType);

    public static native boolean SDL_HasEvent(
            int type);

    public static native boolean SDL_HasEvents(
            int minType,
            int maxType);

    public static native void SDL_FlushEvent(
            int type);

    public static native void SDL_FlushEvents(
            int minType,
            int maxType);

    public static native int SDL_PollEvent(
            SDL_Event event);

    public static native int SDL_WaitEvent(
            SDL_Event event);

    public static native int SDL_WaitEventTimeout(
            SDL_Event event,
            int timeout);

    public static native int SDL_PushEvent(
            SDL_Event event);

    public static native void SDL_SetEventFilter(
            SDL_EventFilter filter,
            Pointer userdata);

    public static native boolean SDL_GetEventFilter(
            SDL_EventFilter filter,
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

    public static native byte SDL_EventState(
            int type,
            int state);

    public static byte SDL_GetEventState(
            final int type) {
        return SDL_EventState(type, SDL_QUERY);
    }

    public static native int SDL_RegisterEvents(
            int numevents);
}
