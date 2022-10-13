package io.github.libsdl4j.api.keycode;

/**
 * Definitions from file SDL_keycode.h
 *
 * <p>Defines constants which identify keyboard keys and modifiers.</p>
 */
public final class SdlKeycode {

    public static final int SDLK_SCANCODE_MASK = 1 << 30;

    public static int SDL_SCANCODE_TO_KEYCODE(
            int x) {
        return x | SDLK_SCANCODE_MASK;
    }

    private SdlKeycode() {
    }
}
