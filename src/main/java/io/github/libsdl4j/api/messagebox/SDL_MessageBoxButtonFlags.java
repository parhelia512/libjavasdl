package io.github.libsdl4j.api.messagebox;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * Flags for SDL_MessageBoxButtonData.
 */
public final class SDL_MessageBoxButtonFlags implements JnaEnum {

    /** Marks the default button when return is hit */
    public static final int SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT = 0x00000001;

    /** Marks the default button when escape is hit */
    public static final int SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT = 0x00000002;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(39 * 2 + 3);
        if ((type & SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT");
        }
        if ((type & SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_MessageBoxButtonFlags() {
    }
}
