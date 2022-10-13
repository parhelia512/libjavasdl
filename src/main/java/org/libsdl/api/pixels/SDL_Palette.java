package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import io.github.libsdl4j.jna.ContiguousArrayList;

import static org.libsdl.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static org.libsdl.api.endian.SdlEndianConst.SDL_LIL_ENDIAN;

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
public final class SDL_Palette extends PointerType {

    private SDL_Palette_internal semanticStruct;

    public SDL_Palette() {
    }

    public SDL_Palette(Pointer p) {
        super(p);
    }

    public int getNcolors() {
        return (Integer) readField("ncolors");
    }

    public SDL_Color getColors(int index) {
        Pointer colors = (Pointer) readField("colors");
        int colorInt = colors.getInt(index * 4L);
        SDL_Color color = new SDL_Color();
        if (SDL_BYTEORDER == SDL_LIL_ENDIAN) {
            color.r = (byte) (colorInt & 0xFF);
            color.g = (byte) ((colorInt & 0xFF00) >> 8);
            color.b = (byte) ((colorInt & 0xFF0000) >> 16);
            color.a = (byte) ((colorInt & 0xFF000000) >> 24);
        } else {
            color.r = (byte) ((colorInt & 0xFF000000) >> 24);
            color.g = (byte) ((colorInt & 0xFF0000) >> 16);
            color.b = (byte) ((colorInt & 0xFF00) >> 8);
            color.a = (byte) (colorInt & 0xFF);
        }
        return color;
    }

    public int getVersion() {
        return (Integer) readField("version");
    }

    private Object readField(String name) {
        if (semanticStruct == null) {
            semanticStruct = new SDL_Palette_internal(getPointer());
        }
        return semanticStruct.readField(name);
    }
}
