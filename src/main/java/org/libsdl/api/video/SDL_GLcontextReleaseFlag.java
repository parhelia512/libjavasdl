package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public final class SDL_GLcontextReleaseFlag implements JnaEnum {

    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE = 0x0000;
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
