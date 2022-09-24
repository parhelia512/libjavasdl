package org.libsdl.api.rwops;

import org.libsdl.jna.JnaEnum;

public final class SDL_RWopsType implements JnaEnum {

    /** Unknown stream type */
    public static final int SDL_RWOPS_UNKNOWN = 0;

    /** Win32 file */
    public static final int SDL_RWOPS_WINFILE = 1;

    /** Stdio file */
    public static final int SDL_RWOPS_STDFILE = 2;

    /** Android asset */
    public static final int SDL_RWOPS_JNIFILE = 3;

    /** Memory stream */
    public static final int SDL_RWOPS_MEMORY = 4;

    /** Read-Only memory stream */
    public static final int SDL_RWOPS_MEMORY_RO = 5;

    /** Vita file */
    public static final int SDL_RWOPS_VITAFILE = 6;

    // TODO: Generate public static String toString(int value)

    private SDL_RWopsType() {
    }
}
