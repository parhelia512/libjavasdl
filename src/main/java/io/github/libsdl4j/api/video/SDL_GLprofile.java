package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Values for the OpenGL attribute key {@link SDL_GLattr#SDL_GL_CONTEXT_PROFILE_MASK}.
 *
 * <p>To be passed to {@code SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, value)}</p>
 *
 * @see SdlVideo#SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, ...)
 */
public final class SDL_GLprofile implements JnaEnum {

    /** @see SDL_GLattr#SDL_GL_CONTEXT_PROFILE_MASK */
    public static final int SDL_GL_CONTEXT_PROFILE_CORE = 0x0001;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_PROFILE_MASK */
    public static final int SDL_GL_CONTEXT_PROFILE_COMPATIBILITY = 0x0002;

    /**
     * GLX_CONTEXT_ES2_PROFILE_BIT_EXT
     *
     * @see SDL_GLattr#SDL_GL_CONTEXT_PROFILE_MASK
     */
    public static final int SDL_GL_CONTEXT_PROFILE_ES = 0x0004;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_GL_CONTEXT_PROFILE_CORE) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_PROFILE_CORE");
        }
        if ((type & SDL_GL_CONTEXT_PROFILE_COMPATIBILITY) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_PROFILE_COMPATIBILITY");
        }
        if ((type & SDL_GL_CONTEXT_PROFILE_ES) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_PROFILE_ES");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_GLprofile() {
    }
}
