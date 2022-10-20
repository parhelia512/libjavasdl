package io.github.libsdl4j.api.mouse;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.mouse.SDL_Button.SDL_BUTTON_LEFT;
import static io.github.libsdl4j.api.mouse.SDL_Button.SDL_BUTTON_MIDDLE;
import static io.github.libsdl4j.api.mouse.SDL_Button.SDL_BUTTON_RIGHT;
import static io.github.libsdl4j.api.mouse.SDL_Button.SDL_BUTTON_X1;
import static io.github.libsdl4j.api.mouse.SDL_Button.SDL_BUTTON_X2;

public final class SDL_ButtonMask implements JnaEnum {

    public static final int SDL_BUTTON_LMASK = SDL_BUTTON(SDL_BUTTON_LEFT);
    public static final int SDL_BUTTON_MMASK = SDL_BUTTON(SDL_BUTTON_MIDDLE);
    public static final int SDL_BUTTON_RMASK = SDL_BUTTON(SDL_BUTTON_RIGHT);
    public static final int SDL_BUTTON_X1MASK = SDL_BUTTON(SDL_BUTTON_X1);
    public static final int SDL_BUTTON_X2MASK = SDL_BUTTON(SDL_BUTTON_X2);

    /**
     * Used as a mask when testing buttons in buttonstate.
     *
     * <ul>
     *     <li>Button 1:  Left mouse button</li>
     *     <li>Button 2:  Middle mouse button</li>
     *     <li>Button 3:  Right mouse button</li>
     * </ul>
     */
    public static int SDL_BUTTON(
            @MagicConstant(valuesFromClass = SDL_Button.class) int x) {
        return 1 << (x - 1);
    }

    public static String toString(
            @MagicConstant(flagsFromClass = SDL_ButtonMask.class) int value) {
        StringBuilder result = new StringBuilder(17);
        if ((value & SDL_BUTTON_LMASK) > 0) {
            JnaUtils.append(result, "SDL_BUTTON_LMASK");
        }
        if ((value & SDL_BUTTON_MMASK) > 0) {
            JnaUtils.append(result, "SDL_BUTTON_MMASK");
        }
        if ((value & SDL_BUTTON_RMASK) > 0) {
            JnaUtils.append(result, "SDL_BUTTON_RMASK");
        }
        if ((value & SDL_BUTTON_X1MASK) > 0) {
            JnaUtils.append(result, "SDL_BUTTON_X1MASK");
        }
        if ((value & SDL_BUTTON_X2MASK) > 0) {
            JnaUtils.append(result, "SDL_BUTTON_X2MASK");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_ButtonMask() {
    }
}
