package org.libsdl.api.shape;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import org.libsdl.api.pixels.SDL_Color;

/**
 * A union containing parameters for shaped windows.
 */
public final class SDL_WindowShapeParams extends Union {

    /** A cutoff alpha value for binarization of the window shape's alpha channel. */
    public byte binarizationCutoff;

    public SDL_Color colorKey;

    public SDL_WindowShapeParams() {
    }

    public SDL_WindowShapeParams(Pointer p) {
        super(p);
    }
}
