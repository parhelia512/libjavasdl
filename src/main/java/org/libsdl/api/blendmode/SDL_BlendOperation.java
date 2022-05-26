package org.libsdl.api.blendmode;

import org.libsdl.jna.JnaEnum;

public final class SDL_BlendOperation implements JnaEnum {

    public static final int SDL_BLENDOPERATION_ADD = 0x1;
    public static final int SDL_BLENDOPERATION_SUBTRACT = 0x2;
    public static final int SDL_BLENDOPERATION_REV_SUBTRACT = 0x3;
    public static final int SDL_BLENDOPERATION_MINIMUM = 0x4;
    public static final int SDL_BLENDOPERATION_MAXIMUM = 0x5;

    private SDL_BlendOperation() {
    }

    // TODO: Generate public static String toString(int value)
}
