package io.github.libsdl4j.api.render;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Flags used when creating a rendering context
 */
public final class SDL_RendererFlags implements JnaEnum {

    /** The renderer is a software fallback */
    public static final int SDL_RENDERER_SOFTWARE = 0x00000001;

    /** The renderer uses hardware acceleration */
    public static final int SDL_RENDERER_ACCELERATED = 0x00000002;

    /** Present is synchronized with the refresh rate */
    public static final int SDL_RENDERER_PRESENTVSYNC = 0x00000004;

    /** The renderer supports  rendering to texture */
    public static final int SDL_RENDERER_TARGETTEXTURE = 0x00000008;

    public static String toString(int value) {
        StringBuilder result = new StringBuilder(26);
        if ((value & SDL_RENDERER_SOFTWARE) > 0) {
            JnaUtils.append(result, "SDL_RENDERER_SOFTWARE");
        }
        if ((value & SDL_RENDERER_ACCELERATED) > 0) {
            JnaUtils.append(result, "SDL_RENDERER_ACCELERATED");
        }
        if ((value & SDL_RENDERER_PRESENTVSYNC) > 0) {
            JnaUtils.append(result, "SDL_RENDERER_PRESENTVSYNC");
        }
        if ((value & SDL_RENDERER_TARGETTEXTURE) > 0) {
            JnaUtils.append(result, "SDL_RENDERER_TARGETTEXTURE");
        }
        if (result.length() != 0) {
            return result.toString();
        } else {
            return JnaUtils.flagsUnknown(value);
        }
    }

    private SDL_RendererFlags() {
    }
}
