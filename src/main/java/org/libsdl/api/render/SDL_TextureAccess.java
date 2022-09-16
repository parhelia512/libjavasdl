package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;

public final class SDL_TextureAccess implements JnaEnum {

    public static final int SDL_TEXTUREACCESS_STATIC = 0;
    public static final int SDL_TEXTUREACCESS_STREAMING = 1;
    public static final int SDL_TEXTUREACCESS_TARGET = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_TextureAccess() {
    }
}
