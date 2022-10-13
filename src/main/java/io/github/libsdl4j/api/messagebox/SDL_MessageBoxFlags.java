package io.github.libsdl4j.api.messagebox;

import io.github.libsdl4j.jna.JnaEnum;
import io.github.libsdl4j.jna.JnaUtils;

/**
 * SDL_MessageBox flags. If supported will display warning icon, etc.
 */
public final class SDL_MessageBoxFlags implements JnaEnum {

    /** error dialog */
    public static final int SDL_MESSAGEBOX_ERROR = 0x00000010;

    /** warning dialog */
    public static final int SDL_MESSAGEBOX_WARNING = 0x00000020;

    /** informational dialog */
    public static final int SDL_MESSAGEBOX_INFORMATION = 0x00000040;

    /** buttons placed left to right */
    public static final int SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT = 0x00000080;

    /** buttons placed right to left */
    public static final int SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT = 0x00000100;

    public static String toString(int type) {
        StringBuilder result = new StringBuilder(36);
        if ((type & SDL_MESSAGEBOX_ERROR) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_ERROR");
        }
        if ((type & SDL_MESSAGEBOX_WARNING) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_WARNING");
        }
        if ((type & SDL_MESSAGEBOX_INFORMATION) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_INFORMATION");
        }
        if ((type & SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_BUTTONS_LEFT_TO_RIGHT");
        }
        if ((type & SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT) > 0) {
            JnaUtils.append(result, "SDL_MESSAGEBOX_BUTTONS_RIGHT_TO_LEFT");
        }
        if (result.length() == 0) {
            result.append("0");
        }
        return result.toString();
    }

    private SDL_MessageBoxFlags() {
    }
}
