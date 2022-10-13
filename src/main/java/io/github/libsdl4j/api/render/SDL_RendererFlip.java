package io.github.libsdl4j.api.render;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Flip constants for SDL_RenderCopyEx
 */
public final class SDL_RendererFlip implements JnaEnum {

    /** Do not flip */
    public static final int SDL_FLIP_NONE = 0x00000000;

    /** flip horizontally */
    public static final int SDL_FLIP_HORIZONTAL = 0x00000001;

    /** flip vertically */
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
