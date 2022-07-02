package org.libsdl.api.shape;

import com.sun.jna.Union;
import org.libsdl.api.pixels.SDL_Color;

public class SDL_WindowShapeParams extends Union {

    public byte binarizationCutoff;
    public SDL_Color colorKey;
}
