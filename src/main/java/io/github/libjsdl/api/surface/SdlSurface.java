package io.github.libjsdl.api.surface;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

import io.github.libjsdl.api.pixels.SDL_Palette;
import io.github.libjsdl.api.pixels.SDL_PixelFormat;
import io.github.libjsdl.api.rect.SDL_Rect;
import io.github.libjsdl.api.rwops.SDL_RWops;
import io.github.libjsdl.api.rwops.SdlRWops;
import io.github.libjsdl.loader.NativeLoader;

public final class SdlSurface {

    public static final int SDL_SWSURFACE = 0;
    public static final int SDL_PREALLOC = 0x00000001;
    public static final int SDL_RLEACCEL = 0x00000002;
    public static final int SDL_DONTFREE = 0x00000004;

    public static final int SDL_YUV_CONVERSION_JPEG = 0;
    public static final int SDL_YUV_CONVERSION_BT601 = 1;
    public static final int SDL_YUV_CONVERSION_BT709 = 2;
    public static final int SDL_YUV_CONVERSION_AUTOMATIC = 3;

    static {
        NativeLoader.loadLibrary(
                SdlSurface.class,
                NativeLoader.NativeLibrary.SDL2);
    }

    private SdlSurface() {
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static boolean SDL_MUSTLOCK(
            final SDL_Surface s) {
        return ((s.flags & SDL_RLEACCEL) != 0);
    }

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native SDL_Surface SDL_CreateRGBSurface(
            int flags,
            int width,
            int height,
            int depth,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    public static native SDL_Surface SDL_CreateRGBSurfaceWithFormat(
            int flags,
            int width,
            int height,
            int depth,
            int format);

    @SuppressWarnings("checkstyle:ParameterNumber")
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

    public static native SDL_Surface SDL_CreateRGBSurfaceWithFormatFrom(
            Pointer pixels,
            int width,
            int height,
            int depth,
            int pitch,
            int format);

    public static native void SDL_FreeSurface(
            SDL_Surface surface);

    public static native int SDL_SetSurfacePalette(
            SDL_Surface surface,
            SDL_Palette palette);

    public static native int SDL_LockSurface(
            SDL_Surface surface);

    public static native void SDL_UnlockSurface(
            SDL_Surface surface);

    public static native SDL_Surface SDL_LoadBMP_RW(
            SDL_RWops src,
            int freesrc);

    public static SDL_Surface SDL_LoadBMP(
            final String file) {
        return SDL_LoadBMP_RW(SdlRWops.SDL_RWFromFile(file, "rb"), 1);
    }

    public static native int SDL_SaveBMP_RW(
            SDL_Surface surface,
            SDL_RWops dst,
            int freedst);

    public static int SDL_SaveBMP(
            final SDL_Surface surface,
            final String file) {
        return SDL_SaveBMP_RW(
                surface,
                SdlRWops.SDL_RWFromFile(file, "wb"),
                1);
    }

    public static native int SDL_SetSurfaceRLE(
            SDL_Surface surface,
            int flag);

    public static native int SDL_SetColorKey(
            SDL_Surface surface,
            int flag,
            int key);

    public static native int SDL_GetColorKey(
            SDL_Surface surface,
            IntByReference key);

    public static native int SDL_SetSurfaceColorMod(
            SDL_Surface surface,
            byte r,
            byte g,
            byte b);

    public static native int SDL_GetSurfaceColorMod(
            SDL_Surface surface,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    public static native int SDL_SetSurfaceAlphaMod(
            SDL_Surface surface,
            byte alpha);

    public static native int SDL_GetSurfaceAlphaMod(
            SDL_Surface surface,
            ByteByReference alpha);

    public static native int SDL_SetSurfaceBlendMode(
            SDL_Surface surface,
            int blendMode);

    public static native int SDL_GetSurfaceBlendMode(
            SDL_Surface surface,
            IntByReference blendMode);

    public static native boolean SDL_SetClipRect(
            SDL_Surface surface,
            SDL_Rect rect);

    public static native void SDL_GetClipRect(
            SDL_Surface surface,
            SDL_Rect rect);

    public static native SDL_Surface SDL_DuplicateSurface(
            SDL_Surface surface);

    public static native SDL_Surface SDL_ConvertSurface(
            SDL_Surface src,
            SDL_PixelFormat fmt,
            int flags);

    public static native SDL_Surface SDL_ConvertSurfaceFormat(
            SDL_Surface src,
            int pixelFormat,
            int flags);

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native int SDL_ConvertPixels(
            int width,
            int height,
            int srcFormat,
            Pointer src,
            int srcPitch,
            int dstFormat,
            Pointer dst,
            int dstPitch);

    public static native int SDL_FillRect(
            SDL_Surface dst,
            SDL_Rect rect,
            int color);

    public static native int SDL_FillRects(
            SDL_Surface dst,
            SDL_Rect rects,
            int count,
            int color);

    public static int SDL_BlitSurface(
            final SDL_Surface src,
            final SDL_Rect srcrect,
            final SDL_Surface dst,
            final SDL_Rect dstrect) {
        return SDL_UpperBlit(
                src,
                srcrect,
                dst,
                dstrect);
    }

    public static native int SDL_UpperBlit(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    public static native int SDL_LowerBlit(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    public static native int SDL_SoftStretch(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    public static int SDL_BlitScaled(
            final SDL_Surface src,
            final SDL_Rect srcrect,
            final SDL_Surface dst,
            final SDL_Rect dstrect) {
        return SDL_UpperBlitScaled(
                src,
                srcrect,
                dst,
                dstrect);
    }

    public static native int SDL_UpperBlitScaled(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    public static native int SDL_LowerBlitScaled(
            SDL_Surface src,
            SDL_Rect srcrect,
            SDL_Surface dst,
            SDL_Rect dstrect);

    public static native void SDL_SetYUVConversionMode(
            int mode);

    public static native int SDL_GetYUVConversionMode();

    public static native int SDL_GetYUVConversionModeForResolution(
            int width,
            int height);
}
