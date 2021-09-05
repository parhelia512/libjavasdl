package org.libsdl.api.blendmode;

import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.JnaEnum;

public final class SDL_BlendOperation implements JnaEnum {

    public static final int SDL_BLENDOPERATION_ADD = 0x1;
    public static final int SDL_BLENDOPERATION_SUBTRACT = 0x2;
    public static final int SDL_BLENDOPERATION_REV_SUBTRACT = 0x3;
    public static final int SDL_BLENDOPERATION_MINIMUM = 0x4;
    public static final int SDL_BLENDOPERATION_MAXIMUM = 0x5;

    private SDL_BlendOperation() {
    }

    public static class Ref extends IntByReference {

        public Ref() {
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(@MagicConstant(valuesFromClass = SDL_BlendOperation.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_BlendOperation.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
