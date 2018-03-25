package net.mcclendo.libjavasdl.api.pixels;

import net.mcclendo.libjavasdl.api.stdinc.SdlStdinc;
import net.mcclendo.libjavasdl.loader.NativeLoader;

import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;

@SuppressWarnings({
        "checkstyle:LineLength",
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"})
public final class SdlPixels {

    public static final int SDL_ALPHA_OPAQUE = 255;
    public static final int SDL_ALPHA_TRANSPARENT = 0;

    public static final int SDL_PIXELTYPE_UNKNOWN = 0;
    public static final int SDL_PIXELTYPE_INDEX1 = 1;
    public static final int SDL_PIXELTYPE_INDEX4 = 2;
    public static final int SDL_PIXELTYPE_INDEX8 = 3;
    public static final int SDL_PIXELTYPE_PACKED8 = 4;
    public static final int SDL_PIXELTYPE_PACKED16 = 5;
    public static final int SDL_PIXELTYPE_PACKED32 = 6;
    public static final int SDL_PIXELTYPE_ARRAYU8 = 7;
    public static final int SDL_PIXELTYPE_ARRAYU16 = 8;
    public static final int SDL_PIXELTYPE_ARRAYU32 = 9;
    public static final int SDL_PIXELTYPE_ARRAYF16 = 10;
    public static final int SDL_PIXELTYPE_ARRAYF32 = 11;

    public static final int SDL_BITMAPORDER_NONE = 0;
    public static final int SDL_BITMAPORDER_4321 = 1;
    public static final int SDL_BITMAPORDER_1234 = 2;

    public static final int SDL_PACKEDORDER_NONE = 0;
    public static final int SDL_PACKEDORDER_XRGB = 1;
    public static final int SDL_PACKEDORDER_RGBX = 2;
    public static final int SDL_PACKEDORDER_ARGB = 3;
    public static final int SDL_PACKEDORDER_RGBA = 4;
    public static final int SDL_PACKEDORDER_XBGR = 5;
    public static final int SDL_PACKEDORDER_BGRX = 6;
    public static final int SDL_PACKEDORDER_ABGR = 7;
    public static final int SDL_PACKEDORDER_BGRA = 8;

    public static final int SDL_ARRAYORDER_NONE = 0;
    public static final int SDL_ARRAYORDER_RGB = 1;
    public static final int SDL_ARRAYORDER_RGBA = 2;
    public static final int SDL_ARRAYORDER_ARGB = 3;
    public static final int SDL_ARRAYORDER_BGR = 4;
    public static final int SDL_ARRAYORDER_BGRA = 5;
    public static final int SDL_ARRAYORDER_ABGR = 6;

    public static final int SDL_PACKEDLAYOUT_NONE = 0;
    public static final int SDL_PACKEDLAYOUT_332 = 1;
    public static final int SDL_PACKEDLAYOUT_4444 = 2;
    public static final int SDL_PACKEDLAYOUT_1555 = 3;
    public static final int SDL_PACKEDLAYOUT_5551 = 4;
    public static final int SDL_PACKEDLAYOUT_565 = 5;
    public static final int SDL_PACKEDLAYOUT_8888 = 6;
    public static final int SDL_PACKEDLAYOUT_2101010 = 7;
    public static final int SDL_PACKEDLAYOUT_1010102 = 8;

    public static final int SDL_PIXELFORMAT_UNKNOWN = 0;
    public static final int SDL_PIXELFORMAT_INDEX1LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_4321, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX1MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_1234, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX4LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_4321, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX4MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_1234, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX8 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX8, 0, 0, 8, 1);
    public static final int SDL_PIXELFORMAT_RGB332 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED8, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_332, 8, 1);
    public static final int SDL_PIXELFORMAT_RGB444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_4444, 12, 2);
    public static final int SDL_PIXELFORMAT_RGB555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_BGR555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_ARGB4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_RGBA4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_ABGR4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_BGRA4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_4444, 16, 2);
    public static final int SDL_PIXELFORMAT_ARGB1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_1555, 16, 2);
    public static final int SDL_PIXELFORMAT_RGBA5551 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_5551, 16, 2);
    public static final int SDL_PIXELFORMAT_ABGR1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_1555, 16, 2);
    public static final int SDL_PIXELFORMAT_BGRA5551 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_5551, 16, 2);
    public static final int SDL_PIXELFORMAT_RGB565 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_565, 16, 2);
    public static final int SDL_PIXELFORMAT_BGR565 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_565, 16, 2);
    public static final int SDL_PIXELFORMAT_RGB24 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_ARRAYU8, SDL_ARRAYORDER_RGB, 0, 24, 3);
    public static final int SDL_PIXELFORMAT_BGR24 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_ARRAYU8, SDL_ARRAYORDER_BGR, 0, 24, 3);
    public static final int SDL_PIXELFORMAT_RGB888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_RGBX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_BGR888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_BGRX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_ARGB8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_RGBA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ABGR8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_BGRA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ARGB2101010 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_2101010, 32, 4);

    public static final int SDL_PIXELFORMAT_RGBA32 = SDL_PIXELFORMAT_RGBA8888;
    public static final int SDL_PIXELFORMAT_ARGB32 = SDL_PIXELFORMAT_ARGB8888;
    public static final int SDL_PIXELFORMAT_BGRA32 = SDL_PIXELFORMAT_BGRA8888;
    public static final int SDL_PIXELFORMAT_ABGR32 = SDL_PIXELFORMAT_ABGR8888;

    public static final int SDL_PIXELFORMAT_YV12 = SDL_DEFINE_PIXELFOURCC('Y', 'V', '1', '2');
    public static final int SDL_PIXELFORMAT_IYUV = SDL_DEFINE_PIXELFOURCC('I', 'Y', 'U', 'V');
    public static final int SDL_PIXELFORMAT_YUY2 = SDL_DEFINE_PIXELFOURCC('Y', 'U', 'Y', '2');
    public static final int SDL_PIXELFORMAT_UYVY = SDL_DEFINE_PIXELFOURCC('U', 'Y', 'V', 'Y');
    public static final int SDL_PIXELFORMAT_YVYU = SDL_DEFINE_PIXELFOURCC('Y', 'V', 'Y', 'U');
    public static final int SDL_PIXELFORMAT_NV12 = SDL_DEFINE_PIXELFOURCC('N', 'V', '1', '2');
    public static final int SDL_PIXELFORMAT_NV21 = SDL_DEFINE_PIXELFOURCC('N', 'V', '2', '1');
    public static final int SDL_PIXELFORMAT_EXTERNAL_OES = SDL_DEFINE_PIXELFOURCC('O', 'E', 'S', ' ');

    static {
        NativeLoader.loadLibrary(
                SdlPixels.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlPixels() {
    }

    public static int SDL_DEFINE_PIXELFOURCC(
            final int a,
            final int b,
            final int c,
            final int d) {
        return SdlStdinc.SDL_FOURCC(a, b, c, d);
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static int SDL_DEFINE_PIXELFORMAT(
            final int type,
            final int order,
            final int layout,
            final int bits,
            final int bytes) {
        return ((1 << 28) | ((type) << 24) | ((order) << 20) | ((layout) << 16) | ((bits) << 8) | ((bytes) << 0));
    }

    public static int SDL_PIXELFLAG(
            final int x) {
        return (((x) >> 28) & 0x0F);
    }

    public static int SDL_PIXELTYPE(
            final int x) {
        return (((x) >> 24) & 0x0F);
    }

    public static int SDL_PIXELORDER(final int x) {
        return (((x) >> 20) & 0x0F);
    }

    public static int SDL_PIXELLAYOUT(
            final int x) {
        return (((x) >> 16) & 0x0F);
    }

    public static int SDL_BITSPERPIXEL(final int x) {
        return (((x) >> 8) & 0xFF);
    }

    public static int SDL_BYTESPERPIXEL(
            final int x) {
        return (SDL_ISPIXELFORMAT_FOURCC(x)
                ? ((((x) == SDL_PIXELFORMAT_YUY2)
                || ((x) == SDL_PIXELFORMAT_UYVY)
                || ((x) == SDL_PIXELFORMAT_YVYU)) ? 2 : 1) : (((x) >> 0) & 0xFF));
    }

    public static boolean SDL_ISPIXELFORMAT_INDEXED(
            final int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX1)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX4)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX8)));
    }

    public static boolean SDL_ISPIXELFORMAT_PACKED(
            final int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED32)));
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static boolean SDL_ISPIXELFORMAT_ARRAY(
            final int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU32)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF32)));
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static boolean SDL_ISPIXELFORMAT_ALPHA(
            final int format) {
        return ((SDL_ISPIXELFORMAT_PACKED(format)
                && ((SDL_PIXELORDER(format) == SDL_PACKEDORDER_ARGB)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_RGBA)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_ABGR)
                || (SDL_PIXELORDER(format) == SDL_PACKEDORDER_BGRA)))
                || (SDL_ISPIXELFORMAT_ARRAY(format)
                && ((SDL_PIXELORDER(format) == SDL_ARRAYORDER_ARGB)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_RGBA)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_ABGR)
                || (SDL_PIXELORDER(format) == SDL_ARRAYORDER_BGRA))));
    }

    public static boolean SDL_ISPIXELFORMAT_FOURCC(
            final int format) {
        return ((format != 0) && (SDL_PIXELFLAG(format) != 1));
    }

    public static native String SDL_GetPixelFormatName(
            int format);

    public static native boolean SDL_PixelFormatEnumToMasks(
            int format,
            IntByReference bpp,
            IntByReference rMask,
            IntByReference gMask,
            IntByReference bMask,
            IntByReference aMask);

    public static native int SDL_MasksToPixelFormatEnum(
            int bpp,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    public static native SDL_PixelFormat SDL_AllocFormat(
            int pixelFormat);

    public static native void SDL_FreeFormat(
            SDL_PixelFormat format);

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

    public static native void SDL_FreePalette(
            SDL_Palette palette);

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
