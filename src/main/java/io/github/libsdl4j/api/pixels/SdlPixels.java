package io.github.libsdl4j.api.pixels;

import java.util.List;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import io.github.libsdl4j.api.video.SDL_Window;
import io.github.libsdl4j.jna.JnaUtils;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_pixels.h
 *
 * <p>Header for the enumerated pixel format definitions.</p>
 */
public final class SdlPixels {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlPixels.class);
    }

    private SdlPixels() {
    }

    /**
     * Get the human readable name of a pixel format.
     *
     * @param format the pixel format to query
     * @return the human readable name of the specified pixel format or
     * {@code SDL_PIXELFORMAT_UNKNOWN} if the format isn't recognized.
     * @since This function is available since SDL 2.0.0.
     */
    public static native String SDL_GetPixelFormatName(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format);

    /**
     * Convert one of the enumerated pixel formats to a bpp value and RGBA masks.
     *
     * @param format one of the SDL_PixelFormatEnum values
     * @param bpp    a bits per pixel value; usually 15, 16, or 32
     * @param rMask  a pointer filled in with the red mask for the format
     * @param gMask  a pointer filled in with the green mask for the format
     * @param bMask  a pointer filled in with the blue mask for the format
     * @param aMask  a pointer filled in with the alpha mask for the format
     * @return true on success or false if the conversion wasn't
     * possible; call SDL_GetError() for more information.
     * @see #SDL_MasksToPixelFormatEnum(int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_PixelFormatEnumToMasks(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format,
            IntByReference bpp,
            IntByReference rMask,
            IntByReference gMask,
            IntByReference bMask,
            IntByReference aMask);

    /**
     * Convert a bpp value and RGBA masks to an enumerated pixel format.
     *
     * <p>This will return {@code SDL_PIXELFORMAT_UNKNOWN} if the conversion wasn't
     * possible.</p>
     *
     * @param bpp   a bits per pixel value; usually 15, 16, or 32
     * @param rMask the red mask for the format
     * @param gMask the green mask for the format
     * @param bMask the blue mask for the format
     * @param aMask the alpha mask for the format
     * @return one of the SDL_PixelFormatEnum values
     * @see #SDL_PixelFormatEnumToMasks(int, IntByReference, IntByReference, IntByReference, IntByReference, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public static native int SDL_MasksToPixelFormatEnum(
            int bpp,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    /**
     * Create an SDL_PixelFormat structure corresponding to a pixel format.
     *
     * <p>Returned structure may come from a shared global cache (i.e. not newly
     * allocated), and hence should not be modified, especially the palette. Weird
     * errors such as {@code Blit combination not supported} may occur.</p>
     *
     * @param pixelFormat one of the SDL_PixelFormatEnum values
     * @return the new SDL_PixelFormat structure or null on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_FreeFormat(SDL_PixelFormat)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_PixelFormat SDL_AllocFormat(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int pixelFormat);

    /**
     * Free an SDL_PixelFormat structure allocated by SDL_AllocFormat().
     *
     * @param format the SDL_PixelFormat structure to free
     * @see #SDL_AllocFormat(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreeFormat(
            SDL_PixelFormat format);

    /**
     * Create a palette structure with the specified number of color entries.
     *
     * <p>The palette entries are initialized to white.</p>
     *
     * @param ncolors represents the number of color entries in the color palette
     * @return a new SDL_Palette structure on success or null on failure (e.g. if
     * there wasn't enough memory); call SDL_GetError() for more
     * information.
     * @see #SDL_FreePalette(SDL_Palette)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Palette SDL_AllocPalette(
            int ncolors);

    /**
     * Set the palette for a pixel format structure.
     *
     * @param format  the SDL_PixelFormat structure that will use the palette
     * @param palette the SDL_Palette structure that will be used
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_AllocPalette(int)
     * @see #SDL_FreePalette(SDL_Palette)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetPixelFormatPalette(
            SDL_PixelFormat format,
            SDL_Palette palette);

    /**
     * Set a range of colors in a palette.
     *
     * <p>This is a Java-style version of the raw C-style {@link #SDL_SetPaletteColors(SDL_Palette, Pointer, int, int)}.
     * Prefer this function to the raw C-style one.</p>
     *
     * @param palette    the SDL_Palette structure to modify
     * @param colors     an array of SDL_Color structures to copy into the palette
     * @param firstcolor the index of the first palette entry to modify
     * @param ncolors    the number of entries to modify
     * @return 0 on success or a negative error code if not all of the colors
     * could be set; call SDL_GetError() for more information.
     * @see #SDL_AllocPalette(int)
     * @see io.github.libsdl4j.api.surface.SdlSurface#SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_SetPaletteColors(
            SDL_Palette palette,
            List<SDL_Color> colors,
            int firstcolor,
            int ncolors) {
        if (colors.size() == 0) {
            return 0;
        }
        if (ncolors > colors.size()) {
            throw new IllegalArgumentException("ncolors [" + ncolors + "] is greater than the size of the list of colors [" + colors.size() + "]");
        }
        try (Memory buffer = JnaUtils.writeListToNativeMemory(colors)) {
            return SDL_SetPaletteColors(palette, buffer, firstcolor, ncolors);
        }
    }

    /**
     * Set a range of colors in a palette.
     *
     * <p>This is a raw C-style version of the function.
     * Prefer more Java-style {@link #SDL_SetPaletteColors(SDL_Palette, List, int, int)}.</p>
     *
     * @param palette    the SDL_Palette structure to modify
     * @param colors     an array of SDL_Color structures to copy into the palette
     * @param firstcolor the index of the first palette entry to modify
     * @param ncolors    the number of entries to modify
     * @return 0 on success or a negative error code if not all of the colors
     * could be set; call SDL_GetError() for more information.
     * @see #SDL_AllocPalette(int)
     * @see io.github.libsdl4j.api.surface.SdlSurface#SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetPaletteColors(
            SDL_Palette palette,
            Pointer colors,
            int firstcolor,
            int ncolors);

    /**
     * Free a palette created with SDL_AllocPalette().
     *
     * @param palette the SDL_Palette structure to be freed
     * @see #SDL_AllocPalette(int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreePalette(
            SDL_Palette palette);

    /**
     * Map an RGB triple to an opaque pixel value for a given pixel format.
     *
     * <p>This function maps the RGB color value to the specified pixel format and
     * returns the pixel value best approximating the given RGB color value for
     * the given pixel format.</p>
     *
     * <p>If the format has a palette (8-bit) the index of the closest matching color
     * in the palette will be returned.</p>
     *
     * <p>If the specified pixel format has an alpha component it will be returned as
     * all 1 bits (fully opaque).</p>
     *
     * <p>If the pixel format bpp (color depth) is less than 32-bpp then the unused
     * upper bits of the return value can safely be ignored (e.g., with a 16-bpp
     * format the return value can be assigned to a Uint16, and similarly a Uint8
     * for an 8-bpp format).</p>
     *
     * @param format an SDL_PixelFormat structure describing the pixel format
     * @param r      the red component of the pixel in the range 0-255
     * @param g      the green component of the pixel in the range 0-255
     * @param b      the blue component of the pixel in the range 0-255
     * @return a pixel value
     * @see #SDL_GetRGB(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_GetRGBA(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_MapRGBA(SDL_PixelFormat, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_MapRGB(
            SDL_PixelFormat format,
            byte r,
            byte g,
            byte b);

    /**
     * Map an RGBA quadruple to a pixel value for a given pixel format.
     *
     * <p>This function maps the RGBA color value to the specified pixel format and
     * returns the pixel value best approximating the given RGBA color value for
     * the given pixel format.</p>
     *
     * <p>If the specified pixel format has no alpha component the alpha value will
     * be ignored (as it will be in formats with a palette).</p>
     *
     * <p>If the format has a palette (8-bit) the index of the closest matching color
     * in the palette will be returned.</p>
     *
     * <p>If the pixel format bpp (color depth) is less than 32-bpp then the unused
     * upper bits of the return value can safely be ignored (e.g., with a 16-bpp
     * format the return value can be assigned to a Uint16, and similarly a Uint8
     * for an 8-bpp format).</p>
     *
     * @param format an SDL_PixelFormat structure describing the format of the
     *               pixel
     * @param r      the red component of the pixel in the range 0-255
     * @param g      the green component of the pixel in the range 0-255
     * @param b      the blue component of the pixel in the range 0-255
     * @param a      the alpha component of the pixel in the range 0-255
     * @return a pixel value
     * @see #SDL_GetRGB(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_GetRGBA(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_MapRGB(SDL_PixelFormat, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_MapRGBA(
            SDL_PixelFormat format,
            byte r,
            byte g,
            byte b,
            byte a);

    /**
     * Get RGB values from a pixel in the specified format.
     *
     * <p>This function uses the entire 8-bit [0..255] range when converting color
     * components from pixel formats with less than 8-bits per RGB component
     * (e.g., a completely white pixel in 16-bit RGB565 format would return [0xff,
     * 0xff, 0xff] not [0xf8, 0xfc, 0xf8]).</p>
     *
     * @param pixel  a pixel value
     * @param format an SDL_PixelFormat structure describing the format of the
     *               pixel
     * @param r      a pointer filled in with the red component
     * @param g      a pointer filled in with the green component
     * @param b      a pointer filled in with the blue component
     * @see #SDL_GetRGBA(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_MapRGB(SDL_PixelFormat, byte, byte, byte)
     * @see #SDL_MapRGBA(SDL_PixelFormat, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetRGB(
            int pixel,
            SDL_PixelFormat format,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    /**
     * Get RGBA values from a pixel in the specified format.
     *
     * <p>This function uses the entire 8-bit [0..255] range when converting color
     * components from pixel formats with less than 8-bits per RGB component
     * (e.g., a completely white pixel in 16-bit RGB565 format would return [0xff,
     * 0xff, 0xff] not [0xf8, 0xfc, 0xf8]).</p>
     *
     * <p>If the surface has no alpha component, the alpha will be returned as 0xff
     * (100% opaque).</p>
     *
     * @param pixel  a pixel value
     * @param format an SDL_PixelFormat structure describing the format of the
     *               pixel
     * @param r      a pointer filled in with the red component
     * @param g      a pointer filled in with the green component
     * @param b      a pointer filled in with the blue component
     * @param a      a pointer filled in with the alpha component
     * @see #SDL_GetRGB(int, SDL_PixelFormat, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_MapRGB(SDL_PixelFormat, byte, byte, byte)
     * @see #SDL_MapRGBA(SDL_PixelFormat, byte, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetRGBA(
            int pixel,
            SDL_PixelFormat format,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b,
            ByteByReference a);

    /**
     * Calculate a 256 entry gamma ramp for a gamma value.
     *
     * @param gamma a gamma value where 0.0 is black and 1.0 is identity
     * @param ramp  an array of 256 values filled in with the gamma ramp
     * @see io.github.libsdl4j.api.video.SdlVideo#SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[]) SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_CalculateGammaRamp(
            float gamma,
            ShortByReference ramp);
}
