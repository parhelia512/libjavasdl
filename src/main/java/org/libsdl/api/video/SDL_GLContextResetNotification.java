package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_GLContextResetNotification implements JnaEnum {

    public static final int SDL_GL_CONTEXT_RESET_NO_NOTIFICATION = 0x0000;
    public static final int SDL_GL_CONTEXT_RESET_LOSE_CONTEXT = 0x0001;

    private SDL_GLContextResetNotification() {
    }
}
