package io.github.libsdl4j.api.pixels;

import io.github.libsdl4j.jna.JnaEnum;

/** Packed component order, high bit to low bit. */
public final class SDL_PackedOrder implements JnaEnum {

    public static final int SDL_PACKEDORDER_NONE = 0;
    public static final int SDL_PACKEDORDER_XRGB = 1;
    public static final int SDL_PACKEDORDER_RGBX = 2;
    public static final int SDL_PACKEDORDER_ARGB = 3;
    public static final int SDL_PACKEDORDER_RGBA = 4;
    public static final int SDL_PACKEDORDER_XBGR = 5;
    public static final int SDL_PACKEDORDER_BGRX = 6;
    public static final int SDL_PACKEDORDER_ABGR = 7;
    public static final int SDL_PACKEDORDER_BGRA = 8;

    // TODO: Generate public static String toString(int value)

    private SDL_PackedOrder() {
    }
}
