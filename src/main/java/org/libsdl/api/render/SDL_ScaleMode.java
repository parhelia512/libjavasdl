package org.libsdl.api.render;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaEnum;

public final class SDL_ScaleMode implements JnaEnum {

    public static final int SDL_ScaleModeNearest = 0;
    public static final int SDL_ScaleModeLinear = 1;
    public static final int SDL_ScaleModeBest = 2;

    // TODO: Generate public static String toString(int value)

    private SDL_ScaleMode() {
    }

    public static final class Ref extends IntByReference {

        public Ref() {
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(
                @MagicConstant(valuesFromClass = SDL_ScaleMode.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_ScaleMode.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
