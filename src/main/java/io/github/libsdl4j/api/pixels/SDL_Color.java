package io.github.libsdl4j.api.pixels;

/**
 * The bits of this structure can be directly reinterpreted as an integer-packed
 * color which uses the SDL_PIXELFORMAT_RGBA32 format (SDL_PIXELFORMAT_ABGR8888
 * on little-endian systems and SDL_PIXELFORMAT_RGBA8888 on big-endian systems).
 */
public final class SDL_Color {

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public SDL_Color() {
    }

    public SDL_Color(byte r, byte g, byte b, byte a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public SDL_Color(int r, int g, int b, int a) {
        this.r = (byte) r;
        this.g = (byte) g;
        this.b = (byte) b;
        this.a = (byte) a;
    }

    @Override
    public String toString() {
        return String.format("SDL_Color #%02x%02x%02x,alpha %d",
                r & 255,
                g & 255,
                b & 255,
                a & 255);
    }
}
