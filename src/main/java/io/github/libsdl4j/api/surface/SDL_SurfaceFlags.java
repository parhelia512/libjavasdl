package io.github.libsdl4j.api.surface;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_SurfaceFlags implements JnaEnum {

    /** Just here for compatibility */
    public static final int SDL_SWSURFACE = 0;

    /** Surface uses preallocated memory */
    public static final int SDL_PREALLOC = 0x00000001;

    /** Surface is RLE encoded */
    public static final int SDL_RLEACCEL = 0x00000002;

    /** Surface is referenced internally */
    public static final int SDL_DONTFREE = 0x00000004;

    /** Surface uses aligned memory */
    public static final int SDL_SIMD_ALIGNED = 0x00000008;

    // TODO: Generate public static String toString(int value)

    private SDL_SurfaceFlags() {
    }
}
