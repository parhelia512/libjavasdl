package org.libsdl.api.bits;

public final class SdlBits {

    private static final int[] BITMASKS = {0b10, 0b1100, 0b11110000, 0xFF00, 0xFFFF0000};
    private static final int[] INDICES = {1, 2, 4, 8, 16};

    private SdlBits() {
    }

    public static int SDL_MostSignificantBitIndex32(
            int x) {
        if (x == 0) {
            return -1;
        }

        int msbIndex = 0;
        int i;
        for (i = 4; i >= 0; i--) {
            if ((x & BITMASKS[i]) != 0) {
                x >>= INDICES[i];
                msbIndex |= INDICES[i];
            }
        }

        return msbIndex;
    }

    public static boolean SDL_HasExactlyOneBitSet32(
            int x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }
}
