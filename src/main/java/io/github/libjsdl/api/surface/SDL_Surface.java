package io.github.libjsdl.api.surface;

import com.sun.jna.Pointer;

import io.github.libjsdl.api.rect.SDL_Rect;
import io.github.libjsdl.jna.AbstractSdlStructure;

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
