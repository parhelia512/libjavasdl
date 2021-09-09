package org.libsdl.api.endian;

import java.nio.ByteOrder;
import org.intellij.lang.annotations.MagicConstant;

public class SdlEndianConst {

    public static final int SDL_LIL_ENDIAN = 1234;
    public static final int SDL_BIG_ENDIAN = 4321;

    @MagicConstant(valuesFromClass = SdlEndianConst.class)
    public static final int SDL_BYTEORDER;

    static {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            SDL_BYTEORDER = SDL_BIG_ENDIAN;
        } else {
            SDL_BYTEORDER = SDL_LIL_ENDIAN;
        }
    }
}
