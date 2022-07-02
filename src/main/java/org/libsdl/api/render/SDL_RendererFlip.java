package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public class SDL_RendererFlip implements JnaEnum {

    public static final int SDL_FLIP_NONE = 0x00000000;
    public static final int SDL_FLIP_HORIZONTAL = 0x00000001;
    public static final int SDL_FLIP_VERTICAL = 0x00000002;

    public static String toString(int value) {
        if (value == SDL_FLIP_NONE) {
            return "SDL_FLIP_NONE";
        }
        StringBuilder result = new StringBuilder(19);
        if ((value & SDL_FLIP_HORIZONTAL) > 0) {
            JnaUtils.append(result, "SDL_FLIP_HORIZONTAL");
        }
        if ((value & SDL_FLIP_VERTICAL) > 0) {
            JnaUtils.append(result, "SDL_FLIP_VERTICAL");
        }
        if (result.length() != 0) {
            return result.toString();
        } else {
            return JnaUtils.flagsUnknown(value);
        }
    }

    private SDL_RendererFlip() {
    }
}
