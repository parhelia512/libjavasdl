package io.github.libsdl4j.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.blendmode.SDL_BlendMode;
import io.github.libsdl4j.api.pixels.SDL_Palette;
import io.github.libsdl4j.api.pixels.SDL_PixelFormat;
import io.github.libsdl4j.api.pixels.SDL_PixelFormatEnum;
import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.api.rwops.SDL_RWops;
import io.github.libsdl4j.jna.ContiguousArrayList;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.rwops.SdlRWops.SDL_RWFromFile;
import static io.github.libsdl4j.api.surface.SDL_SurfaceFlags.SDL_RLEACCEL;

/**
 * Definitions from file SDL_surface.h
 *
 * <p>{@link SDL_Surface} management functions.</p>
 */
public final class SdlSurface {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlSurface.class);
    }

    private SdlSurface() {
    }

    /**
     * Evaluates to true if the surface needs to be locked before access.
     */
    public static boolean SDL_MUSTLOCK(
            SDL_Surface s) {
        return (s.getFlags() & SDL_RLEACCEL) != 0;
    }

    /**
     * Allocate a new RGB surface.
     *
     * <p>If {@code depth} is 4 or 8 bits, an empty palette is allocated for the surface.
     * If {@code depth} is greater than 8 bits, the pixel format is set using the
     * [RGBA]mask parameters.</p>
     *
     * <p>The [RGBA]mask parameters are the bitmasks used to extract that color from
     * a pixel. For instance, {@code Rmask} being 0xFF000000 means the red data is
     * stored in the most significant byte. Using zeros for the RGB masks sets a
     * default value, based on the depth. For example:</p>
     *
     * <pre>
     * SDL_CreateRGBSurface(0, w, h, 32, 0, 0, 0, 0);
     * </pre>
     *
     * <p>However, using zero for the Amask results in an Amask of 0.</p>
     *
     * <p>By default surfaces with an alpha mask are set up for blending as with:</p>
     *
     * <pre>
     * SDL_SetSurfaceBlendMode(surface, SDL_BLENDMODE_BLEND)
     * </pre>
     *
     * <p>You can change this by calling SDL_SetSurfaceBlendMode() and selecting a
     * different {@code blendMode}.</p>
     *
     * @param flags  the flags are unused and should be set to 0
     * @param width  the width of the surface
     * @param height the height of the surface
     * @param depth  the depth of the surface in bits
     * @param rMask  the red mask for the pixels
     * @param gMask  the green mask for the pixels
     * @param bMask  the blue mask for the pixels
     * @param aMask  the alpha mask for the pixels
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see #SDL_CreateRGBSurfaceFrom(Pointer, int, int, int, int, int, int, int, int)
     * @see #SDL_CreateRGBSurfaceWithFormat(int, int, int, int, int)
     * @see #SDL_FreeSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_CreateRGBSurface(
            @MagicConstant(intValues = {0}) int flags,
            int width,
            int height,
            int depth,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    /**
     * Allocate a new RGB surface with a specific pixel format.
     *
     * <p>This function operates mostly like SDL_CreateRGBSurface(), except instead
     * of providing pixel color masks, you provide it with a predefined format
     * from SDL_PixelFormatEnum.</p>
     *
     * @param flags  the flags are unused and should be set to 0
     * @param width  the width of the surface
     * @param height the height of the surface
     * @param depth  the depth of the surface in bits
     * @param format the SDL_PixelFormatEnum for the new surface's pixel format.
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see #SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @see #SDL_CreateRGBSurfaceFrom(Pointer, int, int, int, int, int, int, int, int)
     * @see #SDL_FreeSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.5.
     */
    public static native SDL_Surface SDL_CreateRGBSurfaceWithFormat(
            @MagicConstant(intValues = {0}) int flags,
            int width,
            int height,
            int depth,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format);

    /**
     * Allocate a new RGB surface with existing pixel data.
     *
     * <p>This function operates mostly like SDL_CreateRGBSurface(), except it does
     * not allocate memory for the pixel data, instead the caller provides an
     * existing buffer of data for the surface to use.</p>
     *
     * <p>No copy is made of the pixel data. Pixel data is not managed automatically;
     * you must free the surface before you free the pixel data.</p>
     *
     * @param pixels a pointer to existing pixel data
     * @param width  the width of the surface
     * @param height the height of the surface
     * @param depth  the depth of the surface in bits
     * @param pitch  the pitch of the surface in bytes
     * @param rMask  the red mask for the pixels
     * @param gMask  the green mask for the pixels
     * @param bMask  the blue mask for the pixels
     * @param aMask  the alpha mask for the pixels
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see #SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @see #SDL_CreateRGBSurfaceWithFormat(int, int, int, int, int)
     * @see #SDL_FreeSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_CreateRGBSurfaceFrom(
            Pointer pixels,
            int width,
            int height,
            int depth,
            int pitch,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    /**
     * Allocate a new RGB surface with with a specific pixel format and existing
     * pixel data.
     *
     * <p>This function operates mostly like SDL_CreateRGBSurfaceFrom(), except
     * instead of providing pixel color masks, you provide it with a predefined
     * format from SDL_PixelFormatEnum.</p>
     *
     * <p>No copy is made of the pixel data. Pixel data is not managed automatically;
     * you must free the surface before you free the pixel data.</p>
     *
     * @param pixels a pointer to existing pixel data
     * @param width  the width of the surface
     * @param height the height of the surface
     * @param depth  the depth of the surface in bits
     * @param pitch  the pitch of the surface in bytes
     * @param format the SDL_PixelFormatEnum for the new surface's pixel format.
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see #SDL_CreateRGBSurfaceFrom(Pointer, int, int, int, int, int, int, int, int)
     * @see #SDL_CreateRGBSurfaceWithFormat(int, int, int, int, int)
     * @see #SDL_FreeSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.5.
     */
    public static native SDL_Surface SDL_CreateRGBSurfaceWithFormatFrom(
            Pointer pixels,
            int width,
            int height,
            int depth,
            int pitch,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format);

    /**
     * Free an RGB surface.
     *
     * <p>It is safe to pass null to this function.</p>
     *
     * @param surface the SDL_Surface to free.
     * @see #SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @see #SDL_CreateRGBSurfaceFrom(Pointer, int, int, int, int, int, int, int, int)
     * @see #SDL_LoadBMP(String)
     * @see #SDL_LoadBMP_RW(SDL_RWops, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_FreeSurface(
            SDL_Surface surface);

    /**
     * Set the palette used by a surface.
     *
     * <p>A single palette can be shared with many surfaces.</p>
     *
     * @param surface the SDL_Surface structure to update
     * @param palette the SDL_Palette structure to use
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetSurfacePalette(
            SDL_Surface surface,
            SDL_Palette palette);

    /**
     * Set up a surface for directly accessing the pixels.
     *
     * <p>Between calls to SDL_LockSurface() / SDL_UnlockSurface(), you can write to
     * and read from {@code surface.pixels}, using the pixel format stored in
     * {@code surface.format}. Once you are done accessing the surface, you should use
     * SDL_UnlockSurface() to release it.</p>
     *
     * <p>Not all surfaces require locking. If {@code SDL_MUSTLOCK(surface)} evaluates to
     * 0, then you can read and write to the surface at any time, and the pixel
     * format of the surface will not change.</p>
     *
     * @param surface the SDL_Surface structure to be locked
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_MUSTLOCK(SDL_Surface)
     * @see #SDL_UnlockSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_LockSurface(
            SDL_Surface surface);

    /**
     * Release a surface after directly accessing the pixels.
     *
     * @param surface the SDL_Surface structure to be unlocked
     * @see #SDL_LockSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_UnlockSurface(
            SDL_Surface surface);

    /**
     * Load a BMP image from a seekable SDL data stream.
     *
     * <p>The new surface should be freed with SDL_FreeSurface(). Not doing so will
     * result in a memory leak.</p>
     *
     * <p>src is an open SDL_RWops buffer, typically loaded with SDL_RWFromFile.
     * Alternitavely, you might also use the macro SDL_LoadBMP to load a bitmap
     * from a file, convert it to an SDL_Surface and then close the file.</p>
     *
     * @param src     the data stream for the surface
     * @param freesrc non-zero to close the stream after being read
     * @return a pointer to a new SDL_Surface structure or null if there was an
     * error; call SDL_GetError() for more information.
     * @see #SDL_FreeSurface(SDL_Surface)
     * @see io.github.libsdl4j.api.rwops.SdlRWops#SDL_RWFromFile(String, String)
     * @see #SDL_LoadBMP(String)
     * @see #SDL_SaveBMP_RW(SDL_Surface, SDL_RWops, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_LoadBMP_RW(
            SDL_RWops src,
            int freesrc);

    /**
     * Load a surface from a file.
     *
     * <p>Convenience method.</p>
     */
    public static SDL_Surface SDL_LoadBMP(
            String file) {
        return SDL_LoadBMP_RW(SDL_RWFromFile(file, "rb"), 1);
    }

    /**
     * Save a surface to a seekable SDL data stream in BMP format.
     *
     * <p>Surfaces with a 24-bit, 32-bit and paletted 8-bit format get saved in the
     * BMP directly. Other RGB formats with 8-bit or higher get converted to a
     * 24-bit surface or, if they have an alpha mask or a colorkey, to a 32-bit
     * surface before they are saved. YUV and paletted 1-bit and 4-bit formats are
     * not supported.</p>
     *
     * @param surface the SDL_Surface structure containing the image to be saved
     * @param dst     a data stream to save to
     * @param freedst non-zero to close the stream after being written
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_LoadBMP_RW(SDL_RWops, int)
     * @see #SDL_SaveBMP(SDL_Surface, String)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SaveBMP_RW(
            SDL_Surface surface,
            SDL_RWops dst,
            int freedst);

    /**
     * Save a surface to a file.
     *
     * <p>Convenience method.</p>
     */
    public static int SDL_SaveBMP(
            SDL_Surface surface,
            String file) {
        return SDL_SaveBMP_RW(
                surface,
                SDL_RWFromFile(file, "wb"),
                1);
    }

    /**
     * Set the RLE acceleration hint for a surface.
     *
     * <p>If RLE is enabled, color key and alpha blending blits are much faster, but
     * the surface must be locked before directly accessing the pixels.</p>
     *
     * @param surface the SDL_Surface structure to optimize
     * @param flag    0 to disable, non-zero to enable RLE acceleration
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @see #SDL_LockSurface(SDL_Surface)
     * @see #SDL_UnlockSurface(SDL_Surface)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetSurfaceRLE(
            SDL_Surface surface,
            int flag);

    /**
     * Returns whether the surface is RLE enabled
     *
     * <p>It is safe to pass a null {@code surface} here; it will return false.</p>
     *
     * @param surface the SDL_Surface structure to query
     * @return true if the surface is RLE enabled, false otherwise.
     * @see #SDL_SetSurfaceRLE(SDL_Surface, int)
     * @since This function is available since SDL 2.0.14.
     */
    public static native boolean SDL_HasSurfaceRLE(
            SDL_Surface surface);

    /**
     * Set the color key (transparent pixel) in a surface.
     *
     * <p>The color key defines a pixel value that will be treated as transparent in
     * a blit. For example, one can use this to specify that cyan pixels should be
     * considered transparent, and therefore not rendered.</p>
     *
     * <p>It is a pixel of the format used by the surface, as generated by
     * SDL_MapRGB().</p>
     *
     * <p>RLE acceleration can substantially speed up blitting of images with large
     * horizontal runs of transparent pixels. See SDL_SetSurfaceRLE() for details.</p>
     *
     * @param surface the SDL_Surface structure to update
     * @param flag    true to enable color key, false to disable color key
     * @param key     the transparent pixel
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @see #SDL_GetColorKey(SDL_Surface, IntByReference)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetColorKey(
            SDL_Surface surface,
            int flag,
            int key);

    /**
     * Returns whether the surface has a color key
     *
     * <p>It is safe to pass a null {@code surface} here; it will return false.</p>
     *
     * @param surface the SDL_Surface structure to query
     * @return true if the surface has a color key, false otherwise.
     * @see #SDL_SetColorKey(SDL_Surface, int, int)
     * @see #SDL_GetColorKey(SDL_Surface, IntByReference)
     * @since This function is available since SDL 2.0.9.
     */
    public static native boolean SDL_HasColorKey(
            SDL_Surface surface);

    /**
     * Get the color key (transparent pixel) for a surface.
     *
     * <p>The color key is a pixel of the format used by the surface, as generated by
     * SDL_MapRGB().</p>
     *
     * <p>If the surface doesn't have color key enabled this function returns -1.</p>
     *
     * @param surface the SDL_Surface structure to query
     * @param key     a pointer filled in with the transparent pixel
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @see #SDL_SetColorKey(SDL_Surface, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetColorKey(
            SDL_Surface surface,
            IntByReference key);

    /**
     * Set an additional color value multiplied into blit operations.
     *
     * <p>When this surface is blitted, during the blit operation each source color
     * channel is modulated by the appropriate color value according to the
     * following formula:</p>
     *
     * <pre>srcC = srcC * (color / 255)
     * </pre>
     *
     * @param surface the SDL_Surface structure to update
     * @param r       the red color value multiplied into blit operations
     * @param g       the green color value multiplied into blit operations
     * @param b       the blue color value multiplied into blit operations
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetSurfaceColorMod(SDL_Surface, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_SetSurfaceAlphaMod(SDL_Surface, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetSurfaceColorMod(
            SDL_Surface surface,
            byte r,
            byte g,
            byte b);

    /**
     * Get the additional color value multiplied into blit operations.
     *
     * @param surface the SDL_Surface structure to query
     * @param r       a pointer filled in with the current red color value
     * @param g       a pointer filled in with the current green color value
     * @param b       a pointer filled in with the current blue color value
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetSurfaceAlphaMod(SDL_Surface, ByteByReference)
     * @see #SDL_SetSurfaceColorMod(SDL_Surface, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetSurfaceColorMod(
            SDL_Surface surface,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    /**
     * Set an additional alpha value used in blit operations.
     *
     * <p>When this surface is blitted, during the blit operation the source alpha
     * value is modulated by this alpha value according to the following formula:</p>
     *
     * <pre>srcA = srcA * (alpha / 255)
     * </pre>
     *
     * @param surface the SDL_Surface structure to update
     * @param alpha   the alpha value multiplied into blit operations
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetSurfaceAlphaMod(SDL_Surface, ByteByReference)
     * @see #SDL_SetSurfaceColorMod(SDL_Surface, byte, byte, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetSurfaceAlphaMod(
            SDL_Surface surface,
            byte alpha);

    /**
     * Get the additional alpha value used in blit operations.
     *
     * @param surface the SDL_Surface structure to query
     * @param alpha   a pointer filled in with the current alpha value
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetSurfaceColorMod(SDL_Surface, ByteByReference, ByteByReference, ByteByReference)
     * @see #SDL_SetSurfaceAlphaMod(SDL_Surface, byte)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetSurfaceAlphaMod(
            SDL_Surface surface,
            ByteByReference alpha);

    /**
     * Set the blend mode used for blit operations.
     *
     * <p>To copy a surface to another surface (or texture) without blending with the
     * existing data, the blendmode of the SOURCE surface should be set to
     * {@code SDL_BLENDMODE_NONE}.</p>
     *
     * @param surface   the SDL_Surface structure to update
     * @param blendMode the SDL_BlendMode to use for blit blending
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_GetSurfaceBlendMode(SDL_Surface, SDL_BlendMode.Ref)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SetSurfaceBlendMode(
            SDL_Surface surface,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    /**
     * Get the blend mode used for blit operations.
     *
     * @param surface   the SDL_Surface structure to query
     * @param blendMode a pointer filled in with the current SDL_BlendMode
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_SetSurfaceBlendMode(SDL_Surface, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_GetSurfaceBlendMode(
            SDL_Surface surface,
            SDL_BlendMode.Ref blendMode);

    /**
     * Set the clipping rectangle for a surface.
     *
     * <p>When {@code surface} is the destination of a blit, only the area within the clip
     * rectangle is drawn into.</p>
     *
     * <p>Note that blits are automatically clipped to the edges of the source and
     * destination surfaces.</p>
     *
     * @param surface the SDL_Surface structure to be clipped
     * @param rect    the SDL_Rect structure representing the clipping rectangle, or
     *                null to disable clipping
     * @return true if the rectangle intersects the surface, otherwise
     * false and blits will be completely clipped.
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @see #SDL_GetClipRect(SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_SetClipRect(
            SDL_Surface surface,
            SDL_Rect rect);

    /**
     * Get the clipping rectangle for a surface.
     *
     * <p>When {@code surface} is the destination of a blit, only the area within the clip
     * rectangle is drawn into.</p>
     *
     * @param surface the SDL_Surface structure representing the surface to be
     *                clipped
     * @param rect    an SDL_Rect structure filled in with the clipping rectangle for
     *                the surface
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @see #SDL_SetClipRect(SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_GetClipRect(
            SDL_Surface surface,
            SDL_Rect rect);

    /*
     * Creates a new surface identical to the existing surface.
     *
     * <p>The returned surface should be freed with SDL_FreeSurface().</p>
     *
     * @param surface the surface to duplicate.
     * @return a copy of the surface, or null on failure; call SDL_GetError() for
     *          more information.
     */
    public static native SDL_Surface SDL_DuplicateSurface(
            SDL_Surface surface);

    /**
     * Copy an existing surface to a new surface of the specified format.
     *
     * <p>This function is used to optimize images for faster *repeat* blitting. This
     * is accomplished by converting the original and storing the result as a new
     * surface. The new, optimized surface can then be used as the source for
     * future blits, making them faster.</p>
     *
     * @param src   the existing SDL_Surface structure to convert
     * @param fmt   the SDL_PixelFormat structure that the new surface is optimized
     *              for
     * @param flags the flags are unused and should be set to 0; this is a
     *              leftover from SDL 1.2's API
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see io.github.libsdl4j.api.pixels.SdlPixels#SDL_AllocFormat(int)
     * @see #SDL_ConvertSurfaceFormat(SDL_Surface, int, int)
     * @see #SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_ConvertSurface(
            SDL_Surface src,
            SDL_PixelFormat fmt,
            int flags);

    /**
     * Copy an existing surface to a new surface of the specified format enum.
     *
     * <p>This function operates just like SDL_ConvertSurface(), but accepts an
     * SDL_PixelFormatEnum value instead of an SDL_PixelFormat structure. As such,
     * it might be easier to call but it doesn't have access to palette
     * information for the destination surface, in case that would be important.</p>
     *
     * @param src         the existing SDL_Surface structure to convert
     * @param pixelFormat the SDL_PixelFormatEnum that the new surface is
     *                    optimized for
     * @param flags       the flags are unused and should be set to 0; this is a
     *                    leftover from SDL 1.2's API
     * @return the new SDL_Surface structure that is created or null if it fails;
     * call SDL_GetError() for more information.
     * @see io.github.libsdl4j.api.pixels.SdlPixels#SDL_AllocFormat(int)
     * @see #SDL_ConvertSurface(SDL_Surface, SDL_PixelFormat, int)
     * @see #SDL_CreateRGBSurface(int, int, int, int, int, int, int, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native SDL_Surface SDL_ConvertSurfaceFormat(
            SDL_Surface src,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int pixelFormat,
            int flags);

    /**
     * Copy a block of pixels of one format to another format.
     *
     * @param width     the width of the block to copy, in pixels
     * @param height    the height of the block to copy, in pixels
     * @param srcFormat an SDL_PixelFormatEnum value of the {@code src} pixels format
     * @param src       a pointer to the source pixels
     * @param srcPitch  the pitch of the source pixels, in bytes
     * @param dstFormat an SDL_PixelFormatEnum value of the {@code dst} pixels format
     * @param dst       a pointer to be filled in with new pixel data
     * @param dstPitch  the pitch of the destination pixels, in bytes
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_ConvertPixels(
            int width,
            int height,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int srcFormat,
            Pointer src,
            int srcPitch,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int dstFormat,
            Pointer dst,
            int dstPitch);

    /**
     * Premultiply the alpha on a block of pixels.
     *
     * <p>This is safe to use with src == dst, but not for other overlapping areas.</p>
     *
     * <p>This function is currently only implemented for SDL_PIXELFORMAT_ARGB8888.</p>
     *
     * @param width     the width of the block to convert, in pixels
     * @param height    the height of the block to convert, in pixels
     * @param srcFormat an SDL_PixelFormatEnum value of the {@code src} pixels format
     * @param src       a pointer to the source pixels
     * @param srcPitch  the pitch of the source pixels, in bytes
     * @param dstFormat an SDL_PixelFormatEnum value of the {@code dst} pixels format
     * @param dst       a pointer to be filled in with premultiplied pixel data
     * @param dstPitch  the pitch of the destination pixels, in bytes
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @since This function is available since SDL 2.0.18.
     */
    public static native int SDL_PremultiplyAlpha(
            int width,
            int height,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int srcFormat,
            Pointer src,
            int srcPitch,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int dstFormat,
            Pointer dst,
            int dstPitch);

    /**
     * Perform a fast fill of a rectangle with a specific color.
     *
     * <p>{@code color} should be a pixel of the format used by the surface, and can be
     * generated by SDL_MapRGB() or SDL_MapRGBA(). If the color value contains an
     * alpha component then the destination is simply filled with that alpha
     * information, no blending takes place.</p>
     *
     * <p>If there is a clip rectangle set on the destination (set via
     * SDL_SetClipRect()), then this function will fill based on the intersection
     * of the clip rectangle and {@code rect}.</p>
     *
     * @param dst   the SDL_Surface structure that is the drawing target
     * @param rect  the SDL_Rect structure representing the rectangle to fill, or
     *              null to fill the entire surface
     * @param color the color to fill with
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_FillRects(SDL_Surface, ContiguousArrayList, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_FillRect(
            SDL_Surface dst,
            SDL_Rect rect,
            int color);

    /**
     * Perform a fast fill of a set of rectangles with a specific color.
     *
     * <p>{@code color} should be a pixel of the format used by the surface, and can be
     * generated by SDL_MapRGB() or SDL_MapRGBA(). If the color value contains an
     * alpha component then the destination is simply filled with that alpha
     * information, no blending takes place.</p>
     *
     * <p>If there is a clip rectangle set on the destination (set via
     * SDL_SetClipRect()), then this function will fill based on the intersection
     * of the clip rectangle and {@code rect}.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer this function over the raw C-style one.</p>
     *
     * @param dst   the SDL_Surface structure that is the drawing target
     * @param rects a {@code ContiguousArrayList} of SDL_Rects representing the rectangles to fill.
     * @param color the color to fill with
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_FillRect(SDL_Surface, SDL_Rect, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_FillRects(
            SDL_Surface dst,
            ContiguousArrayList<SDL_Rect> rects,
            int color) {
        if (rects.size() == 0) {
            return 0;
        }
        return SDL_FillRects(dst, rects.autoWriteAndGetPointer(), rects.size(), color);
    }

    /**
     * Perform a fast fill of a set of rectangles with a specific color.
     *
     * <p>{@code color} should be a pixel of the format used by the surface, and can be
     * generated by SDL_MapRGB() or SDL_MapRGBA(). If the color value contains an
     * alpha component then the destination is simply filled with that alpha
     * information, no blending takes place.</p>
     *
     * <p>If there is a clip rectangle set on the destination (set via
     * SDL_SetClipRect()), then this function will fill based on the intersection
     * of the clip rectangle and {@code rect}.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_FillRects(SDL_Surface, ContiguousArrayList, int)}.</p>
     *
     * @param dst   the SDL_Surface structure that is the drawing target
     * @param rects an array of SDL_Rects representing the rectangles to fill.
     * @param count the number of rectangles in the array
     * @param color the color to fill with
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_FillRect(SDL_Surface, SDL_Rect, int)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_FillRects(
            SDL_Surface dst,
            Pointer rects,
            int count,
            int color);

    /**
     * Performs a fast blit from the source surface to the destination surface.
     *
     * <p>This assumes that the source and destination rectangles are
     * the same size.  If either {@code srcrect} or {@code dstrect} are null, the entire
     * surface ({@code src} or {@code dst}) is copied.  The final blit rectangles are saved
     * in {@code srcrect} and {@code dstrect} after all clipping is performed.</p>
     *
     * <p>The blit function should not be called on a locked surface.</p>
     *
     * <p>The blit semantics for surfaces with and without blending and colorkey
     * are defined as follows:</p>
     * <pre>
     * RGBA-&gt;RGB:
     *   Source surface blend mode set to SDL_BLENDMODE_BLEND:
     *     alpha-blend (using the source alpha-channel and per-surface alpha)
     *     SDL_SRCCOLORKEY ignored.
     *   Source surface blend mode set to SDL_BLENDMODE_NONE:
     *     copy RGB.
     *     if SDL_SRCCOLORKEY set, only copy the pixels matching the
     *     RGB values of the source color key, ignoring alpha in the
     *     comparison.
     *
     * RGB-&gt;RGBA:
     *   Source surface blend mode set to SDL_BLENDMODE_BLEND:
     *     alpha-blend (using the source per-surface alpha)
     *   Source surface blend mode set to SDL_BLENDMODE_NONE:
     *     copy RGB, set destination alpha to source per-surface alpha value.
     *   both:
     *     if SDL_SRCCOLORKEY set, only copy the pixels matching the
     *     source color key.
     *
     * RGBA-&gt;RGBA:
     *   Source surface blend mode set to SDL_BLENDMODE_BLEND:
     *     alpha-blend (using the source alpha-channel and per-surface alpha)
     *     SDL_SRCCOLORKEY ignored.
     *   Source surface blend mode set to SDL_BLENDMODE_NONE:
     *     copy all of RGBA to the destination.
     *     if SDL_SRCCOLORKEY set, only copy the pixels matching the
     *     RGB values of the source color key, ignoring alpha in the
     *     comparison.
     *
     * RGB-&gt;RGB:
     *   Source surface blend mode set to SDL_BLENDMODE_BLEND:
     *     alpha-blend (using the source per-surface alpha)
     *   Source surface blend mode set to SDL_BLENDMODE_NONE:
     *     copy RGB.
     *   both:
     *     if SDL_SRCCOLORKEY set, only copy the pixels matching the
     *     source color key.
     * </pre>
     *
     * <p>For blitting, prefer calling just this function ({@code SDL_BlitSurface()}) unless you know exactly how SDL
     * blitting works internally and how to use the other blit functions.</p>
     *
     * @return 0 if the blit is successful, otherwise it returns -1.
     */
    public static int SDL_BlitSurface(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect) {
        return SDL_UpperBlit(
                src,
                srcRect,
                dst,
                dstRect);
    }

    /**
     * Perform a fast blit from the source surface to the destination surface.
     *
     * <p>SDL_UpperBlit() has been replaced by SDL_BlitSurface(), because it has
     * a less confusing name.</p>
     *
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    @Deprecated
    public static native int SDL_UpperBlit(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    /**
     * Perform low-level surface blitting only.
     *
     * <p>This is a semi-private blit function and it performs low-level surface
     * blitting, assuming the input rectangles have already been clipped.</p>
     *
     * <p>Unless you know what you're doing, you should be using SDL_BlitSurface()
     * instead.</p>
     *
     * @param src     the SDL_Surface structure to be copied from
     * @param srcrect the SDL_Rect structure representing the rectangle to be
     *                copied, or null to copy the entire surface
     * @param dst     the SDL_Surface structure that is the blit target
     * @param dstrect the SDL_Rect structure representing the rectangle that is
     *                copied into
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_BlitSurface(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_LowerBlit(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    /**
     * Perform a fast, low quality, stretch blit between two surfaces of the same
     * format.
     *
     * <p>Please use SDL_BlitScaled() instead.</p>
     *
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_SoftStretch(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    /**
     * Perform bilinear scaling between two surfaces of the same format, 32BPP.
     *
     * @since This function is available since SDL 2.0.16.
     */
    public static native int SDL_SoftStretchLinear(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    /**
     * Perform a scaled surface copy to a destination surface.
     *
     * <p>SDL_BlitScaled() is a replacement for SDL_UpperBlitScaled() with a less confusing name.</p>
     *
     * @see #SDL_BlitScaled(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static int SDL_BlitScaled(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect) {
        return SDL_UpperBlitScaled(
                src,
                srcRect,
                dst,
                dstRect);
    }

    /**
     * Perform a scaled surface copy to a destination surface.
     *
     * <p>SDL_UpperBlitScaled() has been replaced by SDL_BlitScaled(), which is
     * merely a macro for this function with a less confusing name.</p>
     *
     * @see #SDL_BlitScaled(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    @Deprecated
    public static native int SDL_UpperBlitScaled(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect);

    /**
     * Perform low-level surface scaled blitting only.
     *
     * <p>This is a semi-private function and it performs low-level surface blitting,
     * assuming the input rectangles have already been clipped.</p>
     *
     * @param src     the SDL_Surface structure to be copied from
     * @param srcRect the SDL_Rect structure representing the rectangle to be
     *                copied
     * @param dst     the SDL_Surface structure that is the blit target
     * @param dstRect the SDL_Rect structure representing the rectangle that is
     *                copied into
     * @return 0 on success or a negative error code on failure; call
     * SDL_GetError() for more information.
     * @see #SDL_BlitScaled(SDL_Surface, SDL_Rect, SDL_Surface, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native int SDL_LowerBlitScaled(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect);

    /**
     * Set the YUV conversion mode
     *
     * @since This function is available since SDL 2.0.8.
     */
    public static native void SDL_SetYUVConversionMode(
            @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class) int mode);

    /**
     * Get the YUV conversion mode
     *
     * @since This function is available since SDL 2.0.8.
     */
    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static native int SDL_GetYUVConversionMode();

    /**
     * Get the YUV conversion mode, returning the correct mode for the resolution
     * when the current conversion mode is SDL_YUV_CONVERSION_AUTOMATIC
     *
     * @since This function is available since SDL 2.0.8.
     */
    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static native int SDL_GetYUVConversionModeForResolution(
            int width,
            int height);
}
