package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;

public class SDL_TextureModulate implements JnaEnum {

    public static final int SDL_TEXTUREMODULATE_NONE = 0x00000000;
    public static final int SDL_TEXTUREMODULATE_COLOR = 0x00000001;
    public static final int SDL_TEXTUREMODULATE_ALPHA = 0x00000002;

    private SDL_TextureModulate() {
    }
}
