package org.libsdl.api.stdinc;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"})
public final class SdlStdinc {

    private SdlStdinc() {
    }

    public static int SDL_FOURCC(
            int a,
            int b,
            int c,
            int d) {
        return (a << 0) | (b << 8) | (c << 16) | (d << 24);
    }
}
