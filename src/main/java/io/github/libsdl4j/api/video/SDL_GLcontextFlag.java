package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Flags for OpenGL attribute key {@link SDL_GLattr#SDL_GL_CONTEXT_FLAGS}.
 *
 * <p>To be OR'd and passed to {@code SDL_GL_SetAttribute(SDL_GL_CONTEXT_FLAGS, flags)}</p>
 *
 * @see SdlVideo#SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, ...)
 */
public final class SDL_GLcontextFlag implements JnaEnum {

    /** @see SDL_GLattr#SDL_GL_CONTEXT_FLAGS */
    public static final int SDL_GL_CONTEXT_DEBUG_FLAG = 0x0001;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_FLAGS */
    public static final int SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG = 0x0002;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_FLAGS */
    public static final int SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG = 0x0004;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_FLAGS */
    public static final int SDL_GL_CONTEXT_RESET_ISOLATION_FLAG = 0x0008;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_GL_CONTEXT_DEBUG_FLAG) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_DEBUG_FLAG");
        }
        if ((type & SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG");
        }
        if ((type & SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG");
        }
        if ((type & SDL_GL_CONTEXT_RESET_ISOLATION_FLAG) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_RESET_ISOLATION_FLAG");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_GLcontextFlag() {
    }
}
