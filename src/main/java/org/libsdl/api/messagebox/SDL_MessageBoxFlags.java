package org.libsdl.api.messagebox;

import org.libsdl.jna.JnaEnum;

public final class SDL_MessageBoxFlags implements JnaEnum {

    public static final int SDL_MESSAGEBOX_ERROR = 0x00000010;
    public static final int SDL_MESSAGEBOX_WARNING = 0x00000020;
    public static final int SDL_MESSAGEBOX_INFORMATION = 0x00000040;
    public static final int SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT = 0x00000080;
    public static final int SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT = 0x00000100;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_MESSAGEBOX_ERROR) > 0) {
            append(result, "SDL_MESSAGEBOX_ERROR");
        }
        if ((type & SDL_MESSAGEBOX_WARNING) > 0) {
            append(result, "SDL_MESSAGEBOX_WARNING");
        }
        if ((type & SDL_MESSAGEBOX_INFORMATION) > 0) {
            append(result, "SDL_MESSAGEBOX_INFORMATION");
        }
        if ((type & SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT) > 0) {
            append(result, "SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT");
        }
        if ((type & SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT) > 0) {
            append(result, "SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private static void append(StringBuilder result, String name) {
        if (result.length() > 0) {
            result.append(" | ");
        }
        result.append(name);
    }

    private SDL_MessageBoxFlags() {
    }
}
