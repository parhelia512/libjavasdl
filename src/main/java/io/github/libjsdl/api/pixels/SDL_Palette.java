package io.github.libjsdl.api.pixels;

import io.github.libjsdl.jna.AbstractSdlStructure;

public final class SDL_Palette extends AbstractSdlStructure {

    public int ncolors;
    public SDL_Color colors;
    public int version;
    public int refcount;
}
