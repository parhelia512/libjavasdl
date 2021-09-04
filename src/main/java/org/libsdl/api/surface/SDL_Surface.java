package org.libsdl.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import org.libsdl.api.rect.SDL_Rect;

public final class SDL_Surface extends Structure {

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
