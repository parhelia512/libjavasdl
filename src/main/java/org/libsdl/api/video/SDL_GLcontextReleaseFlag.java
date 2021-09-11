package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_GLcontextReleaseFlag implements JnaEnum {

    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_NONE = 0x0000;
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x0001;

    private SDL_GLcontextReleaseFlag() {
    }
}
