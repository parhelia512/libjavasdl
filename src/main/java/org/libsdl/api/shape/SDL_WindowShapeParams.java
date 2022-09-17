package org.libsdl.api.shape;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import org.libsdl.api.pixels.SDL_Color;

public final class SDL_WindowShapeParams extends Union {

    public byte binarizationCutoff;
    public SDL_Color colorKey;

    public SDL_WindowShapeParams() {
    }

    public SDL_WindowShapeParams(Pointer p) {
        super(p);
    }
}
