package io.github.libjsdl.api.render;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import io.github.libjsdl.api.pixels.SDL_Renderer;
import io.github.libjsdl.api.pixels.SDL_RendererInfo;
import io.github.libjsdl.api.pixels.SDL_Texture;
import io.github.libjsdl.api.rect.SDL_Point;
import io.github.libjsdl.api.rect.SDL_Rect;
import io.github.libjsdl.api.surface.SDL_Surface;
import io.github.libjsdl.api.video.SDL_Window;
import io.github.libjsdl.loader.NativeLoader;

public final class SdlRender {

    public static final int SDL_RENDERER_SOFTWARE = 0x00000001;
    public static final int SDL_RENDERER_ACCELERATED = 0x00000002;
    public static final int SDL_RENDERER_PRESENTVSYNC = 0x00000004;
    public static final int SDL_RENDERER_TARGETTEXTURE = 0x00000008;

    public static final int SDL_TEXTUREACCESS_STATIC = 0;
    public static final int SDL_TEXTUREACCESS_STREAMING = 1;
    public static final int SDL_TEXTUREACCESS_TARGET = 2;

    public static final int SDL_TEXTUREMODULATE_NONE = 0x00000000;
    public static final int SDL_TEXTUREMODULATE_COLOR = 0x00000001;
    public static final int SDL_TEXTUREMODULATE_ALPHA = 0x00000002;

    public static final int SDL_FLIP_NONE = 0x00000000;
    public static final int SDL_FLIP_HORIZONTAL = 0x00000001;
    public static final int SDL_FLIP_VERTICAL = 0x00000002;

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
            int windowFlags,
            PointerByReference window,
            PointerByReference renderer);

    public static native SDL_Renderer SDL_CreateRenderer(
            SDL_Window window,
            int index,
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
            int format,
            int access,
            int w,
            int h);

    public static native SDL_Texture SDL_CreateTextureFromSurface(
            SDL_Renderer renderer,
            SDL_Surface surface);

    public static native int SDL_QueryTexture(
            SDL_Texture texture,
            IntByReference format,
            IntByReference access,
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
            int blendMode);

    public static native int SDL_GetTextureBlendMode(
            SDL_Texture texture,
            IntByReference blendMode);

    public static native int SDL_UpdateTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            Pointer pixels,
            int pitch);

    @SuppressWarnings("checkstyle:ParameterNumber")
    public static native int SDL_UpdateYUVTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            ByteByReference yPlane,
            int yPitch,
            ByteByReference uPlane,
            int uPitch,
            ByteByReference vPlane,
            int vPitch);

    public static native int SDL_LockTexture(
            SDL_Texture texture,
            SDL_Rect rect,
            PointerByReference pixels,
            IntByReference pitch);

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
            int blendMode);

    public static native int SDL_GetRenderDrawBlendMode(
            SDL_Renderer renderer,
            IntByReference blendMode);

    public static native int SDL_RenderClear(
            SDL_Renderer renderer);

    public static native int SDL_RenderDrawPoint(
            SDL_Renderer renderer,
            int x,
            int y);

    public static native int SDL_RenderDrawPoints(
            SDL_Renderer renderer,
            SDL_Point points,
            int count);

    public static native int SDL_RenderDrawLine(
            SDL_Renderer renderer,
            int x1,
            int y1,
            int x2,
            int y2);

    public static native int SDL_RenderDrawLines(
            SDL_Renderer renderer,
            SDL_Point points,
            int count);

    public static native int SDL_RenderDrawRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderDrawRects(
            SDL_Renderer renderer,
            SDL_Rect rects,
            int count);

    public static native int SDL_RenderFillRect(
            SDL_Renderer renderer,
            SDL_Rect rect);

    public static native int SDL_RenderFillRects(
            SDL_Renderer renderer,
            SDL_Rect rects,
            int count);

    public static native int SDL_RenderCopy(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcrect,
            SDL_Rect dstrect);

    public static native int SDL_RenderCopyEx(
            SDL_Renderer renderer,
            SDL_Texture texture,
            SDL_Rect srcrect,
            SDL_Rect dstrect,
            double angle,
            SDL_Point center,
            int flip);

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
