package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;
import org.libsdl.jna.JnaUtils;

public final class SDL_GLcontextFlag implements JnaEnum {

    public static final int SDL_GL_CONTEXT_DEBUG_FLAG = 0x0001;
    public static final int SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG = 0x0002;
    public static final int SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG = 0x0004;
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
