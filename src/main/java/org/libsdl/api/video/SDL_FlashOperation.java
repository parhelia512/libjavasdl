package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_FlashOperation implements JnaEnum {

    public static final int SDL_FLASH_CANCEL = 0;
    public static final int SDL_FLASH_BRIEFLY = 1;
    public static final int SDL_FLASH_UNTIL_FOCUSED = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_FlashOperation() {
    }
}
