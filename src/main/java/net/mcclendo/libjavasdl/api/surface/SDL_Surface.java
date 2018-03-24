package net.mcclendo.libjavasdl.api.surface;

import net.mcclendo.libjavasdl.api.rect.SDL_Rect;
import net.mcclendo.libjavasdl.jna.AbstractSdlStructure;

import com.sun.jna.Pointer;

public final class SDL_Surface extends AbstractSdlStructure {
    public int flags;
    public Pointer format;
    public int w;
    public int h;
    public int pitch;
    public Pointer pixels;
    public Pointer userdata;
    public int locked;
    public Pointer lockData;
    public SDL_Rect clipRect;
    public Pointer map;
    public int refcount;
}
