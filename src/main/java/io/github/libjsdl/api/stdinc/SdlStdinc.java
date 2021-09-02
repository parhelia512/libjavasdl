package io.github.libjsdl.api.stdinc;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"})
public final class SdlStdinc {

    private SdlStdinc() {
    }

    public static int SDL_FOURCC(
            final int a,
            final int b,
            final int c,
            final int d) {
        return (a << 0) | (b << 8) | (c << 16) | (d << 24);
    }
}
