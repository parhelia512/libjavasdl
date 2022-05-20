package org.libsdl.api.render;

import org.libsdl.jna.JnaEnum;

public class SDL_RendererFlags implements JnaEnum {

    public static final int SDL_RENDERER_SOFTWARE = 0x00000001;
    public static final int SDL_RENDERER_ACCELERATED = 0x00000002;
    public static final int SDL_RENDERER_PRESENTVSYNC = 0x00000004;
    public static final int SDL_RENDERER_TARGETTEXTURE = 0x00000008;

    private SDL_RendererFlags() {
    }
}
