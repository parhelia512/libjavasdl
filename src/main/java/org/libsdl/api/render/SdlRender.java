package org.libsdl.api.render;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.blendmode.SDL_BlendMode;
import org.libsdl.api.pixels.SDL_PixelFormatEnum;
import org.libsdl.api.rect.SDL_FPoint;
import org.libsdl.api.rect.SDL_FRect;
import org.libsdl.api.rect.SDL_Point;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.api.video.SDL_Window;
import org.libsdl.api.video.SDL_WindowFlags;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.NativeLoader;

public final class SdlRender {

    static {
        NativeLoader.registerNativeMethods(SdlRender.class);
    }

    private SdlRender() {
    }

    public static native int SDL_GetNumRenderDrivers();

    public static native int SDL_GetRenderDriverInfo(
            int index,
            SDL_RendererInfo info);

    public static native int SDL_CreateWindowAndRenderer(
            int width,
            int height,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int windowFlags,
            SDL_Window.Ref window,
            SDL_Renderer.Ref renderer);

    public static native SDL_Renderer SDL_CreateRenderer(
            SDL_Window window,
            int index,
            @MagicConstant(valuesFromClass = SDL_RendererFlags.class)
            int flags);

    public static native SDL_Renderer SDL_CreateSoftwareRenderer(
            SDL_Surface surface);

    public static native SDL_Renderer SDL_GetRenderer(
            SDL_Window window);

    public static native int SDL_GetRendererInfo(
            SDL_Renderer renderer,
            SDL_RendererInfo info);

