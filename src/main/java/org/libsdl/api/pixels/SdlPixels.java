package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.jna.ContiguousArrayList;
import org.libsdl.jna.NativeLoader;

@SuppressWarnings({
        "checkstyle:LineLength",
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlPixels {

    static {
        NativeLoader.registerNativeMethods(SdlPixels.class);
    }

    private SdlPixels() {
    }

    public static native String SDL_GetPixelFormatName(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format);

    public static native boolean SDL_PixelFormatEnumToMasks(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format,
            IntByReference bpp,
            IntByReference rMask,
            IntByReference gMask,
            IntByReference bMask,
            IntByReference aMask);

    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public static native int SDL_MasksToPixelFormatEnum(
            int bpp,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    public static native SDL_PixelFormat SDL_AllocFormat(
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int pixelFormat);

    public static void SDL_FreeFormat(
            SDL_PixelFormat format) {
        // Actual deallocation must always be called with a pointer, so extract it and re-call the raw native method. Reason: When a native method has an argument of type Structure, JNA calls Structure.read() to refresh the Java object after the native call. In case of deallocation, this would end up reading from a deallocated memory.
        Pointer mem = format.getPointer();
        SDL_FreeFormat(mem);
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_FreeFormat(SDL_PixelFormat)}
     */
    @Deprecated
    public static native void SDL_FreeFormat(
            Pointer format);

    public static native SDL_Palette SDL_AllocPalette(
            int ncolors);

    public static native int SDL_SetPixelFormatPalette(
            SDL_PixelFormat format,
            SDL_Palette palette);

    public static int SDL_SetPaletteColors(
            SDL_Palette palette,
            ContiguousArrayList<SDL_Color> colors,
            int firstcolor,
            int ncolors) {
        if (ncolors > colors.size()) {
            throw new IllegalArgumentException("ncolors [" + ncolors + "] is greater than the size of the list of colors [" + colors.size() + "]");
        }
        return SDL_SetPaletteColors(palette, colors.autoWriteAndGetPointer(), firstcolor, ncolors);
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_SetPaletteColors(SDL_Palette, ContiguousArrayList, int, int)}
     */
    @Deprecated
    public static native int SDL_SetPaletteColors(
            SDL_Palette palette,
            Pointer colors,
            int firstcolor,
            int ncolors);

    public static void SDL_FreePalette(
            SDL_Palette palette) {
        // Actual deallocation must always be called with a pointer, so extract it and re-call the raw native method. Reason: When a native method has an argument of type Structure, JNA calls Structure.read() to refresh the Java object after the native call. In case of deallocation, this would end up reading from a deallocated memory.
        Pointer mem = palette.getPointer();
        SDL_FreePalette(mem);
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_FreePalette(SDL_Palette)}
     */
    @Deprecated
    public static native void SDL_FreePalette(
            Pointer palette);

    public static native int SDL_MapRGB(
            SDL_PixelFormat format,
            byte r,
            byte g,
            byte b);

    public static native int SDL_MapRGBA(
            SDL_PixelFormat format,
            byte r,
            byte g,
            byte b,
            byte a);

    public static native void SDL_GetRGB(
            int pixel,
            SDL_PixelFormat format,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    public static native void SDL_GetRGBA(
            int pixel,
            SDL_PixelFormat format,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b,
            ByteByReference a);

    public static native void SDL_CalculateGammaRamp(
            float gamma,
            ShortByReference ramp);
}
