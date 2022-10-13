package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Event subtype for window events.
 *
 * @see io.github.libsdl4j.api.event.events.SDL_WindowEvent SDL_WindowEvent
 */
public final class SDL_WindowEventID implements JnaEnum {

    /** Never used */
    public static final int SDL_WINDOWEVENT_NONE = 0;

    /** Window has been shown */
    public static final int SDL_WINDOWEVENT_SHOWN = 1;

    /** Window has been hidden */
    public static final int SDL_WINDOWEVENT_HIDDEN = 2;

    /** Window has been exposed and should be redrawn */
    public static final int SDL_WINDOWEVENT_EXPOSED = 3;

    /** Window has been moved to data1, data2 */
    public static final int SDL_WINDOWEVENT_MOVED = 4;

    /** Window has been resized to data1 x data2 */
    public static final int SDL_WINDOWEVENT_RESIZED = 5;

    /**
     * The window size has changed, either as
     * a result of an API call or through the
     * system or user changing the window size.
     */
    public static final int SDL_WINDOWEVENT_SIZE_CHANGED = 6;

    /** Window has been minimized */
    public static final int SDL_WINDOWEVENT_MINIMIZED = 7;

    /** Window has been maximized */
    public static final int SDL_WINDOWEVENT_MAXIMIZED = 8;

    /** Window has been restored to normal size and position */
    public static final int SDL_WINDOWEVENT_RESTORED = 9;

    /** Window has gained mouse focus */
    public static final int SDL_WINDOWEVENT_ENTER = 10;

    /** Window has lost mouse focus */
    public static final int SDL_WINDOWEVENT_LEAVE = 11;

    /** Window has gained keyboard focus */
    public static final int SDL_WINDOWEVENT_FOCUS_GAINED = 12;

    /** Window has lost keyboard focus */
    public static final int SDL_WINDOWEVENT_FOCUS_LOST = 13;

    /** The window manager requests that the window be closed */
    public static final int SDL_WINDOWEVENT_CLOSE = 14;

    /** Window is being offered a focus (should SetWindowInputFocus() on itself or a subwindow, or ignore) */
    public static final int SDL_WINDOWEVENT_TAKE_FOCUS = 15;

    /** Window had a hit test that wasn't SDL_HITTEST_NORMAL. */
    public static final int SDL_WINDOWEVENT_HIT_TEST = 16;

    /** The ICC profile of the window's display has changed. */
    public static final int SDL_WINDOWEVENT_ICCPROF_CHANGED = 17;

    /** Window has been moved to display data1. */
    public static final int SDL_WINDOWEVENT_DISPLAY_CHANGE = 18;

    // TODO: Generate public static String toString(int value)

    private SDL_WindowEventID() {
    }
}
