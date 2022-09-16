package org.libsdl.api.video;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import org.intellij.lang.annotations.MagicConstant;
import org.libsdl.api.pixels.SDL_PixelFormatEnum;
import org.libsdl.api.rect.SDL_Rect;
import org.libsdl.api.surface.SDL_Surface;
import org.libsdl.jna.ContiguousArrayList;
import org.libsdl.jna.JnaUtils;
import org.libsdl.jna.NativeLoader;

import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_FULLSCREEN;
import static org.libsdl.api.video.SDL_WindowFlags.SDL_WINDOW_FULLSCREEN_DESKTOP;

@SuppressWarnings({
        "checkstyle:MagicNumber",
        "checkstyle:AbbreviationAsWordInName"
})
public final class SdlVideo {

    static {
        NativeLoader.registerNativeMethods(SdlVideo.class);
    }

    private SdlVideo() {
    }

    public static native int SDL_GetNumVideoDrivers();

    public static native String SDL_GetVideoDriver(
            int index);

    public static native int SDL_VideoInit(
            String driverName);

    public static native void SDL_VideoQuit();

    public static native String SDL_GetCurrentVideoDriver();

    public static native int SDL_GetNumVideoDisplays();

    public static native String SDL_GetDisplayName(
            int displayIndex);

    public static native int SDL_GetDisplayBounds(
            int displayIndex,
            SDL_Rect rect);

    public static native int SDL_GetDisplayUsableBounds(
            int displayIndex,
            SDL_Rect rect);

    public static native int SDL_GetDisplayDPI(
            int displayIndex,
            FloatByReference ddpi,
            FloatByReference hdpi,
            FloatByReference vdpi);

    @MagicConstant(valuesFromClass = SDL_DisplayOrientation.class)
    public static native int SDL_GetDisplayOrientation(
            int displayIndex);

    public static native int SDL_GetNumDisplayModes(
            int displayIndex);

    public static native int SDL_GetDisplayMode(
            int displayIndex,
            int modeIndex,
            SDL_DisplayMode mode);

