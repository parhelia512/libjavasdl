package org.libsdl.api.log;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The predefined log priorities
 */
public final class SDL_LogPriority implements JnaEnum {

    public static final int SDL_LOG_PRIORITY_VERBOSE = 1;
    public static final int SDL_LOG_PRIORITY_DEBUG = 2;
    public static final int SDL_LOG_PRIORITY_INFO = 3;
    public static final int SDL_LOG_PRIORITY_WARN = 4;
    public static final int SDL_LOG_PRIORITY_ERROR = 5;
    public static final int SDL_LOG_PRIORITY_CRITICAL = 6;
    public static final int SDL_NUM_LOG_PRIORITIES = 7;

    // TODO: Generate public static String toString(int value)

    private SDL_LogPriority() {
    }
}
