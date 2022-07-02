package org.libsdl.api.pixels;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import org.intellij.lang.annotations.MagicConstant;
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
        Pointer mem = format.getPointer();
        SDL_FreeFormat(mem);
    }

    public static native void SDL_FreeFormat(
            Pointer format);

    public static native SDL_Palette SDL_AllocPalette(
            int ncolors);

    public static native int SDL_SetPixelFormatPalette(
            SDL_PixelFormat format,
            SDL_Palette palette);

    public static native int SDL_SetPaletteColors(
            SDL_Palette palette,
            SDL_Color colors,
            int firstcolor,
            int ncolors);

    public static void SDL_FreePalette(
            SDL_Palette palette) {
        Pointer mem = palette.getPointer();
        SDL_FreePalette(mem);
    }

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
