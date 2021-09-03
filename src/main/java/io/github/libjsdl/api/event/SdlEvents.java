package io.github.libjsdl.api.event;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import io.github.libjsdl.api.event.events.SDL_Event;
import io.github.libjsdl.jna.NativeLoader;

@SuppressWarnings("checkstyle:DeclarationOrder")
public final class SdlEvents {

    public static final int SDL_RELEASED = 0;
    public static final int SDL_PRESSED = 1;

    /******
     * SDL_EventType
     ******/
    public static final int SDL_FIRSTEVENT = 0;

    public static final int SDL_QUIT = 0x100;
    public static final int SDL_APP_TERMINATING = 0x101;
    public static final int SDL_APP_LOWMEMORY = 0x102;
    public static final int SDL_APP_WILLENTERBACKGROUND = 0x103;
    public static final int SDL_APP_DIDENTERBACKGROUND = 0x104;
    public static final int SDL_APP_WILLENTERFOREGROUND = 0x105;
    public static final int SDL_APP_DIDENTERFOREGROUND = 0x106;

    public static final int SDL_WINDOWEVENT = 0x200;
    public static final int SDL_SYSWMEVENT = 0x201;
    public static final int SDL_KEYDOWN = 0x300;
    public static final int SDL_KEYUP = 0x301;
    public static final int SDL_TEXTEDITING = 0x302;
    public static final int SDL_TEXTINPUT = 0x303;
    public static final int SDL_KEYMAPCHANGED = 0x304;

    public static final int SDL_MOUSEMOTION = 0x400;
    public static final int SDL_MOUSEBUTTONDOWN = 0x401;
    public static final int SDL_MOUSEBUTTONUP = 0x402;
    public static final int SDL_MOUSEWHEEL = 0x403;

    public static final int SDL_JOYAXISMOTION = 0x600;
    public static final int SDL_JOYBALLMOTION = 0x601;
    public static final int SDL_JOYHATMOTION = 0x602;
    public static final int SDL_JOYBUTTONDOWN = 0x603;
    public static final int SDL_JOYBUTTONUP = 0x604;
    public static final int SDL_JOYDEVICEADDED = 0x605;
    public static final int SDL_JOYDEVICEREMOVED = 0x606;

    public static final int SDL_CONTROLLERAXISMOTION = 0x650;
    public static final int SDL_CONTROLLERBUTTONDOWN = 0x651;
    public static final int SDL_CONTROLLERBUTTONUP = 0x652;
    public static final int SDL_CONTROLLERDEVICEADDED = 0x653;
    public static final int SDL_CONTROLLERDEVICEREMOVED = 0x654;
    public static final int SDL_CONTROLLERDEVICEREMAPPED = 0x655;

    public static final int SDL_FINGERDOWN = 0x700;
    public static final int SDL_FINGERUP = 0x701;
    public static final int SDL_FINGERMOTION = 0x702;

    public static final int SDL_DOLLARGESTURE = 0x800;
    public static final int SDL_DOLLARRECORD = 0x801;
    public static final int SDL_MULTIGESTURE = 0x802;

    public static final int SDL_CLIPBOARDUPDATE = 0x900;

    public static final int SDL_DROPFILE = 0x1000;
    public static final int SDL_DROPTEXT = 0x1001;
    public static final int SDL_DROPBEGIN = 0x1002;
    public static final int SDL_DROPCOMPLETE = 0x1003;

    public static final int SDL_AUDIODEVICEADDED = 0x1100;
    public static final int SDL_AUDIODEVICEREMOVED = 0x1101;

    public static final int SDL_RENDER_TARGETS_RESET = 0x2000;
    public static final int SDL_RENDER_DEVICE_RESET = 0x2001;

    public static final int SDL_USEREVENT = 0x8000;

    public static final int SDL_LASTEVENT = 0xFFFF;

    /******
     * SDL_eventaction
     ******/
    public static final int SDL_ADDEVENT = 0;
    public static final int SDL_PEEKEVENT = 1;
    public static final int SDL_GETEVENT = 2;

    static {
        NativeLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    public static native void SDL_PumpEvents();

    public static native int SDL_PeepEvents(
            Pointer events,
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

    public static final int SDL_QUERY = -1;
    public static final int SDL_IGNORE = 0;
    public static final int SDL_DISABLE = 0;
    public static final int SDL_ENABLE = 1;

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
