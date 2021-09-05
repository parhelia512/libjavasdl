package org.libsdl.api.pixels;

import org.libsdl.api.stdinc.SdlStdinc;
import org.libsdl.jna.JnaEnum;

import static org.libsdl.api.endian.SdlEndianConst.SDL_BIG_ENDIAN;
import static org.libsdl.api.endian.SdlEndianConst.SDL_BYTEORDER;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_ABGR;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_ARGB;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_BGR;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_BGRA;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_RGB;
import static org.libsdl.api.pixels.SDL_ArrayOrder.SDL_ARRAYORDER_RGBA;
import static org.libsdl.api.pixels.SDL_BitmapOrder.SDL_BITMAPORDER_1234;
import static org.libsdl.api.pixels.SDL_BitmapOrder.SDL_BITMAPORDER_4321;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_1555;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_2101010;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_332;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_4444;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_5551;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_565;
import static org.libsdl.api.pixels.SDL_PackedLayout.SDL_PACKEDLAYOUT_8888;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_ABGR;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_ARGB;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_BGRA;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_BGRX;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_RGBA;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_RGBX;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_XBGR;
import static org.libsdl.api.pixels.SDL_PackedOrder.SDL_PACKEDORDER_XRGB;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYF16;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYF32;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU16;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU32;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_ARRAYU8;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX1;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX4;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_INDEX8;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED16;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED32;
import static org.libsdl.api.pixels.SDL_PixelType.SDL_PIXELTYPE_PACKED8;

public final class SDL_PixelFormatEnum implements JnaEnum {