    public static native int SDL_GetDesktopDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode);

    public static native int SDL_GetCurrentDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode);

    public static native SDL_DisplayMode SDL_GetClosestDisplayMode(
            int displayIndex,
            SDL_DisplayMode mode,
            SDL_DisplayMode closest);

    public static native int SDL_GetWindowDisplayIndex(
            SDL_Window window);

    public static native int SDL_SetWindowDisplayMode(
            SDL_Window window,
            SDL_DisplayMode mode);

    public static native int SDL_GetWindowDisplayMode(
            SDL_Window window,
            SDL_DisplayMode mode);

    @MagicConstant(valuesFromClass = SDL_PixelFormatEnum.class)
    public static native int SDL_GetWindowPixelFormat(
            SDL_Window window);

    public static native SDL_Window SDL_CreateWindow(
            String title,
            int x,
            int y,
            int w,
            int h,
            @MagicConstant(flagsFromClass = SDL_WindowFlags.class) int flags);

    public static native SDL_Window SDL_CreateWindowFrom(
            Pointer data);

    public static native int SDL_GetWindowID(
            SDL_Window window);

    public static native SDL_Window SDL_GetWindowFromID(
            int id);

    @MagicConstant(flagsFromClass = SDL_WindowFlags.class)
    public static native int SDL_GetWindowFlags(
            SDL_Window window);

    public static native void SDL_SetWindowTitle(
            SDL_Window window,
            String title);

    public static native String SDL_GetWindowTitle(
            SDL_Window window);

    public static native void SDL_SetWindowIcon(
            SDL_Window window,
            SDL_Surface icon);

    public static native Pointer SDL_SetWindowData(
            SDL_Window window,
            String name,
            Pointer userdata);

    public static native Pointer SDL_GetWindowData(
            SDL_Window window,
            String name);

    public static native void SDL_SetWindowPosition(
            SDL_Window window,
            int x,
            int y);

    public static native void SDL_GetWindowPosition(
            SDL_Window window,
            IntByReference x,
            IntByReference y);

    public static native void SDL_SetWindowSize(
            SDL_Window window,
            int w,
            int h);

    public static native void SDL_GetWindowSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    public static native int SDL_GetWindowBordersSize(
            SDL_Window window,
            IntByReference top,
            IntByReference left,
            IntByReference bottom,
            IntByReference right);

    public static native void SDL_SetWindowMinimumSize(
            SDL_Window window,
            int minW,
            int minH);

    public static native void SDL_GetWindowMinimumSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    public static native void SDL_SetWindowMaximumSize(
            SDL_Window window,
            int maxW,
            int maxH);

    public static native void SDL_GetWindowMaximumSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    public static native void SDL_SetWindowBordered(
            SDL_Window window,
            boolean bordered);

    public static native void SDL_SetWindowResizable(
            SDL_Window window,
            boolean resizable);

    public static native void SDL_SetWindowAlwaysOnTop(
            SDL_Window window,
            boolean onTop);

    public static native void SDL_ShowWindow(
            SDL_Window window);

    public static native void SDL_HideWindow(
            SDL_Window window);

    public static native void SDL_RaiseWindow(
            SDL_Window window);

    public static native void SDL_MaximizeWindow(
            SDL_Window window);

    public static native void SDL_MinimizeWindow(
            SDL_Window window);

    public static native void SDL_RestoreWindow(
            SDL_Window window);

    public static native int SDL_SetWindowFullscreen(
            SDL_Window window,
            @MagicConstant(flags = {SDL_WINDOW_FULLSCREEN, SDL_WINDOW_FULLSCREEN_DESKTOP, 0}) int flags);

    public static native SDL_Surface SDL_GetWindowSurface(
            SDL_Window window);

    public static native int SDL_UpdateWindowSurface(
            SDL_Window window);

    public static int SDL_UpdateWindowSurfaceRects(
            SDL_Window window,
            ContiguousArrayList<SDL_Rect> rects) {
        return SDL_UpdateWindowSurfaceRects(window, rects.autoWriteAndGetPointer(), rects.size());
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_UpdateWindowSurfaceRects(SDL_Window, ContiguousArrayList)}
     */
    @Deprecated
    public static native int SDL_UpdateWindowSurfaceRects(
            SDL_Window window,
            Pointer rects,
            int numrects);

    public static native int SDL_SetWindowGrab(
            SDL_Window window,
            boolean grabbed);

    public static native void SDL_SetWindowKeyboardGrab(
            SDL_Window window,
            boolean grabbed);

    public static native void SDL_SetWindowMouseGrab(
            SDL_Window window,
            boolean grabbed);

    public static native boolean SDL_GetWindowGrab(
            SDL_Window window);

    public static native boolean SDL_GetWindowKeyboardGrab(
            SDL_Window window);

    public static native boolean SDL_GetWindowMouseGrab(
            SDL_Window window);

    public static native SDL_Window SDL_GetGrabbedWindow();

    public static native int SDL_SetWindowBrightness(
            SDL_Window window,
            float brightness);

    public static native float SDL_GetWindowBrightness(
            SDL_Window window);

    public static native int SDL_SetWindowOpacity(
            SDL_Window window,
            float opacity);

    public static native int SDL_GetWindowOpacity(
            SDL_Window window,
            FloatByReference outOpacity);

    public static native int SDL_SetWindowModalFor(
            SDL_Window modalWindow,
            SDL_Window parentWindow);

    public static native int SDL_SetWindowInputFocus(
            SDL_Window window);

    public static int SDL_SetWindowGammaRamp(
            SDL_Window window,
            short[] red,
            short[] green,
            short[] blue) {
        if (red != null && red.length != 256) {
            throw new IllegalArgumentException("Red array length must be 256 but was " + red.length);
        }
        if (green != null && green.length != 256) {
            throw new IllegalArgumentException("Green array length must be 256 but was " + green.length);
        }
        if (blue != null && blue.length != 256) {
            throw new IllegalArgumentException("Blue array length must be 256 but was " + blue.length);
        }
        Pointer redMemory = JnaUtils.writeArrayToNativeMemory(red);
        Pointer greenMemory = JnaUtils.writeArrayToNativeMemory(green);
        Pointer blueMemory = JnaUtils.writeArrayToNativeMemory(blue);
        return SDL_SetWindowGammaRamp(window, redMemory, greenMemory, blueMemory);
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_SetWindowGammaRamp(SDL_Window, short[], short[], short[])}
     */
    @Deprecated
    public static native int SDL_SetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    public static int SDL_GetWindowGammaRamp(
            SDL_Window window,
            short[] red,
            short[] green,
            short[] blue) {
        Memory redMemory = new Memory(256 * 2L);
        Memory greenMemory = new Memory(256 * 2L);
        Memory blueMemory = new Memory(256 * 2L);
        int result = SDL_GetWindowGammaRamp(window, redMemory, greenMemory, blueMemory);
        redMemory.read(0L, red, 0, 256);
        greenMemory.read(0L, green, 0, 256);
        blueMemory.read(0L, blue, 0, 256);
        return result;
    }

    /**
     * @deprecated Use more Java-style {@link #SDL_GetWindowGammaRamp(SDL_Window, short[], short[], short[])}
     */
    @Deprecated
    public static native int SDL_GetWindowGammaRamp(
            SDL_Window window,
            Pointer red,
            Pointer green,
            Pointer blue);

    public static native int SDL_SetWindowHitTest(
            SDL_Window window,
            SDL_HitTest callback,
            Pointer callbackData);

    public static native int SDL_FlashWindow(
            SDL_Window window,
            @MagicConstant(valuesFromClass = SDL_FlashOperation.class) int operation);

    public static native void SDL_DestroyWindow(
            SDL_Window window);

    public static native boolean SDL_IsScreenSaverEnabled();

    public static native void SDL_EnableScreenSaver();

    public static native void SDL_DisableScreenSaver();

    public static native int SDL_GL_LoadLibrary(
            String path);

    public static native Pointer SDL_GL_GetProcAddress(
            String proc);

    public static native void SDL_GL_UnloadLibrary();

    public static native boolean SDL_GL_ExtensionSupported(
            String extension);

    public static native void SDL_GL_ResetAttributes();

    public static native int SDL_GL_SetAttribute(
            @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
            int value);

    public static native int SDL_GL_GetAttribute(
            @MagicConstant(valuesFromClass = SDL_GLattr.class) int attr,
            IntByReference value);

    public static native SDL_GLContext SDL_GL_CreateContext(
            SDL_Window window);

    public static native int SDL_GL_MakeCurrent(
            SDL_Window window,
            SDL_GLContext context);

    public static native SDL_Window SDL_GL_GetCurrentWindow();

    public static native SDL_GLContext SDL_GL_GetCurrentContext();

    public static native void SDL_GL_GetDrawableSize(
            SDL_Window window,
            IntByReference w,
            IntByReference h);

    public static native int SDL_GL_SetSwapInterval(
            int interval);

    public static native int SDL_GL_GetSwapInterval();

    public static native void SDL_GL_SwapWindow(
            SDL_Window window);

    public static native void SDL_GL_DeleteContext(
            SDL_GLContext context);
}
