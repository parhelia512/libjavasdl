package org.libsdl.api.surface;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.blendmode.SDL_BlendMode;
import org.libsdl.api.pixels.SDL_Palette;
import org.libsdl.api.pixels.SDL_PixelFormat;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.rwops.SDL_RWops;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.rwops.SdlRWops.SDL_RWFromFile;

public final class SdlSurface {

    /**
     * Just here for compatibility
     */
    public static final int SDL_SWSURFACE = 0;

    /**
     * Surface uses preallocated memory
     */
    public static final int SDL_PREALLOC = 0x00000001;

    /**
     * Surface is RLE encoded
     */
    public static final int SDL_RLEACCEL = 0x00000002;

    /**
     * Surface is referenced internally
     */
    public static final int SDL_DONTFREE = 0x00000004;

    /**
     * Surface uses aligned memory
     */
    public static final int SDL_SIMD_ALIGNED = 0x00000008;

    /**
     * Evaluates to true if the surface needs to be locked before access.
     */
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static boolean SDL_MUSTLOCK(
            SDL_Surface s) {
        return ((s.flags & SDL_RLEACCEL) != 0);
    }

    public static SDL_Surface SDL_CreateRGBSurface(int flags, int width, int height, int depth, int rMask, int gMask, int bMask, int aMask) {
        return NativeFunctions.SDL_CreateRGBSurface(flags, width, height, depth, rMask, gMask, bMask, aMask);
    }

    public static SDL_Surface SDL_CreateRGBSurfaceWithFormat(int flags, int width, int height, int depth, int format) {
        return NativeFunctions.SDL_CreateRGBSurfaceWithFormat(flags, width, height, depth, format);
    }

    public static SDL_Surface SDL_CreateRGBSurfaceFrom(Pointer pixels, int width, int height, int depth, int pitch, int rMask, int gMask, int bMask, int aMask) {
        return NativeFunctions.SDL_CreateRGBSurfaceFrom(pixels, width, height, depth, pitch, rMask, gMask, bMask, aMask);
    }

    public static SDL_Surface SDL_CreateRGBSurfaceWithFormatFrom(Pointer pixels, int width, int height, int depth, int pitch, int format) {
        return NativeFunctions.SDL_CreateRGBSurfaceWithFormatFrom(pixels, width, height, depth, pitch, format);
    }

    public static void SDL_FreeSurface(SDL_Surface surface) {
        NativeFunctions.SDL_FreeSurface(surface);
    }

    public static int SDL_SetSurfacePalette(SDL_Surface surface, SDL_Palette palette) {
        return NativeFunctions.SDL_SetSurfacePalette(surface, palette);
    }

    public static int SDL_LockSurface(SDL_Surface surface) {
        return NativeFunctions.SDL_LockSurface(surface);
    }

    public static void SDL_UnlockSurface(SDL_Surface surface) {
        NativeFunctions.SDL_UnlockSurface(surface);
    }

    public static SDL_Surface SDL_LoadBMP_RW(SDL_RWops src, int freesrc) {
        return NativeFunctions.SDL_LoadBMP_RW(src, freesrc);
    }

    public static SDL_Surface SDL_LoadBMP(
            String file) {
        return SDL_LoadBMP_RW(SDL_RWFromFile(file, "rb"), 1);
    }

    public static int SDL_SaveBMP_RW(SDL_Surface surface, SDL_RWops dst, int freedst) {
        return NativeFunctions.SDL_SaveBMP_RW(surface, dst, freedst);
    }

    public static int SDL_SaveBMP(
            SDL_Surface surface,
            String file) {
        return SDL_SaveBMP_RW(
                surface,
                SDL_RWFromFile(file, "wb"),
                1);
    }

    public static int SDL_SetSurfaceRLE(SDL_Surface surface, int flag) {
        return NativeFunctions.SDL_SetSurfaceRLE(surface, flag);
    }

    public static boolean SDL_HasSurfaceRLE(SDL_Surface surface) {
        return NativeFunctions.SDL_HasSurfaceRLE(surface);
    }

    public static int SDL_SetColorKey(SDL_Surface surface, int flag, int key) {
        return NativeFunctions.SDL_SetColorKey(surface, flag, key);
    }

    public static boolean SDL_HasColorKey(SDL_Surface surface) {
        return NativeFunctions.SDL_HasColorKey(surface);
    }

    public static int SDL_GetColorKey(SDL_Surface surface, IntByReference key) {
        return NativeFunctions.SDL_GetColorKey(surface, key);
    }

    public static int SDL_SetSurfaceColorMod(SDL_Surface surface, byte r, byte g, byte b) {
        return NativeFunctions.SDL_SetSurfaceColorMod(surface, r, g, b);
    }

    public static int SDL_GetSurfaceColorMod(SDL_Surface surface, ByteByReference r, ByteByReference g, ByteByReference b) {
        return NativeFunctions.SDL_GetSurfaceColorMod(surface, r, g, b);
    }

    public static int SDL_SetSurfaceAlphaMod(SDL_Surface surface, byte alpha) {
        return NativeFunctions.SDL_SetSurfaceAlphaMod(surface, alpha);
    }

    public static int SDL_GetSurfaceAlphaMod(SDL_Surface surface, ByteByReference alpha) {
        return NativeFunctions.SDL_GetSurfaceAlphaMod(surface, alpha);
    }

    public static int SDL_SetSurfaceBlendMode(SDL_Surface surface, int blendMode) {
        return NativeFunctions.SDL_SetSurfaceBlendMode(surface, blendMode);
    }