    public static final int SDL_PIXELFORMAT_UNKNOWN = 0;
    public static final int SDL_PIXELFORMAT_INDEX1LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_4321, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX1MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX1, SDL_BITMAPORDER_1234, 0, 1, 0);
    public static final int SDL_PIXELFORMAT_INDEX4LSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_4321, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX4MSB = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX4, SDL_BITMAPORDER_1234, 0, 4, 0);
    public static final int SDL_PIXELFORMAT_INDEX8 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_INDEX8, 0, 0, 8, 1);
    public static final int SDL_PIXELFORMAT_RGB332 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED8, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_332, 8, 1);
    public static final int SDL_PIXELFORMAT_XRGB4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_4444, 12, 2);
    public static final int SDL_PIXELFORMAT_RGB444 = SDL_PIXELFORMAT_XRGB4444;
    public static final int SDL_PIXELFORMAT_XBGR4444 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_4444, 12, 2);
    public static final int SDL_PIXELFORMAT_BGR444 = SDL_PIXELFORMAT_XBGR4444;
    public static final int SDL_PIXELFORMAT_XRGB1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_RGB555 = SDL_PIXELFORMAT_XRGB1555;
    public static final int SDL_PIXELFORMAT_XBGR1555 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED16, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_1555, 15, 2);
    public static final int SDL_PIXELFORMAT_BGR555 = SDL_PIXELFORMAT_XBGR1555;
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
    public static final int SDL_PIXELFORMAT_XRGB8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XRGB, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_RGB888 = SDL_PIXELFORMAT_XRGB8888;
    public static final int SDL_PIXELFORMAT_RGBX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_XBGR8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_XBGR, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_BGR888 = SDL_PIXELFORMAT_XBGR8888;
    public static final int SDL_PIXELFORMAT_BGRX8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRX, SDL_PACKEDLAYOUT_8888, 24, 4);
    public static final int SDL_PIXELFORMAT_ARGB8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_RGBA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_RGBA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ABGR8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ABGR, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_BGRA8888 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_BGRA, SDL_PACKEDLAYOUT_8888, 32, 4);
    public static final int SDL_PIXELFORMAT_ARGB2101010 = SDL_DEFINE_PIXELFORMAT(SDL_PIXELTYPE_PACKED32, SDL_PACKEDORDER_ARGB, SDL_PACKEDLAYOUT_2101010, 32, 4);

    /* Aliases for RGBA byte arrays of color data, for the current platform */
    public static final int SDL_PIXELFORMAT_RGBA32;
    public static final int SDL_PIXELFORMAT_ARGB32;
    public static final int SDL_PIXELFORMAT_BGRA32;
    public static final int SDL_PIXELFORMAT_ABGR32;

    static {
        if (SDL_BYTEORDER == SDL_BIG_ENDIAN) {
            SDL_PIXELFORMAT_RGBA32 = SDL_PIXELFORMAT_RGBA8888;
            SDL_PIXELFORMAT_ARGB32 = SDL_PIXELFORMAT_ARGB8888;
            SDL_PIXELFORMAT_BGRA32 = SDL_PIXELFORMAT_BGRA8888;
            SDL_PIXELFORMAT_ABGR32 = SDL_PIXELFORMAT_ABGR8888;
        } else {
            SDL_PIXELFORMAT_RGBA32 = SDL_PIXELFORMAT_ABGR8888;
            SDL_PIXELFORMAT_ARGB32 = SDL_PIXELFORMAT_BGRA8888;
            SDL_PIXELFORMAT_BGRA32 = SDL_PIXELFORMAT_ARGB8888;
            SDL_PIXELFORMAT_ABGR32 = SDL_PIXELFORMAT_RGBA8888;
        }
    }

    public static final int SDL_PIXELFORMAT_YV12 = SDL_DEFINE_PIXELFOURCC('Y', 'V', '1', '2');
    public static final int SDL_PIXELFORMAT_IYUV = SDL_DEFINE_PIXELFOURCC('I', 'Y', 'U', 'V');
    public static final int SDL_PIXELFORMAT_YUY2 = SDL_DEFINE_PIXELFOURCC('Y', 'U', 'Y', '2');
    public static final int SDL_PIXELFORMAT_UYVY = SDL_DEFINE_PIXELFOURCC('U', 'Y', 'V', 'Y');
    public static final int SDL_PIXELFORMAT_YVYU = SDL_DEFINE_PIXELFOURCC('Y', 'V', 'Y', 'U');
    public static final int SDL_PIXELFORMAT_NV12 = SDL_DEFINE_PIXELFOURCC('N', 'V', '1', '2');
    public static final int SDL_PIXELFORMAT_NV21 = SDL_DEFINE_PIXELFOURCC('N', 'V', '2', '1');
    public static final int SDL_PIXELFORMAT_EXTERNAL_OES = SDL_DEFINE_PIXELFOURCC('O', 'E', 'S', ' ');

    public static int SDL_DEFINE_PIXELFOURCC(
            int a,
            int b,
            int c,
            int d) {
        return SdlStdinc.SDL_FOURCC(a, b, c, d);
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static int SDL_DEFINE_PIXELFORMAT(
            int type,
            int order,
            int layout,
            int bits,
            int bytes) {
        return (1 << 28) | (type << 24) | (order << 20) | (layout << 16) | (bits << 8) | bytes;
    }

    public static int SDL_PIXELFLAG(
            int x) {
        return (x >> 28) & 0x0F;
    }

    public static int SDL_PIXELTYPE(
            int x) {
        return (x >> 24) & 0x0F;
    }

    public static int SDL_PIXELORDER(final int x) {
        return (x >> 20) & 0x0F;
    }

    public static int SDL_PIXELLAYOUT(
            int x) {
        return (x >> 16) & 0x0F;
    }

    public static int SDL_BITSPERPIXEL(final int x) {
        return (x >> 8) & 0xFF;
    }

    public static int SDL_BYTESPERPIXEL(
            int x) {
        return (SDL_ISPIXELFORMAT_FOURCC(x)
                ? (((x == SDL_PIXELFORMAT_YUY2)
                || (x == SDL_PIXELFORMAT_UYVY)
                || (x == SDL_PIXELFORMAT_YVYU)) ? 2 : 1) : (x & 0xFF));
    }

    public static boolean SDL_ISPIXELFORMAT_INDEXED(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX1)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX4)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_INDEX8)));
    }

    public static boolean SDL_ISPIXELFORMAT_PACKED(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_PACKED32)));
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static boolean SDL_ISPIXELFORMAT_ARRAY(
            int format) {
        return (!SDL_ISPIXELFORMAT_FOURCC(format)
                && ((SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU8)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYU32)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF16)
                || (SDL_PIXELTYPE(format) == SDL_PIXELTYPE_ARRAYF32)));
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static boolean SDL_ISPIXELFORMAT_ALPHA(
            int format) {
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
            int format) {
        return (format != 0) && (SDL_PIXELFLAG(format) != 1);
    }
}
