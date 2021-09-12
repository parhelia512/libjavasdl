package org.libsdl.api.messagebox;

import org.libsdl.jna.JnaEnum;

public final class SDL_MessageBoxButtonFlags implements JnaEnum {

    public static final int SDL_MESSAGEBOX_BUTTON_RETURNKEY_DEFAULT = 0x00000001;
    public static final int SDL_MESSAGEBOX_BUTTON_ESCAPEKEY_DEFAULT = 0x00000002;

    private SDL_MessageBoxButtonFlags() {
    }
}
