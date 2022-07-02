package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public final class SDL_GLContextResetNotification implements JnaEnum {

    public static final int SDL_GL_CONTEXT_RESET_NO_NOTIFICATION = 0x0000;
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
