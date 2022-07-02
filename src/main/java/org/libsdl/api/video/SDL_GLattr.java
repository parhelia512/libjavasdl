package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_GLattr implements JnaEnum {

    public static final int SDL_GL_RED_SIZE = 0;
    public static final int SDL_GL_GREEN_SIZE = 1;
    public static final int SDL_GL_BLUE_SIZE = 2;
    public static final int SDL_GL_ALPHA_SIZE = 3;
    public static final int SDL_GL_BUFFER_SIZE = 4;
    public static final int SDL_GL_DOUBLEBUFFER = 5;
    public static final int SDL_GL_DEPTH_SIZE = 6;
    public static final int SDL_GL_STENCIL_SIZE = 7;
    public static final int SDL_GL_ACCUM_RED_SIZE = 8;
    public static final int SDL_GL_ACCUM_GREEN_SIZE = 9;
    public static final int SDL_GL_ACCUM_BLUE_SIZE = 10;
    public static final int SDL_GL_ACCUM_ALPHA_SIZE = 11;
    public static final int SDL_GL_STEREO = 12;
    public static final int SDL_GL_MULTISAMPLEBUFFERS = 13;
    public static final int SDL_GL_MULTISAMPLESAMPLES = 14;
    public static final int SDL_GL_ACCELERATED_VISUAL = 15;
    public static final int SDL_GL_RETAINED_BACKING = 16;
    public static final int SDL_GL_CONTEXT_MAJOR_VERSION = 17;
    public static final int SDL_GL_CONTEXT_MINOR_VERSION = 18;
    public static final int SDL_GL_CONTEXT_EGL = 19;
    public static final int SDL_GL_CONTEXT_FLAGS = 20;
    public static final int SDL_GL_CONTEXT_PROFILE_MASK = 21;
    public static final int SDL_GL_SHARE_WITH_CURRENT_CONTEXT = 22;
    public static final int SDL_GL_FRAMEBUFFER_SRGB_CAPABLE = 23;
    public static final int SDL_GL_CONTEXT_RELEASE_BEHAVIOR = 24;
    public static final int SDL_GL_CONTEXT_RESET_NOTIFICATION = 25;
    public static final int SDL_GL_CONTEXT_NO_ERROR = 26;

    // TODO: Generate public static String toString(int value)

    private SDL_GLattr() {
    }
}
