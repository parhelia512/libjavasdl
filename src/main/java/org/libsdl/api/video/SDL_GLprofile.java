package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_GLprofile implements JnaEnum {

    public static final int SDL_GL_CONTEXT_PROFILE_CORE = 0x0001;
    public static final int SDL_GL_CONTEXT_PROFILE_COMPATIBILITY = 0x0002;
    public static final int SDL_GL_CONTEXT_PROFILE_ES = 0x0004;

    private SDL_GLprofile() {
    }
}
