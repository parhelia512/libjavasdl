package net.mcclendo.libjavasdl.api.pixels;

import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

public final class SDL_Palette extends AbstractSdlStructure {

    public int ncolors;
    public SDL_Color colors;
    public int version;
    public int refcount;
}
