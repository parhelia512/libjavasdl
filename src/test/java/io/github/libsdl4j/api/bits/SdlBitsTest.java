package io.github.libsdl4j.api.bits;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.bits.SdlBits.SDL_HasExactlyOneBitSet32;
import static io.github.libsdl4j.api.bits.SdlBits.SDL_MostSignificantBitIndex32;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SdlBitsTest {

    public static final boolean PERFORM_SPEED_TEST = true;

    @Test
    @Disabled
    void testMostSignificantBitIndex32() {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            int correctMostSignificantIndex = calculateMostSignificantBitSlowlyButSurely(i);
            assertEquals(correctMostSignificantIndex, SDL_MostSignificantBitIndex32(i));
        }

        if (PERFORM_SPEED_TEST) {
            long sdlVersionStartTime = System.currentTimeMillis();
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                SDL_MostSignificantBitIndex32(i);
            }
            long sdlVersionEndTime = System.currentTimeMillis();
            System.out.println("Sophisticated SDL version [ms]: " + (sdlVersionEndTime - sdlVersionStartTime));

            long loopVersionStartTime = System.currentTimeMillis();
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                calculateMostSignificantBitSlowlyButSurely(i);
            }
            long loopVersionEndTime = System.currentTimeMillis();
            System.out.println("Simple version [ms]: " + (loopVersionEndTime - loopVersionStartTime));
        }
    }

    private int calculateMostSignificantBitSlowlyButSurely(int value) {
        int mask = 0b1000_0000__0000_0000__0000_0000__0000_0000;
        int position = 31;
        while (mask != 0) {
            if ((value & mask) != 0) {
                return position;
            }
            mask = mask >>> 1;
            position--;
        }
        return position;
    }

    @Test
    @Disabled
    public void testHasExactlyOneBitSet32() {
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            boolean correct = calculateExactlyOneBitSetSlowlyButSurely(i);
            assertEquals(correct, SDL_HasExactlyOneBitSet32(i));
        }

        if (PERFORM_SPEED_TEST) {
            System.out.println("Speed test initiated");

            long sdlVersionStartTime = System.currentTimeMillis();
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                SDL_HasExactlyOneBitSet32(i);
            }
            long sdlVersionEndTime = System.currentTimeMillis();
            System.out.println("Sophisticated SDL version [ms]: " + (sdlVersionEndTime - sdlVersionStartTime));

            long loopVersionStartTime = System.currentTimeMillis();
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                calculateExactlyOneBitSetSlowlyButSurely(i);
            }
            long loopVersionEndTime = System.currentTimeMillis();
            System.out.println("Simple version [ms]: " + (loopVersionEndTime - loopVersionStartTime));
        }
    }

    private boolean calculateExactlyOneBitSetSlowlyButSurely(int value) {
        int mask = 0b1000_0000__0000_0000__0000_0000__0000_0000;
        while (mask != 0) {
            if (value == mask) {
                return true;
            }
            mask = mask >>> 1;
        }
        return false;
    }
}
