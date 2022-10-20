package io.github.libsdl4j.api.video;

public final class SdlVideoConst {

    /**
     * Used to indicate that you don't care what the window position is.
     */
    public static final int SDL_WINDOWPOS_UNDEFINED_MASK = 0x1FFF0000;

    /**
     * Used to indicate that the window position should be centered.
     */
    public static final int SDL_WINDOWPOS_CENTERED_MASK = 0x2FFF0000;

    public static int SDL_WINDOWPOS_UNDEFINED_DISPLAY(
            int x) {
        return SDL_WINDOWPOS_UNDEFINED_MASK | x;
    }

    public static int SDL_WINDOWPOS_UNDEFINED() {
        return SDL_WINDOWPOS_UNDEFINED_DISPLAY(0);
    }

    public static boolean SDL_WINDOWPOS_ISUNDEFINED(
            int x) {
        return (x & 0xFFFF0000) == SDL_WINDOWPOS_UNDEFINED_MASK;
    }

    public static int SDL_WINDOWPOS_CENTERED_DISPLAY(
            int x) {
        return SDL_WINDOWPOS_CENTERED_MASK | x;
    }

    public static int SDL_WINDOWPOS_CENTERED = SDL_WINDOWPOS_CENTERED_DISPLAY(0);

    public static boolean SDL_WINDOWPOS_ISCENTERED(
            int x) {
        return (((x) & 0xFFFF0000) == SDL_WINDOWPOS_CENTERED_MASK);
    }

    private SdlVideoConst() {
    }
}
