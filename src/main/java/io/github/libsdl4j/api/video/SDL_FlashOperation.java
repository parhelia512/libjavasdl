package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * Window flash operation
 */
public final class SDL_FlashOperation implements JnaEnum {

    /** Cancel any window flash state */
    public static final int SDL_FLASH_CANCEL = 0;

    /** Flash the window briefly to get attention */
    public static final int SDL_FLASH_BRIEFLY = 1;

    /** Flash the window until it gets focus */
    public static final int SDL_FLASH_UNTIL_FOCUSED = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_FlashOperation() {
    }
}
