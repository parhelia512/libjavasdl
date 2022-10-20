package io.github.libsdl4j.api.keycode;

import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.jna.JnaEnum;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Enumeration of valid key mods (possibly OR'd together).
 */
public final class SDL_Keymod implements JnaEnum {

    public static final int KMOD_NONE = 0x0000;
    public static final int KMOD_LSHIFT = 0x0001;
    public static final int KMOD_RSHIFT = 0x0002;
    public static final int KMOD_LCTRL = 0x0040;
    public static final int KMOD_RCTRL = 0x0080;
    public static final int KMOD_LALT = 0x0100;
    public static final int KMOD_RALT = 0x0200;
    public static final int KMOD_LGUI = 0x0400;
    public static final int KMOD_RGUI = 0x0800;
    public static final int KMOD_NUM = 0x1000;
    public static final int KMOD_CAPS = 0x2000;
    public static final int KMOD_MODE = 0x4000;
    public static final int KMOD_SCROLL = 0x8000;

    public static final int KMOD_CTRL = (KMOD_LCTRL | KMOD_RCTRL);
    public static final int KMOD_SHIFT = (KMOD_LSHIFT | KMOD_RSHIFT);
    public static final int KMOD_ALT = (KMOD_LALT | KMOD_RALT);
    public static final int KMOD_GUI = (KMOD_LGUI | KMOD_RGUI);

    public static final int KMOD_RESERVED = KMOD_SCROLL;

    // TODO: Generate public static String toString(int value)

    private SDL_Keymod() {
    }

    public static final class Ref extends IntByReference {

        public Ref() {
        }

        public Ref(int ordinal) {
            super(ordinal);
        }

        @Override
        public void setValue(
                @MagicConstant(valuesFromClass = SDL_Keymod.class) int value) {
            super.setValue(value);
        }

        @Override
        @SuppressWarnings("MagicConstant")
        @MagicConstant(valuesFromClass = SDL_Keymod.class)
        public int getValue() {
            return super.getValue();
        }
    }
}
