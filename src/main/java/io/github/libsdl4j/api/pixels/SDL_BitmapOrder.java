package io.github.libsdl4j.api.pixels;

import io.github.libsdl4j.jna.JnaEnum;

/** Bitmap pixel order, high bit to low bit. */
public final class SDL_BitmapOrder implements JnaEnum {

    public static final int SDL_BITMAPORDER_NONE = 0;
    public static final int SDL_BITMAPORDER_4321 = 1;
    public static final int SDL_BITMAPORDER_1234 = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_BitmapOrder() {
    }
}
