package org.libsdl.api.video;

import org.libsdl.jna.JnaEnum;

public final class SDL_DisplayEventID implements JnaEnum {

    public static final int SDL_DISPLAYEVENT_NONE = 0;
    public static final int SDL_DISPLAYEVENT_ORIENTATION = 1;
    public static final int SDL_DISPLAYEVENT_CONNECTED = 2;
    public static final int SDL_DISPLAYEVENT_DISCONNECTED = 3;

    private SDL_DisplayEventID() {
    }
}
