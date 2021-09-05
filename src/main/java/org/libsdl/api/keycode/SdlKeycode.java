package org.libsdl.api.keycode;

public class SdlKeycode {

    public static int SDL_SCANCODE_TO_KEYCODE(
            int x) {
        return x | SdlKeycodeConst.SDLK_SCANCODE_MASK;
    }
}
