package io.github.libsdl4j.api.render;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The access pattern allowed for a texture.
 */
public final class SDL_TextureAccess implements JnaEnum {

    /** Changes rarely, not lockable */
    public static final int SDL_TEXTUREACCESS_STATIC = 0;

    /** Changes frequently, lockable */
    public static final int SDL_TEXTUREACCESS_STREAMING = 1;

    /** Texture can be used as a render target */
    public static final int SDL_TEXTUREACCESS_TARGET = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_TextureAccess() {
    }
}
