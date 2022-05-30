package org.libsdl.api.messagebox;

import org.libsdl.jna.JnaEnum;

public final class SDL_MessageBoxButtonFlags implements JnaEnum {

    public static final int SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT = 0x00000001;
    public static final int SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT = 0x00000002;

    public static String toString(int value) {
        StringBuilder result = new StringBuilder(39*2 + 3);
        if ((value & SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT) > 0) {
            result.append("SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT");
        }
        if ((value & SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT) > 0) {
            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append("SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT");
        }
        return result.toString();
    }

    private SDL_MessageBoxButtonFlags() {
    }
}
