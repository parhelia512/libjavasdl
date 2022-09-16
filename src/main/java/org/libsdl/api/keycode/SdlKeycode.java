package org.libsdl.api.keycode;

public final class SdlKeycode {

    public static final int SDLK_SCANCODE_MASK = 1 << 30;

    public static int SDL_SCANCODE_TO_KEYCODE(
            int x) {
        return x | SDLK_SCANCODE_MASK;
    }
}
