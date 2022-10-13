package io.github.libsdl4j.api.log;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The predefined log categories. Also known as logger names.
 *
 * <p>By default the application category is enabled at the INFO level,
 * the assert category is enabled at the WARN level, test is enabled
 * at the VERBOSE level and all other categories are enabled at the
 * CRITICAL level.</p>
 */
public final class SDL_LogCategory implements JnaEnum {

    public static final int SDL_LOG_CATEGORY_APPLICATION = 0;
    public static final int SDL_LOG_CATEGORY_ERROR = 1;
    public static final int SDL_LOG_CATEGORY_ASSERT = 2;
    public static final int SDL_LOG_CATEGORY_SYSTEM = 3;
    public static final int SDL_LOG_CATEGORY_AUDIO = 4;
    public static final int SDL_LOG_CATEGORY_VIDEO = 5;
    public static final int SDL_LOG_CATEGORY_RENDER = 6;
    public static final int SDL_LOG_CATEGORY_INPUT = 7;
    public static final int SDL_LOG_CATEGORY_TEST = 8;

    /* Reserved for future SDL library use */
    public static final int SDL_LOG_CATEGORY_RESERVED1 = 9;
    public static final int SDL_LOG_CATEGORY_RESERVED2 = 10;
    public static final int SDL_LOG_CATEGORY_RESERVED3 = 11;
    public static final int SDL_LOG_CATEGORY_RESERVED4 = 12;
    public static final int SDL_LOG_CATEGORY_RESERVED5 = 13;
    public static final int SDL_LOG_CATEGORY_RESERVED6 = 14;
    public static final int SDL_LOG_CATEGORY_RESERVED7 = 15;
    public static final int SDL_LOG_CATEGORY_RESERVED8 = 16;
    public static final int SDL_LOG_CATEGORY_RESERVED9 = 17;
    public static final int SDL_LOG_CATEGORY_RESERVED10 = 18;

    /* Beyond this point is reserved for application use, e.g. 19, 20, 21, ... */
    public static final int SDL_LOG_CATEGORY_CUSTOM = 19;

    // TODO: Generate public static String toString(int value)

    private SDL_LogCategory() {
    }
}
