package org.libsdl.api.endian;

import java.nio.ByteOrder;

public class SdlEndianConst {

    public static final int SDL_LIL_ENDIAN = 1234;
    public static final int SDL_BIG_ENDIAN = 4321;
    public static final int SDL_BYTEORDER;

    static {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            SDL_BYTEORDER = SDL_BIG_ENDIAN;
        } else {
            SDL_BYTEORDER = SDL_LIL_ENDIAN;
        }
    }
}
