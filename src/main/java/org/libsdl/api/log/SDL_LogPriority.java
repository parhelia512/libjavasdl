package org.libsdl.api.log;

import org.libsdl.jna.JnaEnum;

public final class SDL_LogPriority implements JnaEnum {

    public static final int SDL_LOG_PRIORITY_VERBOSE = 1;
    public static final int SDL_LOG_PRIORITY_DEBUG = 2;
    public static final int SDL_LOG_PRIORITY_INFO = 3;
    public static final int SDL_LOG_PRIORITY_WARN = 4;
    public static final int SDL_LOG_PRIORITY_ERROR = 5;
    public static final int SDL_LOG_PRIORITY_CRITICAL = 6;
    public static final int SDL_NUM_LOG_PRIORITIES = 7;

    private SDL_LogPriority() {
    }
}
