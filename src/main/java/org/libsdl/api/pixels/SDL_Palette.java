package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.ContiguousArrayList;

/**
 * A structure that contains palette information.
 *
 * <p>Each pixel in an 8-bit surface is an index into the {@code colors} field
 * of the {@link SDL_Palette} structure stored in {@link SDL_PixelFormat}.
 * An {@link SDL_Palette} should never need to be created manually.
 * It is automatically created when SDL allocates an {@link SDL_PixelFormat} for a surface.
 * The {@code colors} values of an {@link org.libsdl.api.surface.SDL_Surface SDL_Surface}'s
 * palette can be set with {@link SdlPixels#SDL_SetPaletteColors(SDL_Palette, ContiguousArrayList, int, int) SDL_SetPaletteColors(...)}.
 *
 * @see SDL_PixelFormat
 * @see SdlPixels#SDL_AllocPalette(int) SDL_AllocPalette(...)
 * @see SdlPixels#SDL_FreePalette(SDL_Palette) SDL_FreePalette(...)
 * @see SdlPixels#SDL_SetPaletteColors(SDL_Palette, ContiguousArrayList, int, int) SDL_SetPaletteColors(...)
 */
@Structure.FieldOrder({
        "ncolors",
        "colors",
        "version",
        "refcount"
})
public final class SDL_Palette extends Structure implements Structure.ByReference {

    public int ncolors;
    public Pointer colors;
    public int version;
    public int refcount;

    public SDL_Palette() {
    }

    public SDL_Palette(Pointer p) {
        super(p);
    }
}
