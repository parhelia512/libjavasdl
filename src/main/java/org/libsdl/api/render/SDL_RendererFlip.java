package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;

public class SDL_RendererFlip implements JnaEnum {

    public static final int SDL_FLIP_NONE = 0x00000000;
    public static final int SDL_FLIP_HORIZONTAL = 0x00000001;
    public static final int SDL_FLIP_VERTICAL = 0x00000002;

    private SDL_RendererFlip() {
    }
}