    public static native int SDL_GetRendererOutputSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    public static native SDL_Texture SDL_CreateTexture(
            SDL_Renderer renderer,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) int format,
            @MagicConstant(valuesFromClass = SDL_TextureAccess.class) int access,
            int w,
            int h);

    public static native SDL_Texture SDL_CreateTextureFromSurface(
            SDL_Renderer renderer,
            SDL_Surface surface);

    public static native int SDL_QueryTexture(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class) IntByReference format,
            @MagicConstant(valuesFromClass = SDL_TextureAccess.class) IntByReference access,
            IntByReference w,
            IntByReference h);

    public static native int SDL_SetTextureColorMod(
            SDL_Texture texture,
            byte r,
            byte g,
            byte b);

    public static native int SDL_GetTextureColorMod(
            SDL_Texture texture,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b);

    public static native int SDL_SetTextureAlphaMod(
            SDL_Texture texture,
            byte alpha);

    public static native int SDL_GetTextureAlphaMod(
            SDL_Texture texture,
            ByteByReference alpha);

    public static native int SDL_SetTextureBlendMode(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    public static native int SDL_GetTextureBlendMode(
            SDL_Texture texture,
            SDL_BlendMode.Ref blendMode);

    public static native int SDL_SetTextureScaleMode(
            SDL_Texture texture,
            @MagicConstant(valuesFromClass = SDL_ScaleMode.class) int scaleMode);

    public static native int SDL_GetTextureScaleMode(
            SDL_Texture texture,
            SDL_ScaleMode.Ref scaleMode);

    public static native int SDL_UpdateTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer pixels,
            int pitch);

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native int SDL_UpdateYUVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer yPlane,
            int yPitch,
            Pointer uPlane,
            int uPitch,
            Pointer vPlane,
            int vPitch);

    public static native int SDL_UpdateNVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer yPlane,
            int yPitch,
            Pointer uvPlane,
            int uvPitch);

    public static native int SDL_LockTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            PointerByReference pixels,
            IntByReference pitch);

    // TODO: Test
    public static native int SDL_LockTextureToSurface(
            SDL_Texture texture,
            SDL_Rect rect,
            SDL_Surface.Ref surface);

    public static native void SDL_UnlockTexture(
            SDL_Texture texture);

    public static native boolean SDL_RenderTargetSupported(
            SDL_Renderer renderer);

    public static native int SDL_SetRenderTarget(
            SDL_Renderer renderer,
            SDL_Texture texture);

    public static native SDL_Texture SDL_GetRenderTarget(
            SDL_Renderer renderer);

    public static native int SDL_RenderSetLogicalSize(
            SDL_Renderer renderer,
            int w,
            int h);

    public static native void SDL_RenderGetLogicalSize(
            SDL_Renderer renderer,
            IntByReference w,
            IntByReference h);

    public static native int SDL_RenderSetIntegerScale(
            SDL_Renderer renderer,
            boolean enable);

    public static native boolean SDL_RenderGetIntegerScale(
            SDL_Renderer renderer);

    public static native int SDL_RenderSetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native void SDL_RenderGetViewport(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderSetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native void SDL_RenderGetClipRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native boolean SDL_RenderIsClipEnabled(
            SDL_Renderer renderer);

    public static native int SDL_RenderSetScale(
            SDL_Renderer renderer,
            float scaleX,
            float scaleY);

    public static native void SDL_RenderGetScale(
            SDL_Renderer renderer,
            FloatByReference scaleX,
            FloatByReference scaleY);

    public static native int SDL_SetRenderDrawColor(
            SDL_Renderer renderer,
            byte r,
            byte g,
            byte b,
            byte a);

    public static native int SDL_GetRenderDrawColor(
            SDL_Renderer renderer,
            ByteByReference r,
            ByteByReference g,
            ByteByReference b,
            ByteByReference a);

    public static native int SDL_SetRenderDrawBlendMode(
            SDL_Renderer renderer,
            @MagicConstant(valuesFromClass = SDL_BlendMode.class) int blendMode);

    public static native int SDL_GetRenderDrawBlendMode(
            SDL_Renderer renderer,
            SDL_BlendMode.Ref blendMode);

    public static native int SDL_RenderClear(
            SDL_Renderer renderer);

    public static native int SDL_RenderDrawPoint(
            SDL_Renderer renderer,
            int x,
            int y);

    public static int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            SDL_Point[] points) {
        if (points.length == 0) {
            return 0;
        }
        Memory memory = JnaUtils.writeArrayToNativeMemory(points);
        return SDL_RenderDrawPoints(renderer, memory, points.length);
    }

    public static native int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            Pointer points,
            int count);

    public static native int SDL_RenderDrawLine(
            SDL_Renderer renderer,
            int x1,
            int y1,
            int x2,
            int y2);

    public static int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            SDL_Point[] points) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(points);
        return SDL_RenderDrawLines(renderer, memory, points.length);
    }

    public static native int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            Pointer points,
            int count);

    public static native int SDL_RenderDrawRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            SDL_Rect[] rects) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(rects);
        return SDL_RenderDrawRects(renderer, memory, rects.length);
    }

    public static native int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    public static native int SDL_RenderFillRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static int SDL_RenderFillRects(
            SDL_Renderer renderer,
            SDL_Rect[] rects) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(rects);
        return SDL_RenderFillRects(renderer, memory, rects.length);
    }

    public static native int SDL_RenderFillRects(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    public static native int SDL_RenderCopy(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_Rect dstRect);

    public static native int SDL_RenderCopyEx(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_Rect dstRect,
            double angle,
            SDL_Point center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip);

    public static native int SDL_RenderDrawPointF(
            SDL_Renderer renderer,
            float x,
            float y);

    public static int SDL_RenderDrawPointsF(
            SDL_Renderer renderer,
            SDL_FPoint[] fPoints) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(fPoints);
        return SDL_RenderDrawPointsF(renderer, memory, fPoints.length);
    }

    public static native int SDL_RenderDrawPointsF(
            SDL_Renderer renderer,
            Pointer fPoints,
            int count);

    public static native int SDL_RenderDrawLineF(
            SDL_Renderer renderer,
            float x1,
            float y1,
            float x2,
            float y2);

    public static int SDL_RenderDrawLinesF(
            SDL_Renderer renderer,
            SDL_FPoint[] fPoints) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(fPoints);
        return SDL_RenderDrawLinesF(renderer, memory, fPoints.length);
    }

    public static native int SDL_RenderDrawLinesF(
            SDL_Renderer renderer,
            Pointer fPoints,
            int count);

    public static native int SDL_RenderDrawRectF(
            SDL_Renderer renderer,
            SDL_FRect rect);

    public static int SDL_RenderDrawRectsF(
            SDL_Renderer renderer,
            SDL_FRect[] fRects) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(fRects);
        return SDL_RenderDrawRectsF(renderer, memory, fRects.length);
    }

    public static native int SDL_RenderDrawRectsF(
            SDL_Renderer renderer,
            Pointer fRects,
            int count);

    public static native int SDL_RenderFillRectF(
            SDL_Renderer renderer,
            SDL_FRect rect);

    public static int SDL_RenderFillRectsF(
            SDL_Renderer renderer,
            SDL_FRect[] fRects) {
        Memory memory = JnaUtils.writeArrayToNativeMemory(fRects);
        return SDL_RenderFillRectsF(renderer, memory, fRects.length);
    }

    public static native int SDL_RenderFillRectsF(
            SDL_Renderer renderer,
            Pointer rects,
            int count);

    public static native int SDL_RenderCopyF(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_FRect dstFRect);

    public static native int SDL_RenderCopyExF(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcRect,
            SDL_FRect dstFRect,
            double angle,
            SDL_FPoint center,
            @MagicConstant(valuesFromClass = SDL_RendererFlip.class) int flip);

    public static native int SDL_RenderReadPixels(
            SDL_Renderer renderer,
            SDL_Rect rect,
            int format,
            Pointer pixels,
            int pitch);

    public static native void SDL_RenderPresent(
            SDL_Renderer renderer);

    public static native void SDL_DestroyTexture(
            SDL_Texture texture);

    public static native void SDL_DestroyRenderer(
            SDL_Renderer renderer);

    public static native int SDL_RenderFlush(
            SDL_Renderer renderer);

    public static native int SDL_GL_BindTexture(
            SDL_Texture texture,
            FloatByReference texw,
            FloatByReference texh);

    public static native int SDL_GL_UnbindTexture(
            SDL_Texture texture);

    public static native Pointer SDL_RenderGetMetalLayer(
            SDL_Renderer renderer);

    public static native Pointer SDL_RenderGetMetalCommandEncoder(
            SDL_Renderer renderer);
}
