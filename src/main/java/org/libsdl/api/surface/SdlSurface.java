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
import static org.libsdl.api.surface.SDL_SurfaceFlags.SDL_RLEACCEL;
import static org.libsdl.api.surface.SDL_SurfaceFlags.SDL_SWSURFACE;

public final class SdlSurface {

    static {
        NativeLoader.registerNativeMethods(SdlSurface.class);
    }

    /**
     * Evaluates to true if the surface needs to be locked before access.
     */
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static boolean SDL_MUSTLOCK(
            SDL_Surface s) {
        return ((s.flags & SDL_RLEACCEL) != 0);
    }

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native SDL_Surface SDL_CreateRGBSurface(
            @MagicConstant(intValues = {0}) int flags,
            int width,
            int height,
            int depth,
            int rMask,
            int gMask,
            int bMask,
            int aMask);

    public static native SDL_Surface SDL_CreateRGBSurfaceWithFormat(
            @MagicConstant(intValues = {0}) int flags,
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

    public static void SDL_FreeSurface(
            SDL_Surface surface) {
        // Actual deallocation must always be called with a pointer, so extract it and re-call the raw native method. Reason: When a native method has an argument of type Structure, JNA calls Structure.read() to refresh the Java object after the native call. In case of deallocation, this would end up reading from a deallocated memory.
        Pointer mem = surface.getPointer();
        SDL_FreeSurface(mem);
    }

    /**
     * @deprecated Use the Java-style {@link #SDL_FreeSurface(SDL_Surface)}
     */
    @Deprecated
    public static native void SDL_FreeSurface(
            Pointer surface);

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
            String file) {
        return SDL_LoadBMP_RW(SDL_RWFromFile(file, "rb"), 1);
    }

    public static native int SDL_SaveBMP_RW(
            SDL_Surface surface,
            SDL_RWops dst,
            int freedst);

    public static int SDL_SaveBMP(
            SDL_Surface surface,
            String file) {
        return SDL_SaveBMP_RW(
                surface,
                SDL_RWFromFile(file, "wb"),
                1);
    }

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

    public static int SDL_FillRects(
            SDL_Surface dst,
            SDL_Rect[] rects,
            int color) {
        if (rects.length == 0) {
            return 0;
        }
        Memory memory = JnaUtils.writeArrayToNativeMemory(rects);
        return SDL_FillRects(dst, memory, rects.length, color);
    }

    public static native int SDL_FillRects(
            SDL_Surface dst,
            Pointer rects,
            int count,
            int color);

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
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect) {
        return SDL_UpperBlitScaled(
                src,
                srcRect,
                dst,
                dstRect);
    }

    @Deprecated
    @SuppressWarnings("DeprecatedIsStillUsed")
    public static native int SDL_UpperBlitScaled(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect);

    public static native int SDL_LowerBlitScaled(
            SDL_Surface src,
            SDL_Rect srcRect,
            SDL_Surface dst,
            SDL_Rect dstRect);

    public static native void SDL_SetYUVConversionMode(
            @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class) int mode);

    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static native int SDL_GetYUVConversionMode();

    @MagicConstant(valuesFromClass = SDL_YUV_CONVERSION_MODE.class)
    public static native int SDL_GetYUVConversionModeForResolution(
            int width,
            int height);
}