    public static int SDL_GetSurfaceBlendMode(SDL_Surface surface, SDL_BlendMode.Ref blendMode) {
        return NativeFunctions.SDL_GetSurfaceBlendMode(surface, blendMode);
    }

    public static boolean SDL_SetClipRect(SDL_Surface surface, SDL_Rect rect) {
        return NativeFunctions.SDL_SetClipRect(surface, rect);
    }

    public static void SDL_GetClipRect(SDL_Surface surface, SDL_Rect rect) {
        NativeFunctions.SDL_GetClipRect(surface, rect);
    }

    public static SDL_Surface SDL_DuplicateSurface(SDL_Surface surface) {
        return NativeFunctions.SDL_DuplicateSurface(surface);
    }

    public static SDL_Surface SDL_ConvertSurface(SDL_Surface src, SDL_PixelFormat fmt, int flags) {
        return NativeFunctions.SDL_ConvertSurface(src, fmt, flags);
    }

    public static SDL_Surface SDL_ConvertSurfaceFormat(SDL_Surface src, int pixelFormat, int flags) {
        return NativeFunctions.SDL_ConvertSurfaceFormat(src, pixelFormat, flags);
    }

    public static int SDL_ConvertPixels(int width, int height, int srcFormat, Pointer src, int srcPitch, int dstFormat, Pointer dst, int dstPitch) {
        return NativeFunctions.SDL_ConvertPixels(width, height, srcFormat, src, srcPitch, dstFormat, dst, dstPitch);
    }

    public static int SDL_FillRect(SDL_Surface dst, SDL_Rect rect, int color) {
        return NativeFunctions.SDL_FillRect(dst, rect, color);
    }

    public static int SDL_FillRects(
            SDL_Surface dst,
            SDL_Rect[] rects,
            int color) {
        if (rects.length == 0) {
            return 0;
        }
        Memory memory = JnaUtils.writeArrayToNativeMemory(rects);
        return NativeFunctions.SDL_FillRects(dst, memory, rects.length, color);
    }

    public static int SDL_FillRects(SDL_Surface dst, Pointer rects, int count, int color) {
        return NativeFunctions.SDL_FillRects(dst, rects, count, color);
    }

    public static int SDL_BlitSurface(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_BlitSurface(src, srcrect, dst, dstrect);
    }

    @Deprecated
    public static int SDL_UpperBlit(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_UpperBlit(src, srcrect, dst, dstrect);
    }

    public static int SDL_LowerBlit(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_LowerBlit(src, srcrect, dst, dstrect);
    }

    public static int SDL_SoftStretch(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_SoftStretch(src, srcrect, dst, dstrect);
    }

    public static int SDL_SoftStretchLinear(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_SoftStretchLinear(src, srcrect, dst, dstrect);
    }

    public static int SDL_BlitScaled(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_BlitScaled(src, srcrect, dst, dstrect);
    }

    @Deprecated
    public static int SDL_UpperBlitScaled(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_UpperBlitScaled(src, srcrect, dst, dstrect);
    }

    public static int SDL_LowerBlitScaled(SDL_Surface src, SDL_Rect srcrect, SDL_Surface dst, SDL_Rect dstrect) {
        return NativeFunctions.SDL_LowerBlitScaled(src, srcrect, dst, dstrect);
    }

    public static void SDL_SetYUVConversionMode(int mode) {
        NativeFunctions.SDL_SetYUVConversionMode(mode);
    }

    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static int SDL_GetYUVConversionMode() {
        return NativeFunctions.SDL_GetYUVConversionMode();
    }

    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static int SDL_GetYUVConversionModeForResolution(int width, int height) {
        return NativeFunctions.SDL_GetYUVConversionModeForResolution(width, height);
    }

    private static class NativeFunctions {

        static {
            NativeLoader.registerNativeMethods(SdlSurface.NativeFunctions.class);
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

        public static native int SDL_SaveBMP_RW(
                SDL_Surface surface,
                SDL_RWops dst,
                int freedst);

        public static native int SDL_SetSurfaceRLE(
                SDL_Surface surface,
                int flag);

        public static native boolean SDL_HasSurfaceRLE(
                SDL_Surface surface);

        public static native int SDL_SetColorKey(
                SDL_Surface surface,
                int flag,
                int key);

        public static native boolean SDL_HasColorKey(
                SDL_Surface surface);

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
                @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

        public static native int SDL_GetSurfaceBlendMode(
                SDL_Surface surface,
                SDL_BlendMode.Ref blendMode);

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
                Pointer rects,
                int count,
                int color);

        public static int SDL_BlitSurface(
                SDL_Surface src,
                SDL_Rect srcrect,
                SDL_Surface dst,
                SDL_Rect dstrect) {
            return SDL_UpperBlit(
                    src,
                    srcrect,
                    dst,
                    dstrect);
        }

        @Deprecated
        @SuppressWarnings("DeprecatedIsStillUsed")
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

        public static native int SDL_SoftStretchLinear(
                SDL_Surface src,
                SDL_Rect srcrect,
                SDL_Surface dst,
                SDL_Rect dstrect);

        public static int SDL_BlitScaled(
                SDL_Surface src,
                SDL_Rect srcrect,
                SDL_Surface dst,
                SDL_Rect dstrect) {
            return SDL_UpperBlitScaled(
                    src,
                    srcrect,
                    dst,
                    dstrect);
        }

        @Deprecated
        @SuppressWarnings("DeprecatedIsStillUsed")
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
                @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class) int mode);

        @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
        public static native int SDL_GetYUVConversionMode();

        @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
        public static native int SDL_GetYUVConversionModeForResolution(
                int width,
                int height);
    }
}
