package io.github.libsdl4j.api.endian;

import java.nio.ByteOrder;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_endian.h
 */
public final class SdlEndianConst {

    public static final int SDL_LIL_ENDIAN = 1234;
    public static final int SDL_BIG_ENDIAN = 4321;

    @MagicConstant(intValues = {SDL_LIL_ENDIAN, SDL_BIG_ENDIAN})
    public static final int SDL_BYTEORDER;

    static {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            SDL_BYTEORDER = SDL_BIG_ENDIAN;
        } else {
            SDL_BYTEORDER = SDL_LIL_ENDIAN;
        }
    }

    public static String toString(
            @MagicConstant(intValues = {SDL_LIL_ENDIAN, SDL_BIG_ENDIAN}) int value) {
        switch (value) {
            case SDL_LIL_ENDIAN:
                return "SDL_LIL_ENDIAN";
            case SDL_BIG_ENDIAN:
                return "SDL_BIG_ENDIAN";
            default:
                return "UNKNOWN";
        }
    }

    private SdlEndianConst() {
    }
}
