package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Values for the OpenGL attribute key {@link SDL_GLattr#SDL_GL_CONTEXT_RELEASE_BEHAVIOR}.
 *
 * <p>Use either:</p>
 * <pre>SDL_GL_SetAttribute(SDL_GL_CONTEXT_RELEASE_BEHAVIOR, SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE);</pre>
 * <p>or</p>
 * <pre>SDL_GL_SetAttribute(SDL_GL_CONTEXT_RELEASE_BEHAVIOR, SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH);</pre>
 *
 * @see SdlVideo#SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, ...)
 */
public final class SDL_GLcontextReleaseFlag implements JnaEnum {

    /** @see SDL_GLattr#SDL_GL_CONTEXT_RELEASE_BEHAVIOR */
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE = 0x0000;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_RELEASE_BEHAVIOR */
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x0001;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE");
        }
        if ((type & SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH");
        }
        if (result.length() == 0) {
            result.append(type);
        }
        return result.toString();
    }

    private SDL_GLcontextReleaseFlag() {
    }
}
