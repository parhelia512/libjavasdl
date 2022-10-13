package io.github.libsdl4j.api.video;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Values for the OpenGL attribute key {@link SDL_GLattr#SDL_GL_CONTEXT_RESET_NOTIFICATION}.
 *
 * <p>To be passed to {@code SDL_GL_SetAttribute(SDL_GL_CONTEXT_FLAGS, value)}</p>
 *
 * @see SdlVideo#SDL_GL_SetAttribute(int, int) SDL_GL_SetAttribute(SDL_GLattr, ...)
 */
public final class SDL_GLContextResetNotification implements JnaEnum {

    /** @see SDL_GLattr#SDL_GL_CONTEXT_RESET_NOTIFICATION */
    public static final int SDL_GL_CONTEXT_RESET_NO_NOTIFICATION = 0x0000;

    /** @see SDL_GLattr#SDL_GL_CONTEXT_RESET_NOTIFICATION */
    public static final int SDL_GL_CONTEXT_RESET_LOSE_CONTEXT = 0x0001;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_GL_CONTEXT_RESET_NO_NOTIFICATION) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_RESET_NO_NOTIFICATION");
        }
        if ((type & SDL_GL_CONTEXT_RESET_LOSE_CONTEXT) > 0) {
            JnaUtils.append(result, "SDL_GL_CONTEXT_RESET_LOSE_CONTEXT");
        }
        if (result.length() == 0) {
            result.append(type);
        }
        return result.toString();
    }

    private SDL_GLContextResetNotification() {
    }
}
