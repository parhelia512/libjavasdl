package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Possible return values from the SDL_HitTest callback.
 *
 * @see SDL_HitTest
 */
public final class SDL_HitTestResult implements JnaEnum {

    /** Region is normal. No special properties. */
    public static final int SDL_HITTEST_NORMAL = 0;

    /** Region can drag entire window. */
    public static final int SDL_HITTEST_DRAGGABLE = 1;

    public static final int SDL_HITTEST_RESIZE_TOPLEFT = 2;
    public static final int SDL_HITTEST_RESIZE_TOP = 3;
    public static final int SDL_HITTEST_RESIZE_TOPRIGHT = 4;
    public static final int SDL_HITTEST_RESIZE_RIGHT = 5;
    public static final int SDL_HITTEST_RESIZE_BOTTOMRIGHT = 6;
    public static final int SDL_HITTEST_RESIZE_BOTTOM = 7;
    public static final int SDL_HITTEST_RESIZE_BOTTOMLEFT = 8;
    public static final int SDL_HITTEST_RESIZE_LEFT = 9;

    // TODO: Generate public static String toString(int value)

    private SDL_HitTestResult() {
    }
}
