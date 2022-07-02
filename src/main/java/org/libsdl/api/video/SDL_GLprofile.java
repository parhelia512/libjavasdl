package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public final class SDL_GLprofile implements JnaEnum {

    public static final int SDL_GL_CONTEXT_PROFILE_CORE = 0x0001;
    public static final int SDL_GL_CONTEXT_PROFILE_COMPATIBILITY = 0x0002;
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
