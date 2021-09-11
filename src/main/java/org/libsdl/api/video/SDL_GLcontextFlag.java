package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_GLcontextFlag implements JnaEnum {

    public static final int SDL_GL_CONTEXT_DEBUG_FLAG = 0x0001;
    public static final int SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG = 0x0002;
    public static final int SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG = 0x0004;
    public static final int SDL_GL_CONTEXT_RESET_ISOLATION_FLAG = 0x0008;

    private SDL_GLcontextFlag() {
    }
}
